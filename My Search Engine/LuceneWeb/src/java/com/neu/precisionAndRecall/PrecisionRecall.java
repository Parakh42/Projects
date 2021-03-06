/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.precisionAndRecall;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import org.apache.lucene.benchmark.quality.Judge;
import org.apache.lucene.benchmark.quality.QualityBenchmark;
import org.apache.lucene.benchmark.quality.QualityQuery;
import org.apache.lucene.benchmark.quality.QualityQueryParser;
import org.apache.lucene.benchmark.quality.QualityStats;
import org.apache.lucene.benchmark.quality.trec.TrecJudge;
import org.apache.lucene.benchmark.quality.trec.TrecTopicsReader;
import org.apache.lucene.benchmark.quality.utils.SimpleQQParser;
import org.apache.lucene.benchmark.quality.utils.SubmissionReport;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author parak
 */
public class PrecisionRecall {

    private static final String INDEX_DIR = "C:\\Users\\parak\\OneDrive\\Documents\\NetBeansProjects\\Algorithm Assignments\\LuceneWeb\\IndexPath";

    public static void main(String[] args) throws Throwable {

        File topicsFile = new File("C:\\Users\\parak\\OneDrive\\Documents\\NetBeansProjects\\Algorithm Assignments\\LuceneWeb\\topics.txt");
        File qrelsFile = new File("C:\\Users\\parak\\OneDrive\\Documents\\NetBeansProjects\\Algorithm Assignments\\LuceneWeb\\qrels.txt");
        Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));
        //Searcher searcher = new IndexSearcher(dir, true);
        IndexReader reader = DirectoryReader.open(dir);
        //CreateIndexReader reader = DirectoryReader.open(dir); lucene searcher. It search over a single IndexReader.
        IndexSearcher searcher = new IndexSearcher(reader);

        String docNameField = "name";

        PrintWriter logger = new PrintWriter(System.out, true);

        TrecTopicsReader qReader = new TrecTopicsReader();   //#1
        QualityQuery qqs[] = qReader.readQueries( //#1
                new BufferedReader(new FileReader(topicsFile))); //#1

        Judge judge = new TrecJudge(new BufferedReader( //#2
                new FileReader(qrelsFile)));                     //#2

        judge.validateData(qqs, logger);                     //#3

        QualityQueryParser qqParser = new SimpleQQParser("title", "contents");  //#4

        QualityBenchmark qrun = new QualityBenchmark(qqs, qqParser, searcher, docNameField);
        SubmissionReport submitLog = null;
        QualityStats stats[] = qrun.execute(judge, //#5
                submitLog, logger);

        QualityStats avg = QualityStats.average(stats);      //#6
        avg.log("SUMMARY", 2, logger, "  ");
        dir.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.indexAndSearch;

//import java.io.BufferedReader;
import com.neu.beans.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpRequest;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
//import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author parak
 */
public class SearchFiles {

    //  private Data data;
//    String[] fileName;
//    String[] frags;
    List<Data> conArray;

    public SearchFiles() {
        //fileName = new ArrayList();
        //snippet = new ArrayList();
        //  data = new Data();
        conArray = new ArrayList<>();
    }

    //This contains the lucene indexed documents
    private static final String INDEX_DIR = "C:\\Users\\parak\\OneDrive\\Documents\\NetBeansProjects\\Algorithm Assignments\\LuceneWeb\\IndexPath";

    public List<Data> searching(String key, String key1, String radio) throws IOException, ParseException, InvalidTokenOffsetsException {
        //Get directory reference
        Directory dir = FSDirectory.open(Paths.get(INDEX_DIR));

        //Index reader - an interface for accessing a point-in-time view of a lucene index
        IndexReader reader = DirectoryReader.open(dir);

        //CreateIndexReader reader = DirectoryReader.open(dir); lucene searcher. It search over a single IndexReader.
        IndexSearcher searcher = new IndexSearcher(reader);

        //analyzer with the default stop words
        Analyzer analyzer = new StandardAnalyzer();

        //Query parser to be used for creating TermQuery
        //QueryParser qp = new QueryParser("contents", analyzer);
        //prompt user for query
        String queries = null;
        String queryString = null;   //regular search
        String field = "contents";
        BufferedReader in = null;
        if (queries != null) {
            in = Files.newBufferedReader(Paths.get(queries), StandardCharsets.UTF_8);
        } else {
            in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        }
        QueryParser parser = new QueryParser(field, analyzer);

//        while (true) {
//            if (queries == null && queryString == null) {                        // prompt the user
//                System.out.println("Enter query: ");
//            }
//
//            String line = queryString != null ? queryString : in.readLine();
//
//            if (line == null || line.length() == -1) {
//                break;
//            }
//
//            line = line.trim();
//            if (line.length() == 0) {
//                break;
//            }
        //print index
        int n = reader.numDocs();
        //System.out.println("!@#$%%^&*(()("+n);
        for (int i = 0; i < n; i++) {

            //{
            Document d = reader.document(i);
            //System.out.println( "d=" +d);
            //}
        }

        String q1 = "\"" + key + "\"";
        String q2 = "\"" + key1 + "\"";
        //String parakh1 = "piyush";
        //String p = "+"+q+" "+"+"+parakh1 ;

//            String q = "/"""+key+"/""";
        Query query = parser.parse(q1);
        Query query1 = parser.parse(q2);
//             //operator
        BooleanQuery.Builder apiQuery = new BooleanQuery.Builder();
        if (radio.equals("conjunction")) {
            apiQuery.add(query, BooleanClause.Occur.MUST);
            apiQuery.add(query1, BooleanClause.Occur.MUST);
            apiQuery.build();
        } else if (radio.equals("disjunction")) {
            apiQuery.add(query, BooleanClause.Occur.SHOULD);
            apiQuery.add(query1, BooleanClause.Occur.SHOULD);
            apiQuery.build();
        } else {
            apiQuery.add(query, BooleanClause.Occur.MUST);
            apiQuery.add(query1, BooleanClause.Occur.MUST_NOT);
            apiQuery.build();
        }
        // System.out.println("Searching for: " + query.toString(field));
        // System.out.println("===================== "+query.toString(field)+" is in the following files:- =====================");

        //Create the query
        // Query query = qp.parse("cottage private discovery concluded");
        //Search the lucene documents
        TopDocs hits = searcher.search(apiQuery.build(), 10);
        // TopScoreDocCollector collector = TopScoreDocCollector.create(5);

        /**
         * Highlighter Code Start ***
         */
        //Uses HTML &lt;B&gt;&lt;/B&gt; tag to highlight the searched terms
        Formatter formatter = new SimpleHTMLFormatter();

        //It scores text fragments by the number of unique query terms found
        //Basically the matching score in layman terms
        QueryScorer scorer = new QueryScorer(apiQuery.build());

        //used to markup highlighted terms found in the best sections of a text
        Highlighter highlighter = new Highlighter(formatter, scorer);

        //It breaks text up into same-size texts but does not split up spans
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer, 30);

        //breaks text up into same-size fragments with no concerns over spotting sentence boundaries.
        //Fragmenter fragmenter = new SimpleFragmenter(10);
        //set fragmenter to highlighter
        highlighter.setTextFragmenter(fragmenter);

        //System.out.println("====================================================="+hits.scoreDocs.length);
        //List<Data> dataList = new ArrayList<Data>();
        //Iterate over found results
        for (int i = 0; i < hits.scoreDocs.length; i++) {
            Data data = new Data();
            //int rank = hits.scoreDocs.length;
            int outResult = hits.scoreDocs.length;
            data.setResult(outResult);
            int docid = hits.scoreDocs[i].doc;
            double rank = hits.scoreDocs[i].score;
            data.setRankingScore(rank);
            Document doc = searcher.doc(docid);
            // String title = doc.get("title");
            String name = doc.get("name");
            String title = doc.get("title");
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&************************" + title);
            // System.out.println((i + 1) + ". " + doc.get("path") + " score=" + hits[i].score);
            data.setFileName(name);

            String path = doc.get("path");
            data.setPath(path);

            //  System.out.println("FileName: " + " : " + name);
            //Printing - to which document result belongs
//                if(title != null){
//                System.out.println("FileName " + " : " + title);
            //Get stored text from found document
            String text = doc.get("contents");

            //Create token stream
            TokenStream stream = TokenSources.getAnyTokenStream(reader, docid, "contents", analyzer);

            //Get highlighted text fragments
            String[] frags = highlighter.getBestFragments(stream, text, 10);
            //String[] frags111 = highlighter.getBestTextFragments(stream, text, true, rank);
            ArrayList<String> parakh = new ArrayList<>();
            for (String frag : frags) {

                //data.setContentsArray(frag);
                // conArray.add(frag);
                //System.out.println("Snippet: " + frag);
//                    System.out.println("=======================");
                parakh.add(frag);
            }
//                }else{
//                    System.out.println("No match found");
//                }
//                    for(String s : parakh){
//                System.out.println("---------------------" +s);
//            }
            data.setContentsArray(parakh);
            conArray.add(data);
        }

        dir.close();
        // }
        return conArray;
    }
}

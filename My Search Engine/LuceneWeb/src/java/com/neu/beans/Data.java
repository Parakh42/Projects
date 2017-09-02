/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author parak
 */
public class Data {

    private int result;
    private String fileName;
    private double rankingScore;
    private String path;
    // private String contents;
    List<String> contentsArray;

    public Data() {
        contentsArray = new ArrayList<>();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//    public String getContents() {
//        return contents;
//    }
//
//    public void setContents(String contents) {
//        this.contents = contents;
//    }
    public List<String> getContentsArray() {
        return contentsArray;
    }

    public void setContentsArray(List<String> contentsArray) {
        this.contentsArray = contentsArray;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getRankingScore() {
        return rankingScore;
    }

    public void setRankingScore(double rankingScore) {
        this.rankingScore = rankingScore;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}

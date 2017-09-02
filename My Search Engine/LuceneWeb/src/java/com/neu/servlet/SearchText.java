/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.servlet;

import com.google.gson.Gson;
import com.neu.beans.Data;
import com.neu.indexAndSearch.IndexFiles;
import com.neu.indexAndSearch.SearchFiles;
import com.neu.indexAndSearch.SingleSearchFile;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 *
 * @author parak
 */
public class SearchText extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, TikaException, SAXException, ParseException, InvalidTokenOffsetsException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String key = request.getParameter("wordSearch");
        String key1 = request.getParameter("wordSearch1");
        String radio = request.getParameter("optradio");
        //System.out.println("111111111111111111111111111111"+radio);
        //Gson gson = new Gson();
        //String json = gson.toJson();
        IndexFiles idd = new IndexFiles();
        idd.indexing();
        SearchFiles sf = new SearchFiles();
        List<Data> outArray = sf.searching(key, key1, radio);
//        for(int i = 0; i <= outArray.size(); i++){
//            System.out.println("**************8"+outArray.get(i));
//        }
        session.setAttribute("outArray", outArray);
        if (outArray.isEmpty()) {
            response.sendRedirect("noResult.jsp");
        } else {
            response.sendRedirect("search.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (TikaException ex) {
            Logger.getLogger(SearchText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SearchText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SearchText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidTokenOffsetsException ex) {
            Logger.getLogger(SearchText.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String key = request.getParameter("wordSearch");

            IndexFiles idd = new IndexFiles();
            try {
                idd.indexing();
            } catch (TikaException ex) {
                Logger.getLogger(SearchText.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(SearchText.class.getName()).log(Level.SEVERE, null, ex);
            }
            SingleSearchFile ssf = new SingleSearchFile();
            List<Data> outArray1 = ssf.searching(key);
//        for(int i = 0; i <= outArray.size(); i++){
//            System.out.println("**************8"+outArray.get(i));
//        }
            session.setAttribute("outArray", outArray1);
            if (outArray1.isEmpty()) {
                response.sendRedirect("noResult.jsp");
            } else {
                response.sendRedirect("search.jsp");
            }
        } catch (ParseException ex) {
            Logger.getLogger(SearchText.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidTokenOffsetsException ex) {
            Logger.getLogger(SearchText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.QuestionPossibleAnswers;
import models.User;
import models.UserAnswers;
import services.ExamImpl;

/**
 *
 * @author Walter
 */
public class Exam extends HttpServlet {
    ExamImpl examService;
    
    public Exam(){
        examService = new ExamImpl();
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
         // Get questions from service
        List<QuestionPossibleAnswers> questionsWithPossibleAnswers = examService.getQuestionsWithPossibleAnswers();

        // Send questions to front
        HttpSession s = request.getSession();
        s.setAttribute("questionsWithPossibleAnswers", questionsWithPossibleAnswers);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
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
        // Get user and selected answers from parameters
        HttpSession s = request.getSession();
        UserAnswers userAnswers = (UserAnswers)s.getAttribute("userAnswers");
        User user = userAnswers.getUser();

        // Save to db via the examService
        examService.saveUser(user);
        examService.saveUserSelectedAnswers(userAnswers);

        // Get Results
        s.setAttribute("result", examService.getResult(user));
        // Forward to index.jsp
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
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

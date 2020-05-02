/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Question;
import java.util.List;
import models.Result;
import models.UserAnswers;

/**
 *
 * @author Walter
 */
public interface IExam {
    // Get questions from databse
    List<Question> getQuestions();
    
    // Save selected answers to db from the user input
    boolean saveAnswers(UserAnswers userAnswers);
    
    // Get result from db
    Result getResult();
}

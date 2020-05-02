/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.QuestionPossibleAnswers;
import models.Result;
import models.User;
import models.UserAnswers;


/**
 *
 * @author Walter
 */
public interface IExam {
    // Get questions from databse
    List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers();
    
    // Save User to db
    boolean saveUser(User user);
    
    // Save selected answers to db from the user input
    boolean saveUserSelectedAnswers(UserAnswers userAnswers);
    
    // Get result from db
    Result getResult(User user);
}

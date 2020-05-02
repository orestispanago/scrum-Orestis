/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author Walter
 */
public class Result {
    User user;
    List<QuestionPossibleAnswers> questionsPossibleAnswers;
    List<QuestionSelectedAnswer> selectedAnswers;
    List<QuestionRightAnswer> questionsRightAnswers;
}

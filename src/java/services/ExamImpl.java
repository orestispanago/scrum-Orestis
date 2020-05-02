/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DummyData.DummyData;
import java.util.ArrayList;
import java.util.List;
import models.Answer;
import models.Question;
import models.QuestionPossibleAnswers;
import models.QuestionRightAnswer;
import models.QuestionSelectedAnswer;
import models.Result;
import models.User;
import models.UserAnswers;

/**
 *
 * @author Walter
 */
public class ExamImpl implements IExam {

    @Override
    public List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers() {
//        List<QuestionAnswers> questionAnswers = examDao.getQuestionAnswers();
//        if (questionAnswers.size() == 0){
//            // Oops, there are no questions
//            return null;
//        }
//        return questionAnswers;

        // *********** TESTING ************
        return DummyData.getQuestionsWithPossibleAnswers();
    }

    @Override
    public boolean saveUserSelectedAnswers(UserAnswers userAnswers) {
        //boolean saved = examDao.saveUserSelectedAnswers(userAnswers);
//        if (!saved){
//            //  oops something went wrong
//            return false;
//        }
//        return true;
        
        // To be deleted
        return false;
    }

    @Override
    public Result getResult(User user) {
//        Result result = examDao.getResult(User user);
//        if (result == null){
//            // oops
//            return null;
//        }
//        return result;


        // *********** TESTING ************
        return DummyData.getResult(user);
    }

    @Override
    public boolean saveUser(User user){
        // call saveUser from dao
        
        // To be deleted
        return false;
    }
}

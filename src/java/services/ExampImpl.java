/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.QuestionPossibleAnswers;
import models.Result;
import models.UserAnswers;

/**
 *
 * @author Walter
 */
//public class ExampImpl implements IExam {
//
//    @Override
//    public List<QuestionAnswers> getQuestionAnswers() {
//        List<QuestionAnswers> questionAnswers = examDao.getQuestionAnswers();
//        if (questionAnswers.size() == 0){
//            // Oops, there are no questions
//            return null;
//        }
//        return questionAnswers;
//    }
//
//    @Override
//    public boolean saveAnswers(UserAnswers userAnswers) {
//        //boolean saved = examDao.saveAnswers(userAnswers);
//        if (!saved){
//            //  oops something went wrong
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public Result getResult() {
//        Result result = examDao.getResult();
//        if (result == null){
//            // oops
//            return null;
//        }
//        return result;
//    }
//    
//}

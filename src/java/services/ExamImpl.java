/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DummyData.DummyData;
import dao.ExamDaoImpl;
import java.util.List;
import models.QuestionPossibleAnswers;
import models.Result;
import models.User;
import models.UserAnswers;

/**
 *
 * @author Walter
 */
public class ExamImpl implements IExam {
    private ExamDaoImpl examDao;
    
    public ExamImpl(){
        examDao = new ExamDaoImpl();
    }
    
    @Override
    public List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers() {
        List<QuestionPossibleAnswers> qpas = examDao.getQuestionsWithPossibleAnswers();
        if (qpas.size() == 0){
            // Oops, there are no questions
            return null;
        }
        return qpas;

//         *********** TESTING ************
       // return DummyData.getQuestionsWithPossibleAnswers();
    }

    @Override
    public boolean saveUserSelectedAnswers(UserAnswers userAnswers) {
        if (userAnswers == null){
            //  oops something went wrong
            return false;
        }
         System.out.println("************ SERVICE USER: " + userAnswers.getUser());
        boolean saved = examDao.saveUserSelectedAnswers(userAnswers);
        System.out.println("************ SERVICE USER after: " + userAnswers.getUser());
        System.out.println("************ examDao saved: " + saved);
       
        if (!saved){
            //  oops something went wrong
            return false;
        }
        return true;
    }

    @Override
    public Result getResult(User user) {
        Result result = examDao.getResult(user);
        if (result == null){
            // oops, something went wrong
            return null;
        }
        return result;


        // *********** TESTING ************
//        return DummyData.getResult(user);
    }

    @Override
    public boolean saveUser(User user){
        if (user == null){
            // oops, something went wrong
            return false;
        }
        
        boolean saved = examDao.saveUser(user);
        if (!saved){
            //  oops something went wrong
            return false;
        }
        return true;
    }
}

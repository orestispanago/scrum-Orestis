package dao;

import static dao.QuestionPossibleAnswersData.getOne;
import java.util.ArrayList;
import java.util.List;
import models.QuestionPossibleAnswers;
import models.Result;
import models.User;
import models.UserAnswers;


public class ExamDaoImpl implements IExamDao{

    @Override
    public List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers() {
        List<QuestionPossibleAnswers> qpas = new ArrayList();
        for (int i=1;i<=5;i++){
            QuestionPossibleAnswers qpa = getOne(i);
            qpas.add(qpa);
        }
        return qpas;
    }

    @Override
    public boolean saveUser(User user) {
       return UserData.insert(user);
    }

    @Override
    public boolean saveUserSelectedAnswers(UserAnswers userAnswers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result getResult(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

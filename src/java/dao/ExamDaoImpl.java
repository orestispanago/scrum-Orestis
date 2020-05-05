package dao;

import static dao.QuestionPossibleAnswersData.getOne;
import java.util.ArrayList;
import java.util.List;
import models.QuestionPossibleAnswers;
import models.QuestionRightAnswer;
import models.QuestionSelectedAnswer;
import models.Result;
import models.User;
import models.UserAnswers;

public class ExamDaoImpl implements IExamDao {

    @Override
    public List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers() {
        List<QuestionPossibleAnswers> qpas = new ArrayList();
        for (int i = 1; i <= 5; i++) {
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
        
        List<QuestionSelectedAnswer> questionSelectedAnswersList = userAnswers.getSelectedAnswers();
       
        for (int i = 0; i < questionSelectedAnswersList.size(); i++) {
            User user = userAnswers.getUser();
            models.Answer answer = questionSelectedAnswersList.get(i).getSelectedAnswer();
            boolean resultInsert = QuestionSelectedAnswersData.insertOneRow(user, answer);
            if (!resultInsert) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Result getResult(User user) {
        List<QuestionPossibleAnswers> qpa = getQuestionsWithPossibleAnswers();
        List<QuestionSelectedAnswer> qsa = dao.QuestionSelectedAnswersData.getAll(user);
        List<QuestionRightAnswer> qra = dao.QuestionRightAnswerData.getAll();
        Result result = new Result();
        result.setUser(user);
        result.setQuestionsPossibleAnswers(qpa);
        result.setSelectedAnswers(qsa);
        result.setQuestionsRightAnswers(qra);
        return result;
    }

}

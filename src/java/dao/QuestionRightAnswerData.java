package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Answer;
import models.Question;
import models.QuestionRightAnswer;
import models.User;

public class QuestionRightAnswerData {

    private static Database db = new Database();

    private static ResultSet getRightAnswer() {
        ResultSet rs = db.getResults("SELECT questions.text_quest,answers.text_ans FROM questions, answers, right_answers\n"
                + "WHERE answers.id = right_answers.answer_id AND questions.id=right_answers.question_id");
        System.out.println("********** resultset: " + rs);
        return rs;
    }

    public static List<QuestionRightAnswer> getAll() {
        ResultSet rs = getRightAnswer();
        List<QuestionRightAnswer> qraList = new ArrayList();
        try {
            while (rs.next()) {
                Question question = new Question();
                Answer answer = new Answer();
                QuestionRightAnswer qra = new QuestionRightAnswer();
                question.setText(rs.getString(1));
                answer.setText(rs.getString(2));
                qra.setQuestion(question);
                qra.setRightAnswer(answer);
                qraList.add(qra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qraList;
    }
}

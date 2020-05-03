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

    private static ResultSet getById(int id) {
        return db.getResults(
                "SELECT \n"
                + "    u.id, u.username, a.id, a.text_ans, q.id, q.text_quest\n"
                + "FROM\n"
                + "    users_answers ua\n"
                + "        JOIN\n"
                + "    answers a ON ua.answer_id = a.id\n"
                + "        JOIN\n"
                + "    questions q ON q.id = a.question_id\n"
                + "        JOIN\n"
                + "    users u ON u.id = ua.user_id\n"
                + "        JOIN\n"
                + "    right_answers ra\n"
                + "WHERE\n"
                + "    ra.question_id = a.question_id\n"
                + "        AND ra.answer_id = ua.answer_id\n"
                + "        AND u.id = " + id + ");");
    }

    public static List<QuestionRightAnswer> getByUser(User user) {
        ResultSet rs = getById(user.getId());
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

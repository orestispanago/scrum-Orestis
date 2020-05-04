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
import models.QuestionSelectedAnswer;
import models.User;

public class QuestionSelectedAnswersData {

    private static Database db = new Database();
//        private  Database db;
//   
//    public QuestionPossibleAnswersData(){
//        db = new Database();
//    }

    private static ResultSet selectAll(User user) {
        return db.getResults("select q.text_quest, a.text_ans from users_answers ua\n"
                + "join answers a on a.id = ua.answer_id\n"
                + "join questions q on q.id = a.question_id\n"
                + "WHERE ua.user_id=" + user.getId()+";");
    }

    public static List<models.QuestionSelectedAnswer> getAll(User user) {
        ResultSet rs = selectAll(user);
        QuestionSelectedAnswer qsa = new QuestionSelectedAnswer();
        List<models.QuestionSelectedAnswer> qsaList = new ArrayList();
        try {
            while (rs.next()) {
                Answer answer = new Answer();
                Question question = new Question();
                answer.setText(rs.getString(1));
                question.setText(rs.getString(2));
                qsa.setQuestion(question);
                qsa.setSelectedAnswer(answer);
                qsaList.add(qsa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qsaList;
    }

    public static boolean insertOneRow(models.User user, models.Answer answer) {
        int lastInsertId = 0;
        int result = 0;
        String sql = "INSERT INTO users_answers(user_id, answer_id) "
                + "VALUES ( ? ,?)";
        db.setPreparedStatementWithKeys(sql);
        PreparedStatement pst = db.getPreparedStatement();
        try {
            System.out.println("************************************************");
            System.out.println("user id: " + user.getId());
            System.out.println("answer id: " + answer.getId());
            System.out.println("************************************************");
            
            pst.setInt(1, user.getId());
            pst.setInt(2, answer.getId());
            System.out.println("*********************** pst:" + pst);
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            result = pst.executeUpdate();
            return true;
//            if (result == 0) {
//                return false;
//            }
//            ResultSet rs = pst.getGeneratedKeys();
//            if (rs.next()) {
//                lastInsertId = rs.getInt(1);
//                user.setId(lastInsertId);
//                return true;
//            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}

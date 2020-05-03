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

public class QuestionSelectedAnswersData {

    private static Database db = new Database();
//        private  Database db;
//   
//    public QuestionPossibleAnswersData(){
//        db = new Database();
//    }

    private static ResultSet getAll() {
        return db.getResults("SELECT * FROM questions ORDER BY id");
    }
    
    public static boolean insertOneRow(models.User user, models.Answer answer) {
        int lastInsertId = 0;
        int result = 0;
        String sql = "INSERT INTO users_answers(user_id, answer_id) "
                        + "VALUES ( ? ,?)";
        db.setPreparedStatementWithKeys(sql);
        PreparedStatement pst = db.getPreparedStatement();
        try {
            pst.setInt(1, user.getId());
            pst.setInt(2, answer.getId());
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            result = pst.executeUpdate();
            if (result == 0) {
                return false;
            }
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                lastInsertId = rs.getInt(1);
                System.out.println("Last insert ID =================" + lastInsertId);
                user.setId(lastInsertId);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    
    
    
    
    
    
//    public static models.QuestionPossibleAnswers getOne(int id) {
//        ResultSet rs = getById(id);
//        Question question = new Question();
//        List<Answer> answers = new ArrayList();
//        int ans_id;
//        try {
//            if (rs.next()) {
//                int quest_id = rs.getInt(1);
//                question.setId(quest_id);
//                question.setText(rs.getString(2));
//
//                Answer answer = new Answer();
//                ans_id = rs.getInt(3);
//                answer.setId(ans_id);
//                answer.setText(rs.getString(4));
//                answers.add(answer);
//            }
//            while (rs.next()) {
//                Answer answer = new Answer();
//                ans_id = Integer.parseInt(rs.getString(3));
//                answer.setId(ans_id);
//                answer.setText(rs.getString(4));
//                answers.add(answer);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(question);
//        System.out.println(answers);
//        models.QuestionPossibleAnswers qpa = new models.QuestionPossibleAnswers(question, answers);
//        return qpa;
//    }

}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionPossibleAnswers {

    
    private static ResultSet getAll() {
        return Database.getResults("SELECT * FROM questions ORDER BY id");
    }

    private static ResultSet getById(int id) {
        return Database.getResults(
                "SELECT \n"
                + "    text_quest, text_ans\n"
                + "FROM\n"
                + "    questions,\n"
                + "    answers\n"
                + "WHERE\n"
                + "    questions.id = answers.question_id\n"
                + "        AND questions.id = " + id + ";");
    }

    public static void printOne() {
        ResultSet rs = getById(1);
        String question="";
        String ans;
        List<String> answers = new ArrayList();
        try {
            if(rs.next()){
                question = rs.getString(1);
                ans = rs.getString(2);
                answers.add(ans);
            }
            while (rs.next()) {
                ans = rs.getString(2);
                answers.add(ans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(question);
        System.out.println(answers);
    }
}

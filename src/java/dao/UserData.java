package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserData {

    private static Database db = new Database();

    public static boolean insert(models.User user) {
        int lastInsertId = 0;
        int result = 0;
        String sql = "INSERT INTO users (username) VALUES (?)";
        db.setPreparedStatementWithKeys(sql);
        PreparedStatement pst = db.getPreparedStatement();
        try {
            pst.setString(1, user.getUsername());
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

}

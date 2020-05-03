package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static final String DB_URL = "ra1.anystream.eu:3012";
    private static final String FULL_DB_URL = "jdbc:mysql://" + DB_URL + "/scrum?zeroDateTimeBehavior=convertToNull&useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWD = "AFDEmp_MySQL1";
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement pst = null;

    public Database(){
        getConnection();
    }

//    public static Connection getConnection() {
//        try {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
//            return connection;
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }

       public static Connection getConnection() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("***************** GETCONNECTION EXECUTED");
            connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            System.out.println("***************** GETCONNECTION returns connection value: " + connection);
            return connection;
        } catch (SQLException ex) {
            System.out.println("********************* ERROR IN GETCONNECTION");
            System.out.println("");
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static ResultSet getResults(String query) { // query = "SELECT * FROM Customers"
        try {
            setStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ResultSet getOneResult(String tableName, int id) {
        try {
            setStatement();
            String query = "SELECT * FROM `" + tableName + "` WHERE `id`=" + id;
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ResultSet getOneResultByField(String tableName, String fieldName, String fieldValue) {

        try {
            setStatement();
            String query = "SELECT * FROM `" + tableName + "` WHERE `" + fieldName + "`=" + fieldValue;
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }


    public static Statement getStatement() {
        return statement;
    }

    public Statement getStatementNonStatic() {
        return statement;
    }

    public static void setStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setStatementNonStatic() {
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static PreparedStatement getPreparedStatement() {
        return pst;
    }

    public static void setPreparedStatement(String query) {
        try {
            pst = connection.prepareStatement(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void setPreparedStatementWithKeys(String query) {
        try {
            pst = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
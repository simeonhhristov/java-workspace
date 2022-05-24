package com.example.databasesproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.db2.jcc.am.SqlIntegrityConstraintViolationException;

public class DB2Connection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void openConnection() {

        try {
            DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver());
        } catch (Exception cnfex) {
            System.out.println("Problem in loading or registering IBM DB2 JDBC driver");
            cnfex.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:db2://62.44.108.24:50000/SAMPLE", "db2admin", "db2admin");
            statement = connection.createStatement();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (null != connection) {
                // cleanup resources, once after processing
                resultSet.close();
                statement.close();
                // and then finally close connection
                connection.close();
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }

    }

    public ResultSet select(String stmnt) throws SQLException {
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(stmnt);
        } catch (SQLException s) {
            throw s;
        }

        return resultSet;
    }

    public void insert(String stmnt)
            throws SQLException {
        statement.executeUpdate(stmnt);
    }



    public void delete(String stmnt)
            throws SQLException {
        statement.executeUpdate(stmnt);
    }

//    public static void main(String[] args) {
//        DB2Connection db2Obj = new DB2Connection();
//        String stmnt = "";
//        String title = "Terms of Endearment";
//        String star = "Jack Nicholson";
//        int  year = 1983;
//
//        db2Obj.openConnection();
//
//        stmnt = "SELECT MOVIETITLE, MOVIEYEAR, STARNAME FROM DB2MOVIE.STARSIN";
//
//        db2Obj.select(stmnt, 3);
//
//        stmnt = "INSERT INTO DB2MOVIE.STARSIN(MOVIETITLE, MOVIEYEAR, STARNAME)"
//                + " VALUES ('" + title + "','" + year + "','" + star + "')";
//
//        db2Obj.insert(stmnt);
//
//
//        stmnt = "DELETE FROM DB2MOVIE.STARSIN WHERE MOVIETITLE = " + "'" + title + "' ";
//
//        db2Obj.delete(stmnt);
//
//        db2Obj.closeConnection();
//    }


}

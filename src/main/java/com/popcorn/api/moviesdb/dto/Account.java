package com.popcorn.api.moviesdb.dto;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {

    public static ValidationResponse signUp(String user, String pwd) throws SQLException {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("popcorn");
            dataSource.setPassword("popcorn2017");
            dataSource.setServerName("popcorn-db.czlfnwx7pigz.us-west-2.rds.amazonaws.com");
            dataSource.setDatabaseName("popcorn");
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO account VALUES('" + user + "','" + pwd + "')");
            return new SuccessResponse("Successfully Signed up");
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getSQLState().equalsIgnoreCase("23000"))
                return new ErrorResponse("SQL Error : 23000", "Email already registered");
            else
                return new ErrorResponse("SQL Error : " + e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse("20001", "Generic error. Check server logs for details");
        }

    }

    public static ValidationResponse verifyLogin(String user, String pwd) {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("popcorn");
            dataSource.setPassword("popcorn2017");
            dataSource.setServerName("popcorn-db.czlfnwx7pigz.us-west-2.rds.amazonaws.com");
            dataSource.setDatabaseName("popcorn");
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM account WHERE email='" + user + "'");
            if (resultSet.next()) {
                if (resultSet.getString("password").equals(pwd))
                    return new SuccessResponse("login successful");
                else
                    return new ErrorResponse("Error code : 10002", "Login failed. Email/password does not match");
            } else
                return new ErrorResponse("Error code : 10001", "Looks like you have not registered before. Please sign up to continue!");
        } catch (SQLException e) {
            e.printStackTrace();
            return new ErrorResponse("SQL Error : " + e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse("20001", "Generic error. Check server logs for details");
        }
    }
}

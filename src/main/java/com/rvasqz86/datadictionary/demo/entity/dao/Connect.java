package com.rvasqz86.datadictionary.demo.entity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    private final String server;
    private final String user;
    private final String password;
    private final int port;

    public Connect(String server,int port,  String user, String password) {
        this.server = server;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public static Connection getConnection(String serverName, int portNumber, String user, String password) throws SQLException {
        return DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/postgres", serverName,portNumber), user, password);
    }

    public ResultSet execute(String sql) {
        try {
            Connection connection = getConnection(server, port, user, password);
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

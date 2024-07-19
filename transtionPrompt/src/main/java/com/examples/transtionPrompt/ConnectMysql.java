package com.examples.transtionPrompt;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class ConnectMysql
{
    private static final String URL = "jdbc:mysql://loalhost:3306/aaa";
    private static final String USER = "aaa";
    private static final String PASSWORD = "2236";

    private Connection connection;

    public ConnectMysql () {
        try {
            startConnect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void startConnect() throws SQLException, ClassNotFoundException {
        // 1. 注册JDBC驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 打开连接
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void close() throws SQLException {
        // 4. 关闭连接
        connection.close();
    }

    public ArrayList<JsonObject> query(String selectQuery) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<JsonObject> list = new ArrayList<>();
        while (resultSet.next()) {
            Gson gson = new Gson();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            JsonObject json = new JsonObject();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object columnValue = resultSet.getObject(columnName);
                json.add(columnName, gson.toJsonTree(columnValue));
            }
            list.add(json);
        }

        return list;
    }

    public void update(String updateQuery) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Row " + rowsAffected + " updated successfully.");
            } else {
                System.out.println("Failed to update row");
            }
    }

}
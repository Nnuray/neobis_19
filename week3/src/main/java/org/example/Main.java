package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "31a07a2004";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM mytable";
            ResultSet resultSet = statement.executeQuery(sql);
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                writer.write("ID: "+id+" ,Name: "+name);
                writer.newLine();
            }
            writer.close();
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("good");
        } catch (SQLException | IOException e){
            e.printStackTrace();
        }
    }
}
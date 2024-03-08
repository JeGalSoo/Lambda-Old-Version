package com.bitcamp.api.user;

import com.bitcamp.api.ReView.ReView;
import com.bitcamp.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserRepository {
    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<User> list;
    Connection connection;

    private UserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
        list = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository 연결";
    }

    public List<User>  save1(List<User> users) throws SQLException {
        String sql = "INSERT INTO users (username, password, name, phone_number, " +
                " job, height, weight)" +
                "VALUES (?, ?, ?, ?, ?, ?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,users.get(0).getUsername());
        pstmt.setString(2,users.get(0).getPassword());
        pstmt.setString(3,users.get(0).getName());
        pstmt.setString(4,users.get(0).getPhoneNumber());
        pstmt.setString(5,users.get(0).getJob());
        pstmt.setDouble(6,users.get(0).getHeight());
        pstmt.setDouble(7,users.get(0).getWeight());
       pstmt.executeUpdate();
        pstmt.close();
        List<User> ls = new ArrayList<>();
        return ls;
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from reviews";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.printf("ID : %d\t Title : %s\t Content : %s\t Writer : %s\n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"));
            } while (rs.next());
        } else {
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        return null;
    }

    public String touch() throws SQLException {
        String sql = "CREATE TABLE users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20) NOT NULL,\n" +
                "    password VARCHAR(20) NOT NULL,\n" +
                "    name VARCHAR(20),\n" +
                "    phone_number VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ");";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
        }catch (Exception e){
            return "You have the table";
        }
        return "회원테이블 생성 성공";
    }

    public String rm() throws SQLException {
        String sql = "DROP TABLE users;";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
        }catch(Exception e){
            return "You don't have the table";
        }
        return "회원테이블 삭제 성공";
    }

    public List<?> cat() {
        String sql = "select * from users";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("회원목록");
            if(rs.next()) {
                do {
                    list.add(User.builder()
                            .id(rs.getLong("id"))
                            .username(rs.getString("username"))
                            .name(rs.getString("name"))
                            .phoneNumber(rs.getString("phone_number"))
                            .job(rs.getString("job"))
                            .build());
                } while (rs.next());
            }else{
                    System.out.println("데이터가 없습니다.");
                }
                rs.close();
                pstmt.close();
            } catch(Exception e){
            System.out.println("You have the table");
            return list;
        }

        return list;
    }
}
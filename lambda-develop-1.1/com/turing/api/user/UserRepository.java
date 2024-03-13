package com.turing.api.user;

import com.mysql.cj.protocol.Resultset;
import com.turing.api.enums.Messenger;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final UserRepository instance;
    private PreparedStatement pstmt;
    private Resultset rs;
    List<String> list;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection connection;

    private UserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
        pstmt=null;
        rs=null;
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository 연결";
    }
    public String count() throws SQLException {
        String sql = "select count(*) from users";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        ResultSet rs= pstmt.executeQuery();
        if(rs.next()){
            int a= rs.getInt(1);
            return a + "개 입니다.";
        } else {
            return "실패했습니다.";
        }
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
        pstmt.close();
        return null;
    }

    public Messenger  save1(List<User> users) throws SQLException {
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
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS: Messenger.FAIL;
    }

    public Messenger touch() throws SQLException {
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
        pstmt=connection.prepareStatement(sql);
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS: Messenger.FAIL;
    }

    public Messenger rm() throws SQLException {
        String sql = "DROP TABLE users;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS: Messenger.FAIL;

    }

    public List<?> cat() {
        List<User> list=new ArrayList<>();
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
    public Messenger login(User user) throws SQLException {
        String sql = "SELECT username,password FROM users WHERE username = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,user.getUsername());
        ResultSet rs = pstmt.executeQuery();
        return rs.next() ?
                rs.getString("password").equals(user.getPassword()) ?
                        Messenger.SUCCESS : Messenger.FAIL
                : Messenger.FAIL;
    }
    public String findUsername(String sc) throws SQLException {
        String sql = "SELECT username FROM users WHERE username = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,sc);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            return "아이디가 있습니다.";
        } else {
            return "아이디가 없습니다.";
        }
    }
}
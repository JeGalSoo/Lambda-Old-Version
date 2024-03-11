package com.turing.api.ReView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReViewRepository {
    private static ReViewRepository instance;

    static {
        try {
            instance = new ReViewRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection connection;
    List<ReView> list;
    private ReViewRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
        list=new ArrayList<>();
    } //디폴트 생성자를 막음 / 단 앞에 맵 선언 필요


    public static ReViewRepository getInstance() {
        return instance;
    }


    public List<?> showall() throws SQLException {
        String sql = "select * from reviews";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            do {
                list.add(ReView.builder()
                                .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                                .content(rs.getString("content"))
                                .writer(rs.getString("writer"))
                        .build());
            } while (rs.next());
        }else{
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        connection.close();
        return list;
    }
}

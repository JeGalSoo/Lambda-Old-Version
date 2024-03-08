package com.bitcamp.api.ReView;

import java.sql.SQLException;
import java.util.List;

public class ReViewController {
    private ReViewServiceImpl rs;

    public ReViewController(){
        this.rs=ReViewServiceImpl.getInstance();
    } //디폴트 생성자를 막음 / 단 앞에 맵 선언 필요

    public List<?> showall() throws SQLException {
        return rs.showall();
    }



    }

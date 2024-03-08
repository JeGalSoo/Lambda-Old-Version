package com.bitcamp.api.ReView;

import com.bitcamp.api.common.AbstractRepository;
import com.bitcamp.api.common.AbstractService;
import com.bitcamp.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ReViewServiceImpl extends AbstractService implements ReViewService{

    private final static ReViewServiceImpl instance = new ReViewServiceImpl();

    private static ReViewRepository rr;

    private ReViewServiceImpl(){
        rr=ReViewRepository.getInstance();
    } //디폴트 생성자를 막음 / 단 앞에 맵 선언 필요

    public static ReViewServiceImpl getInstance() {
        return instance;
    }

    @Override
    public List<?> showall() throws SQLException {
        return rr.showall();
    }

    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}

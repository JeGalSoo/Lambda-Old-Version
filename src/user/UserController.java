package com.turing.api.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class UserController {

    public String rm() throws SQLException {
        return service.rm();
    }
    UserServiceImpl service;

    public UserController() {
        this.service = UserServiceImpl.getInstance();
    }
    public String test(){return service.test();}
    public List<?> findUsers() throws SQLException {
        return service.findUsers();
    }

    public String addUsers() {
        return service.addUsers();
    }

    public List<User> save1(Scanner scanner) throws SQLException {
        return service.save1(User.builder()
                .username(scanner.next())
                .password(scanner.next())
                .name(scanner.next())
                .phoneNumber(scanner.next())
                .job(scanner.next())
                        .height(scanner.nextDouble())
                        .weight(scanner.nextInt())
                .build());
    }

    public List<User> findAll() {
        return service.findAll();
    }

    public String login(Scanner scanner) {
        return service.login(User.builder()
                .username(scanner.next())
                .password(scanner.next())
                .build());
    }

    public Optional<User> findById(Scanner scanner) {
        return service.findById(Long.parseLong(scanner.next()));
    }

    public String updatePassword(Scanner scanner) {
        return service.updatePassword(User.builder()
                .username(scanner.next())
                .phoneNumber(scanner.next())
                .password(scanner.next())
                .build());
    }

    public String delete(Scanner scanner) {
        service.delete(User.builder()
                .username(scanner.next())
                .build());
        return "회원삭제";
    }

    public Boolean existsById(Scanner scanner) {
        return service.existsById(Long.parseLong(scanner.next()));
    }

    public List<?> findUsersByName(Scanner scanner) {
        return service.findUsersByName(scanner.next());
    }

    public Map<String, ?> findUsersByNameFromMap(Scanner scanner) {
        return service.findUsersByNameFromMap(scanner.next());
    }

    public List<?> findUsersByJob(Scanner scanner) {
        return service.findUsersByJob(scanner.next());
    }

    public Map<String, ?> findUsersByJobFromMap(Scanner scanner) {
        return service.findUsersByJobFromMap(scanner.next());
    }

    public String count() {
        return service.count();
    }
    public Optional<User> getOne(Scanner scanner) {
        return service.getOne(scanner.next());
    }
    public Map<String, ?> getUserMap(){
        return service.getUserMap();
    }

    public String touch() throws SQLException {
        return service.touch();
    }

    public List<?> cat() throws SQLException {
        return service.cat();
    }
}

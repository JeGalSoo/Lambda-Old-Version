package com.turing.api.user;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    String addUsers();
    String login(User user);
    String updatePassword(User user);
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> getUserMap();

    String test();

    List<?> findUsers() throws SQLException;

    Messenger touch() throws SQLException;

    Messenger rm() throws SQLException;

    List<?> cat();

    Messenger save1(User user) throws SQLException;
}

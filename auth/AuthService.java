package auth;


import user.User;

import java.util.List;
import java.util.Map;

public interface AuthService {
    String addUsers();
    String login(User user);
    String updatePassword(User user);
    List<User> findUsersByJob(String job);
}
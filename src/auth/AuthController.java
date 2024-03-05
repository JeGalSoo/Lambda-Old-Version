package auth;


import user.User;

import java.util.List;
import java.util.Scanner;

public class AuthController {

    AuthServiceImpl authService;

    public AuthController() {
    }


    public String addUsers() {
        return authService.addUsers();
    }

    public String login(Scanner scanner) {
        System.out.println("로그인할 ID 입력 : ");
        return authService.login(User.builder()
                .username(scanner.next())
                .password(scanner.next())
                .build());
    }

    public String updatePassword(Scanner scanner) {
        System.out.println("수정할 ID 입력 : ");
        System.out.println("수정할 비번 입력 : ");
        return authService.updatePassword( User.builder()
                .username(scanner.next())
                .password(scanner.next())
                .build());
    }


    public List<User> findUsersByJob(Scanner scanner) {
        System.out.println("직업으로 검색");
        return authService.findUsersByJob(scanner.next());
    }

}
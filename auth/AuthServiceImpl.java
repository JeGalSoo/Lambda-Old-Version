package auth;


import account.Account;
import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import enums.Messenger;
import user.User;

import java.util.*;

public class AuthServiceImpl extends AbstractService<Account> implements AuthService {
    private static AuthServiceImpl instance = new AuthServiceImpl();
    Map<String, User> users;

    private AuthServiceImpl(){
        this.users = new HashMap<>();
    }
    public static AuthService getInstance(){return instance;}

    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                "로그인 성공" : "로그인 실패";
    }


    @Override
    public String updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());

        return "비번 변경 성공";
    }

    @Override
    public List<User> findUsersByJob(String job) {

        return null;
    }

    @Override
    public String addUsers() {
        Map<String, User> map = new HashMap<>();
        UtilService util = UtilServiceImpl.getInstance();
        System.out.println(util);
        for(int i=0; i<5; i++){
            String username = util.createRandomUsername();
            map.put(username,
                    User.builder()
                            .username(username)
                            .password("1")
                            .name(util.createRandomName())
                            .build());
        }
        users = map;
        return users.size()+"개 더미값 추가";
    }


    @Override
    public Messenger save(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Account account) {
        return null;
    }


    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
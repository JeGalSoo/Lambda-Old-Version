package com.turing.api.user;

import com.turing.api.common.AbstractService;
import com.turing.api.common.UtilServiceImpl;
import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    private static UserServiceImpl instance = new UserServiceImpl();
    Map<String, User> users;
    List<User> lusers;
    UserRepository ur;

    private UserServiceImpl(){
        this.users = new HashMap<>();
        ur= UserRepository.getInstance();
        lusers=new ArrayList<>();
    }
    public static UserServiceImpl getInstance(){return instance;}
    @Override
    public Messenger save1(User user) throws SQLException {
        lusers.add(user);
    return ur.save1(lusers);
    }

    @Override
    public Messenger save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return  new ArrayList<>(users.values());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Messenger login(User user) throws SQLException {
        lusers.add(user);
        return ur.login(user);

//                login(user.getUsername(), User.builder()
//                        .password("").build())
//                .equals(user.getPassword()) ?
//                "로그인 성공" : "로그인 실패";
    }

//    @Override
//    public String findById(String id) throws SQLException {
//        return null;
//    }

    @Override
    public String updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());

        return "비번 변경 성공";
    }

    @Override
    public String delete(User user) {
        users.remove(user.getUsername());
        return "회원삭제";
    }

    @Override
    public Boolean existsById(Long id) {
        return users.containsKey(id);
    }



    @Override
    public List<?> findUsersByName(String name) {
        return users
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {

        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public List<?> findUsersByJob(String job) {
        System.out.println("findUsersByJob 파라미터 : "+job);
        users
                .values()
                .stream().forEach(i->System.out.println("직업 :"+i.getJob()));
        return users
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                ;
    }

    @Override
    public String count() throws SQLException {
        return ur.count();
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.of(users.get(id));
    }

    @Override
    public Map<String, ?> getUserMap() {
        return users;
    }

    @Override
    public String findUsername(String sc) throws SQLException {
        return ur.findUsername(sc);
    }

    @Override
    public String test() {
        return ur.test();
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return ur.findUsers();
    }

    @Override
    public Messenger touch() throws SQLException {
        return ur.touch();
    }

    @Override
    public Messenger rm() throws SQLException {
        return ur.rm();
    }

    @Override
    public List<?> cat() {
        return ur.cat();
    }

//    @Override
//    public Map<String,User> save(User user) throws SQLException {
//        return ur.save1(users.put(user.getUsername(),user));
//    }

    @Override
    public String addUsers() {
        IntStream.range(0,5)
                .mapToObj(i -> UtilServiceImpl.getInstance().createRandomUsername())
                .forEach(i -> users.put(i, User.builder()
                        .username(i)
                        .password("1")
                        .name(UtilServiceImpl.getInstance().createRandomName())
                        .job(UtilServiceImpl.getInstance().createRandomJob())
                        .build()));
        return users.size()+"개 더미값 추가";

    }
}

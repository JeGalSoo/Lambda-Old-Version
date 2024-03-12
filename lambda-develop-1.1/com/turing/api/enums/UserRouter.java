package com.turing.api.enums;

import com.turing.api.user.UserController;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public enum UserRouter {
    exit("e",i-> {
        return Messenger.FAIL;
    }),
//    count("q",i-> {
//            return UserController.getInstance().count();
//    }),
    save("s",i-> {
        try {
            return UserController.getInstance().save1(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    touch("t",i-> {
        try {
            return UserController.getInstance().touch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    rm("r",i-> {
        try {
            return UserController.getInstance().rm();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }),
    cat("c",i-> {
        try {
            System.out.println(UserController.getInstance().cat());
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    })
    ;
    private final String num;
    private final Function<Scanner, Messenger> function;

    UserRouter(String num, Function<Scanner,Messenger> predicate) {
        this.num = num;
        this.function = predicate;
    }
    public static Messenger getOperator(Scanner sc){
        System.out.println("t-테이블 생성\n" +
                "r-테이블 삭제\n" +
                "c-테이블 조회\n" +
                "s-회원 가입\n" +
                "q-회원 수");
        String a=sc.next();
        while(true) {
            return Arrays.stream(values())
                    .filter(i -> i.num.equals(a))
                    .findAny().orElseThrow(() -> new IllegalArgumentException("error"))
                    .function.apply(sc);
        }
    }
}

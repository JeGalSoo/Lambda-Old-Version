package com.turing.api.enums;

import com.turing.api.user.UserView;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public enum Menus {
    user("u", i -> {
        System.out.println(UserRouter.getOperator(i));
        return null;
    })
    ;
    private final String menu;
    private final Function<Scanner,String> function;

    Menus(String menu, Function<Scanner,String> function) {
        this.menu = menu;
        this.function = function;
    }
    public static String getOperator(Scanner sc) {
            String a = sc.next();
            return Arrays.stream(values())
                    .filter(i -> i.menu.equals(a))
                    .findFirst().orElseThrow(() -> new IllegalArgumentException("error"))
                    .function.apply(sc);
    }
}
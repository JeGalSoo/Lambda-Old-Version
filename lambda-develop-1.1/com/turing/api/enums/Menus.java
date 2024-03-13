package com.turing.api.enums;

import com.turing.api.user.UserView;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum Menus {
    user("u", i -> {
        while(UserRouter.getOperator(i));
        return TRUE;
    }),
    exit("x", i->{return FALSE;})
    ;
    private final String menu;
    private final Function<Scanner,Boolean> function;

    Menus(String menu, Function<Scanner,Boolean> function) {
        this.menu = menu;
        this.function = function;
    }
    public static boolean getOperator(Scanner sc) {
        String a = sc.next();
        while (true) {
            return Arrays.stream(values())
                    .filter(i -> i.menu.equals(a))
                    .findFirst().orElseThrow(() -> new IllegalArgumentException("error"))
                    .function.apply(sc);
        }
    }
}
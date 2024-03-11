package com.turing.api.enums;

import com.turing.api.ReView.ReViewView;
import com.turing.api.account.AccountView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Menus {
    Exit("e",i->{
        System.out.println("EXIT");
        return false;
    }),
    User("u", i-> {
        System.out.println("UserView");
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    Review("r",i-> {
        System.out.println("ReView");
        try {
            ReViewView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    Account("a",i-> {AccountView.main(i);
        System.out.println("Account");
        return true;}),
    Crawler("c",i-> {
        System.out.println("Crawler");
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    NAVIGATION_ERROR("navigation_error", i -> {
        System.out.println("Wrong Input");
        return true;
    });
    ;
    private final String menu;
    private final Predicate<Scanner> predicate;

    Menus(String score, Predicate<Scanner> predicate) {
        this.menu = score;
        this.predicate=predicate;
    }
    public static boolean getOperator(Scanner sc) {
        String a=sc.next();
        return Stream.of(values())
                .filter(o -> o.menu.equals(a))
                .findFirst().orElse(NAVIGATION_ERROR).predicate.test(sc);
    }
}
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

enum Menus {
    Exit("x",i->{
        System.out.println("EXIT");
        return false;
    }),
    User("u", i-> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    Review("r",i-> {
        try {
            ReViewView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;}),
    Account("a",i-> {AccountView.main(i);
        return true;}),
    Crawler("c",i-> {
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
    private Predicate<Scanner> predicate;

    Menus(String score, Predicate<Scanner> predicate) {
        this.menu = score;
        this.predicate=predicate;
    }
    public static boolean getOperator(Scanner sc) {
        return Stream.of(values())
                .filter(o -> o.menu.equals(sc.next()))
                .findFirst().orElse(NAVIGATION_ERROR).predicate.test(sc);
    }
}
public class Navigation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            Menus.getOperator(sc);
        }
    }
}
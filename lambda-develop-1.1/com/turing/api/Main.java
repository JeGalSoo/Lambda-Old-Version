package com.turing.api;



import com.turing.api.enums.Menus;

import javax.swing.text.NavigationFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, SQLException {

        while (Menus.getOperator(sc)) ;
//            switch (sc.next()){
//                case "x":  return;
//                case "u": UserView.main(sc);break;
//                case "m": AccountView.main(sc); break;
//                case "c": CrawlerView.main(sc);  break;
//                case "b": ReViewView.main(sc); break;
//            }
    }
}
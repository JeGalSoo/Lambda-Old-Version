package com.turing.api.ReView;

import java.sql.SQLException;
import java.util.Scanner;

public class ReViewView {

    public static void main(Scanner sc) throws SQLException {
        ReViewController rc=new ReViewController();
        while (true) {
            System.out.println("0:종료\n" +
                    "1:출력");
            switch (sc.next()) {
                case "0":
                    return;
                case "1":
                    rc.showall().forEach(System.out::println);
                    break;
            }
        }
    }
}

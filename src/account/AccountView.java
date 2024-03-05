package account;

import java.util.List;
import java.util.Scanner;

public class AccountView {
    public static void main() {
        AccountController ac = new AccountController();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[메뉴] 0-Exit\n " +
                    "1-Create\n " + "2-Deposit\n " +
                    "3-Wtihdraw\n 4-Balance\n " +
                    "5-Remove\n 6-Account List");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    ac.createAccount(sc);
                    break;
                case "2":
                    System.out.println(ac.deposit(sc));
                    break;
                case "3":
                    System.out.println(ac.withdraw(sc));
                    break;
                case "4":
                    List<?> temp= ac.getBalance(sc);
                    break;
                case "5":
                    System.out.println(ac.cancelAccount(sc));
                    break;
                case "6":
                    System.out.println(ac.getAccounts(sc));
                    break;
            }
        }
    }
}
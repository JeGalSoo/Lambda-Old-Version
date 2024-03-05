
import account.AccountView;
import auth.AuthView;
import board.BoardView;
import crawler.CrawlerServiceImpl;
import crawler.CrawlerView;
import user.UserView;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("0-종료 1-회원관리 2-게시판 3-사용자관리(맵) 4-계좌관리 5-Crawler");
            switch (sc.next()){
                case "0":
                    System.out.println("시스템을 종료합니다.");
                    return; //종료
                case "1":
//                    AuthView.main(sc);
                    break; //잠깐 종료 후 다시시작
                case "2":
                    BoardView.main();
                    break;
                case "3":
                    UserView.main(sc);
                    break;
                case "4":
                    AccountView.main();
                    break;
                case "5":
                    CrawlerView.main(sc);
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }
        }
    }
}
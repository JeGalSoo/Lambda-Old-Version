package crawler;

import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) {
        CrawlerController cs = new CrawlerController();
        switch (sc.next()) {
            case "0":
                System.out.println("종료");
                return;
            case "1":
                System.out.println("1-벅스뮤직");
                Map<String, ?>map=cs.findBugsMusic(sc);
//                System.out.println("1-벅스뮤직 결과 : " + cs.save(sc));
//            case "2":
//                System.out.println("1-벅스뮤직 결과 : " + cs.save(sc));
//            case "3":
//                System.out.println("1-벅스뮤직 결과 : " + cs.save(sc));
//            case "4":
//                System.out.println("1-벅스뮤직 결과 : " + cs.save(sc));
//            case "5":
//                System.out.println("1-벅스뮤직 결과 : " + cs.save(sc));
        }
    }
}

package crawler;

import org.jsoup.nodes.Element;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        CrawlerController cs = new CrawlerController();
        System.out.println("0-종료 1-벅스뮤직차트 2-멜론뮤직차트");
        while (true) {
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    Map<String, ?> map = cs.findBugsMusic(sc);
                    Iterator<Element> title = (Iterator<Element>) map.get("title");
                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");
                    Iterator<Element> rank = (Iterator<Element>) map.get("rank");
                    System.out.println("벅스뮤직 결과");
                    while (rank.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    Map<String, ?> melonMap = cs.findMelonMusic(sc);
                    Iterator<Element> melonTitle = (Iterator<Element>) melonMap.get("title");
                    Iterator<Element> melonArtist = (Iterator<Element>) melonMap.get("artist");
                    Iterator<Element> melonRank = (Iterator<Element>) melonMap.get("rank");
                    System.out.println("멜론뮤직 결과");
                    while (melonRank.hasNext()) {
                        System.out.println(melonRank.next().text() + "위 " + melonArtist.next().text() + " - " + melonTitle.next().text());
                    }
                    break;
//            case "3":
//                System.out.println("1-벅스뮤직 결과 : " + cs.save(sc));
//            case "4":
//                System.out.println("1-벅스뮤직 결과 : " + cs.save(sc));
//            case "5":
//                System.out.println("1-벅스뮤직 결과 : " + cs.save(sc));
            }
        }
    }
}

package crawler;

import common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class CrawlerRepository extends AbstractRepository {
    private static CrawlerRepository instance = new CrawlerRepository();
    private Map<String, ?> map;

    private CrawlerRepository() {
        map = new HashMap<>();
    }

    public static CrawlerRepository getInstance() {
        return instance;
    }

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
            Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10 * 1000).get();
            Elements elems = doc.select("table.byChart");
            Iterator<Element> title = elems.select("p.title").iterator();
            Iterator<Element> artist = elems.select("p.artist").iterator();
            Iterator<Element> rank = elems.select("strong").iterator();
            Map<String, Iterator<Element>> map1 = new HashMap<>();
            map1.put("title", title);
            map1.put("artist", artist);
            map1.put("rank", rank);
            map = map1;
        return map;

    }
    public Map<String,?> melon(Map<String,?>chart) throws IOException {
            Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").timeout(10 * 1000).get();
            Elements elems = doc.select("html.parser");
            Iterator<Element> title = elems.select("div, class_ = ellipsis rank01").iterator();
            Iterator<Element> artist = elems.select("<div class=ellipsis rank02>").iterator();
            Iterator<Element> rank = elems.select("<div class=wrap t_center>").iterator();
            Map<String, Iterator<Element>> map1 = new HashMap<>();
            map1.put("title", title);
            map1.put("artist", artist);
            map1.put("rank", rank);
            map = map1;
        return map;

    }
}

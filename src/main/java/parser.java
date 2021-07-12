import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class parser {

    private static Object Element;

    private static Document getPage()throws IOException{
        String url = "https://poezdato.net/raspisanie-po-stancyi/samara/elektrichki/";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }

    public static void main(String[]args) throws IOException {
        Document page= getPage();
        //css query language
        Element tbody = page.select("tbody").first();
        Elements rows = tbody.select("tr");
        Elements cells = tbody.select("td");

        for(Element cell : cells ) {
            String cellText = cell.text();
            String cellUrl = cell.attr("href");
            System.out.println(cellText);
        }
    }
}

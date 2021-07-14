import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class parser2 {

    private static Object Element;
    private static int counter = 1;
    private static org.jsoup.nodes.Element cell;

        public void doParse(String url) throws IOException {
            Document page = Jsoup.parse(new URL(url), 15000);
            //css query language
            Element tbody = page.select("tbody").first();
            Elements rows = tbody.select("tr");
            Elements cells = tbody.select("td");

            for (Element cell : cells) {
                if (counter == 5) {
                    System.out.println("В пути - " + cell.text());
                }
                if (counter == 4) {
                    System.out.println("Отправление - " + cell.text());
                }
                if (counter == 3) {
                    System.out.println("Стоянка - " + cell.text());
                }
                if (counter == 2) {
                    System.out.println("Прибытие - " + cell.text());
                }
                if (counter == 1) {
                    System.out.println("Станция - " + cell.text());
                }
                if (counter == 5) {
                    System.out.println("");
                    counter = 0;
                }
                counter++;
            }
        }
}
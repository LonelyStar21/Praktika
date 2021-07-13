import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class parser2<cells, counter> {

    private static Object Element;
    private static int counter = 1;
    private static org.jsoup.nodes.Element cell;

    private static Document getPage() throws IOException {
        String url = "https://poezdato.net/raspisanie-elektrichki/7134--zhigulevskoe-more--samara/";
        Document page = Jsoup.parse(new URL(url), 15000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
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
            // if (counter == 2) {
            //System.out.println("Номер электрички - " + cell.text());
            // System.out.println("Ссылка на маршрут - " + cell.select("a").first().attr("href"));

            if (counter == 5) {
                System.out.println("");
                counter = 0;
            }
            counter++;
        }
    }
}


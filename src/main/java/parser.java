import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class parser {

    private static Document getPage()throws IOException{
        String url = "https://poezdato.net/raspisanie-po-stancyi/samara/elektrichki/";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }

    public static void main(String[]args) throws IOException {
        Document page= getPage();
        //css query language
        Element tbody = page.select("tbody").first();
        Elements names = tbody.select("tr[class=odd]");
        System.out.println(tbody);
        String number = "";
        System.out.println("Тип  Номер  Маршрут  Прибытие  Стоянка  Отправление");
    }
}

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

import java.io.IOException;

public class Taller4 {

    public static void main(String[] args) {

        Document doc;
		Document detailDoc = null;
        try {

            // need http protocol
            doc = Jsoup.connect("https://play.google.com/store/apps/category/FINANCE/collection/topselling_paid").timeout(0).get();
			
			//System.out.println(doc.html()); //Or System.out.println(doc);
			
			HashSet<String> hrefs = new HashSet<String>();
			String href = null;
			String description = null;
			
			Elements anchors = doc.getElementsByClass("card-click-target");
			
			for (Element element : anchors){
				href = "https://play.google.com/" + element.attr("href").toString();
				hrefs.add(href);
			}
			
			for (String url: hrefs){
				detailDoc = Jsoup.connect(url).timeout(0).get();
				description = detailDoc.select("[itemprop='description']").text();
				System.out.println(description);
				System.out.println("***********************************************");
			}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
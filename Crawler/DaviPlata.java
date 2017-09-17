import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

import java.io.IOException;

public class DaviPlata {

    public static void main(String[] args) {

		/*
		Tabla de Selectores:
		
		Información 	                 Selector
		Nombre 	                    class="id-app-title"
		Número de ratings 	        class="rating-count"
		Rating promedio 	        class="score"
		Descripcion 	            itemprop="description"
		Cambios recientes 	        class="recent-change"
		Ratings con 5 estrellas 	class="rating-bar-container five"
		Ratings con 4 estrellas 	class="rating-bar-container four"	
		*/
	
        Document doc;
		Elements contents;
		
        try {

            //Connects to the page
			doc = Jsoup.connect("https://play.google.com/store/apps/details?id=com.davivienda.daviplataapp").timeout(0).get();
			
			//Prints the html
			//System.out.println(doc.html());
			
			System.out.println();
			System.out.println("********** Datos Obtenidos de DaviPlata **********");
			System.out.println();
			
			//id-app-title
			System.out.println("Nombre:");
			contents = doc.getElementsByClass("id-app-title");
			for (Element content : contents) {
			  String contentText = content.text();
			  System.out.println(contentText);
			  System.out.println();
			}
			
			//rating-count
			System.out.println("Nmero de ratings:");
			contents = doc.getElementsByClass("rating-count");
			for (Element content : contents) {
			  String contentText = content.text();
			  System.out.println(contentText);
			  System.out.println();
			}
			
			//score
			System.out.println("Rating promedio:");
			contents = doc.getElementsByClass("score");
			for (Element content : contents) {
			  String contentText = content.text();
			  System.out.println(contentText);
			  System.out.println();
			}
			
			//itemprop="description"
			System.out.println("Descripcion:");
			String description = null;
			description = doc.select("[itemprop='description']").text();
			System.out.println(description);
			System.out.println();
						
			//recent-change
			System.out.println("Cambios recientes:");
			contents = doc.getElementsByClass("recent-change");
			for (Element content : contents) {
			  String contentText = content.text();
			  System.out.println(contentText);
			  System.out.println();
			}
			
			//rating-bar-container five
			System.out.println("Ratings con 5 estrellas:");
			contents = doc.getElementsByClass("rating-bar-container five");
			for (Element content : contents) {
			  String contentText = content.text();
			  System.out.println(contentText);
			  System.out.println();
			}
			
			//rating-bar-container four
			System.out.println("Ratings con 4 estrellas:");
			contents = doc.getElementsByClass("rating-bar-container four");
			for (Element content : contents) {
			  String contentText = content.text();
			  System.out.println(contentText);
			  System.out.println();
			}
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
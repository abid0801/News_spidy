package newspapercrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import org.jsoup.parser.Parser;

public class crawler {

    //Main is using for debugging purposes
    //public static void main(String[] args){
      //  ArrayList<News> newss = crawlAll("The Daily Star");
//
  //      for(News news : newss){
    //        System.out.println(news.toString());
      //  }


    private static ArrayList<News> crawlDailyStar(String userQuery){
            ArrayList<News> newsList = new ArrayList<>();
            String initialUrl;
            String urlString;
            int numOfnewsFound;

            initialUrl = "https://www.thedailystar.net/newspaper";
            urlString = fullUrl(initialUrl, userQuery);

            Document DailyStarDoc = null;
            try{
                DailyStarDoc = Jsoup.connect(urlString).get();
            }
            catch (Exception ex){
                System.out.println("Debug: Couldn't connect with the website");
                return null;
            }
            System.out.println("Finding elements from The Daily Star");
            Elements newss = DailyStarDoc.select(div.title);

            numOfnewsFound = newss.size();

            for(Element news : newss) {
                String name = news.select("span.name").text();
                String imageUrl = news.select("img.image").attr("data-src");

                String newsPage = newss.select("a.link").attr("href");

                String source = "The Daily Star";

                News n = new News(name, imageUrl, newsPage, source);
                System.out.println(n.toString());
                newsList.add(n);
            }
            return newsList;
        }

        public static ArrayList<News> crawlAll(String userQuery, int sortType){
        //As we are using only one website there'll be no sorting
            ArrayList<News> newss = new ArrayList<>();

            try{
                newss.addAll(crawlDailyStar(userQuery));
            }
            catch (Exception ex){
                System.out.println("Error crawling The Daily Star");
            }
            return newss;
        }

        private static String fullUrl(String initialUrl, String userQuery){
        return initialUrl + userQuery.replaceAll(" ","+");
        //replaces all the spaces with "+"
        }
}
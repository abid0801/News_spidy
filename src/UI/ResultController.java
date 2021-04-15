package UI;

import debugging.Debug;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import java.net.*;
import java.awt.*;
import java.util.ArrayList;


public class ResultController {

    private String keyWord;
    public TextField SearchBox;
    public WebView imageViewer;
    private ArrayList<newspapercrawler.News> myNews;
    public ListView Newslist;
    public TextArea details;
    private int nindex;

    public void SearchButtonClicked(ActionEvent event)throws Exception
    {
        if(!SearchBox.getText().equals("")){
            keyWord = this.SearchBox.getText();
            FXMLLoader resultXML = new FXMLLoader(getClass().getResource("ResultScene.fxml"));
            Parent root = (Parent) resultXML.load();
            Scene resultScene = new Scene(root, 1080, 720);
            ResultController RES = resultXML.getController();
            RES.setText(keyWord,0);
            Stage resultStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            resultStage.setScene(resultScene);
        }
    }
    public void setText(String key, int sortType)
    {
        SearchBox.setText(key);
        keyWord = key;
        myNews = newspapercrawler.crawler.crawlAll(key,sortType);
        for(int i = 0; i < myNews.size(); i++) {
            Newslist.getItems().add(myNews.get(i).getName());
        }

        setNews(0);
    }
    private void setNews(int index)
    {
        
        WebEngine engine = imageViewer.getEngine();
        String url = "" + myNews.get(index).getImageUrl() + "";
        String detailsText =
                "Title: " + myNews.get(index).getName()  + "\n"
                + "Source: " + myNews.get(index).getSource() + "\n";
        details.setText(detailsText);
        engine.load(url);
    }

    public void buy()
    {
        try{
            Desktop.getDesktop().browse(new URI(myNews.get(nindex).getNewsPage()));
        }catch(Exception e){}
    }

    public void loadNext()
    {
        if( nindex < myNews.size()){
            nindex++;
            setNews(nindex);
            Newslist.scrollTo(nindex);
            Newslist.getSelectionModel().select(nindex);
        }
    }

    public void loadPrevious()
    {
        if( nindex > 0){
            nindex--;
            setNews(nindex);
            Newslist.scrollTo(nindex);
            Newslist.getSelectionModel().select(nindex);
        }
    }

    public void listSelection()
    {
        nindex = Newslist.getSelectionModel().getSelectedIndex();
        setNews(nindex);
    }


    public void sortByWorld()
    {
        Newslist.getItems().clear();
        myNews = newspapercrawler.crawler.crawlAll(keyWord,0);

        for(int i = 0; i < myNews.size(); i++) {
            Newslist.getItems().add(myNews.get(i).getName());
        }

        setNews(0);
    }

    public void sortBySports()
    {
        Newslist.getItems().clear();
        myNews = newspapercrawler.crawler.crawlAll(keyWord,1);

        for(int i = 0; i < myNews.size(); i++) {
            Newslist.getItems().add(myNews.get(i).getName());
        }

        setNews(0);
    }
    
    public void sortByFrontPage()
    {
        Newslist.getItems().clear();
        myNews = newspapercrawler.crawler.crawlAll(keyWord,2);

        for(int i = 0; i < myNews.size(); i++) {
            Newslist.getItems().add(myNews.get(i).getName());
        }

        setNews(0);
    }
    
    public void sortByCountry()
    {
        Newslist.getItems().clear();
        myNews = newspapercrawler.crawler.crawlAll(keyWord,3);

        for(int i = 0; i < myNews.size(); i++) {
            Newslist.getItems().add(myNews.get(i).getName());
        }

        setNews(0);
    }
    
    public void sortByCity()
    {
        Newslist.getItems().clear();
        myNews = newspapercrawler.crawler.crawlAll(keyWord,4);

        for(int i = 0; i < myNews.size(); i++) {
            Newslist.getItems().add(myNews.get(i).getName());
        }

        setNews(0);
    }
    
    public void sortByBusiness()
    {
        Newslist.getItems().clear();
        myNews = newspapercrawler.crawler.crawlAll(keyWord,5);

        for(int i = 0; i < myNews.size(); i++) {
            Newslist.getItems().add(myNews.get(i).getName());
        }

        setNews(0);
    }
    
    public void sortByBackPage()
    {
        Newslist.getItems().clear();
        myNews = newspapercrawler.crawler.crawlAll(keyWord,6);

        for(int i = 0; i < myNews.size(); i++) {
            Newslist.getItems().add(myNews.get(i).getName());
        }
    }
    public void sortByArtsandEntertainment()
        {
            Newslist.getItems().clear();
            myNews = newspapercrawler.crawler.crawlAll(keyWord,7);

            for(int i = 0; i < myNews.size(); i++) {
                Newslist.getItems().add(myNews.get(i).getName());
            }

        setNews(0);
    }
    
    
}
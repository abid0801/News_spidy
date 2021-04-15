package newspapercrawler;

public class News {
    private String name;
    private String imageUrl;
    private String newsPage; //URL to the page of the product
    private String source;

    public News(){

    }

    public News(String name, String imageUrl, String newsPage, String source){
        this.name = name;
        this.imageUrl = imageUrl;
        this.newsPage = newsPage;
        this.source = source;
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    public String getImageUrl(){
        return imageUrl;
    }
    public void setImageUrl(){
        this.imageUrl = imageUrl;
    }
    public String getNewsPage(){
        return newsPage;
    }
    public void setNewsPage(String newsPage){
        this.newsPage = newsPage;
    }
    public String getSource(){
        return source;
    }
    public void setSource(String source){
        this.source = source;
    }
}

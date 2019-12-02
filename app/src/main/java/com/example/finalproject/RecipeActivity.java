package com.example.finalproject;

public class RecipeActivity {
    private double id;
    private String publisher;
    private String f2f_url;
    private String title;
    private String source_url;
    private String recipe_id;
    private String image_url;
    double social_rank;
    private String publisher_url;
    protected String url;
    protected String imgUrl;
    protected String imageID;


    public RecipeActivity() {

    }

    public RecipeActivity(double id, String publisher, String f2f_url, String title,
                          String source_url, String recipe_id, String image_url,
                          double social_rank, String publisher_url, String imageID,
                          String imgUrl, String url) {
        this.id = id;
        this.url = url;
        this.imgUrl = imgUrl;
        this.imageID = imageID;
        this.id = id;

        this.publisher = publisher;
        this.f2f_url = f2f_url;
        this.title = title;
        this.source_url = source_url;
        this.recipe_id = recipe_id;
        this.image_url = image_url;
        this.social_rank = social_rank;
        this.publisher_url = publisher_url;
    }


    RecipeActivity(String publisher,String f2f_url,String title,String source_url,String recipe_id,String image_url,double social_rank,String publisher_url){
        setPublisher(publisher);
        setF2f_url(f2f_url);
        setTitle(title);
        setSource_url(source_url);
        setRecipe_id(recipe_id);
        setImage_url(image_url);
        setSocial_rank(social_rank);
        setPublisher_url(publisher_url);
    }


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getF2f_url() {
        return f2f_url;
    }

    public void setF2f_url(String f2f_url) {
        this.f2f_url = f2f_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public double getSocial_rank() {
        return social_rank;
    }

    public void setSocial_rank(double social_rank) {
        this.social_rank = social_rank;
    }

    public String getPublisher_url() {
        return publisher_url;
    }

    public void setPublisher_url(String publisher_url) {
        this.publisher_url = publisher_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getImageID() {
        return imageID;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}

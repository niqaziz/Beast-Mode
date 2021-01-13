package com.example.beastmode_register_signin.Explorer;

public class CategoryItem {
    Integer id;
    Integer imageUrl;
    String name;
    String Details;
    String Workout;
    Integer Gif;
    String Rep;

    public CategoryItem(Integer id, Integer imageUrl, String name, String details, String workout, Integer gif, String rep) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        Details = details;
        Workout = workout;
        Gif = gif;
        Rep = rep;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getWorkout(){ return Workout;}

    public void setWorkout(String workout){ Workout = workout;}

    public Integer getGif(){ return Gif;}

    public void setGif(Integer gif){ Gif = gif;}

    public String getRep(){ return Rep;}

    public void setRep(String rep){ Rep = rep;}
}


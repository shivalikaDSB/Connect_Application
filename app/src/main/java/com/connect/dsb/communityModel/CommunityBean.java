package com.connect.dsb.communityModel;

public class CommunityBean {

    private String name;
    private String Description;
    private int nb_episode;
    private String rating;
    private String categories;
    private String studios;
    private String image_url;

    public CommunityBean() {
    }

    public CommunityBean(String name, String description, int nb_episode, String rating, String categories, String studios, String image_url) {
        this.name = name;
        Description = description;
        this.nb_episode = nb_episode;
        this.rating = rating;
        this.categories = categories;
        this.studios = studios;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

package com.example.myapplication;

public class CardItem {
    private int imageResId;
    private String title;
    private String category;
    private float rating;
    private int seats;
    private String price;
    private int companyLogoResId;

    public CardItem(int imageResId, String title, String category,float rating, int seats, String price, int companyLogoResId) {
        this.imageResId = imageResId;
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.seats = seats;
        this.price = price;
        this.companyLogoResId = companyLogoResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public int getSeats() {
        return seats;
    }

    public String getPrice() {
        return price;
    }

    public int getCompanyLogoResId() {
        return companyLogoResId;
    }
}

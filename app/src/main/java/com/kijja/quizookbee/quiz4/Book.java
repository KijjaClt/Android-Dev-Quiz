package com.kijja.quizookbee.quiz4;

import com.google.gson.annotations.SerializedName;

class Book {
    @SerializedName("bookId")
    private int id;

    @SerializedName("bookName")
    private String name;

    @SerializedName("bookAuthor")
    private String author;

    @SerializedName("bookPrice")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("{%d, %s, %s, %.2f}", getId(), getName(), getAuthor(), getPrice());
    }
}

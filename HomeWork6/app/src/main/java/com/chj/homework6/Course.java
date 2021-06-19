package com.chj.homework6;

public class Course {
    int _id;
    String bookName;
    float price;

    public Course(int _id, String bookName, float price) {
        this._id = _id;
        this.bookName = bookName;
        this.price = price;
    }

    public int getId() {
        return _id;
    }

    public String getBookName() {
        return bookName;
    }

    public float getPrice() {
        return price;
    }
}

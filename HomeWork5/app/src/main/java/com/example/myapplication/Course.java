package com.example.myapplication;

public class Course {
    int cid;
    String cname;
    float cprice;

    public Course(int cid, String cname, float cprice) {
        this.cid = cid;
        this.cname = cname;
        this.cprice = cprice;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public float getPrice() {
        return cprice;
    }
}

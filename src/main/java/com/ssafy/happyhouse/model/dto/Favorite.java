package com.ssafy.happyhouse.model.dto;

public class Favorite {
    int idx;
    String name;
    String address;
    String price;

    public Favorite(){
        super();
    }

    public Favorite(int idx, String name, String address, String price) {
        this.idx = idx;
        this.name = name;
        this.address = address;
        this.price = price;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

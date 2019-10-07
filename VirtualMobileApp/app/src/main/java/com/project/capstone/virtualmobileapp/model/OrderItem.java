package com.project.capstone.virtualmobileapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OrderItem implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("item")
    @Expose
    private Item item;


    @SerializedName("number")
    @Expose
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public OrderItem(int id, Item item, int number) {
        this.id = id;
        this.item = item;
        this.number = number;
    }
}

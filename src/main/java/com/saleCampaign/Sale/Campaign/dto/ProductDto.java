package com.saleCampaign.Sale.Campaign.dto;

import jakarta.persistence.Column;

import java.text.DecimalFormat;

public class ProductDto {
    private int productID;


    private String title;


    private String description;


    private long mrp;


    private long currentPrice;

    private double discount;

    public long getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        discount=Double.parseDouble(decimalFormat.format(discount));
        this.discount = discount;
    }

    public long getMrp() {
        return mrp;
    }

    public void setMrp(long mrp) {
        this.mrp = mrp;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

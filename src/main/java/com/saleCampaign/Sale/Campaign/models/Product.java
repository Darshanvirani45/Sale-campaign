package com.saleCampaign.Sale.Campaign.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_product")
public class Product {




    @Id
    @Column(name="pid")
    private int pId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="mrp")
    private long mrp;

    @Column(name="current_price")
    private long currentPrice;


    @Column(name="discount")
    private double discount;

    @Column(name="inventory_count")
    private int inventoryCount;


    @OneToMany(mappedBy = "product")
    private List<History> histories;


    @OneToMany(mappedBy = "productId")
    private List<CampaignDiscount> campaignDiscountList;


    public Product(int pId) {
        this.pId = pId;
    }

    public List<CampaignDiscount> getCampaignDiscountList() {
        return campaignDiscountList;
    }

    public void setCampaignDiscountList(List<CampaignDiscount> campaignDiscountList) {
        this.campaignDiscountList = campaignDiscountList;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }


    public Product() {
    }

    public Product(long currentPrice, String description, double discount, List<History> histories, int inventoryCount, long mrp, int pId, String title) {
        this.currentPrice = currentPrice;
        this.description = description;
        this.discount = discount;
        this.histories = histories;
        this.inventoryCount = inventoryCount;
        this.mrp = mrp;
        this.pId = pId;
        this.title = title;
    }

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
        this.discount = discount;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public long getMrp() {
        return mrp;
    }

    public void setMrp(long mrp) {
        this.mrp = mrp;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

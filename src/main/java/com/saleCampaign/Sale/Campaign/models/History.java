package com.saleCampaign.Sale.Campaign.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="history_id")
    private int historyId;

    @Column(name="date")
    private Date date;

    @Column(name="price")
    private long price;

    @Column(name="discount")
    private double discount;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private Product product;



    public History() {
    }

    public History(Date date, double discount, int historyId, long price, Product product) {
        this.date = date;
        this.discount = discount;
        this.historyId = historyId;
        this.price = price;
        this.product = product;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "History{" +
                "date=" + date +
                ", discount=" + discount +
                ", historyId=" + historyId +
                ", price=" + price +
                '}';
    }
}

package com.saleCampaign.Sale.Campaign.models;

import jakarta.persistence.*;

@Entity
@Table(name="campaign_discount")
public class CampaignDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="campaign_discount_id")
    private int campaignDiscountId;


    @ManyToOne
    @JoinColumn(name = "p_id")
    private Product productId;

    private double discount;

    @ManyToOne
    @JoinColumn(name="c_id")
    private Campaign campaign;



    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public int getCampaignDiscountId() {
        return campaignDiscountId;
    }

    public void setCampaignDiscountId(int campaignDiscountId) {
        this.campaignDiscountId = campaignDiscountId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}

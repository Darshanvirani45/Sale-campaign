package com.saleCampaign.Sale.Campaign.models;

import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "c_id")
    private int cId;

    @Column(name="title")
    private String title;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;




    @OneToMany(mappedBy = "campaign",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CampaignDiscount> campaignDiscountList;


    public Campaign(int cId) {
        this.cId = cId;
    }

    public Campaign() {
    }

    public List<CampaignDiscount> getCampaignDiscountList() {
        return campaignDiscountList;
    }

    public void setCampaignDiscountList(List<CampaignDiscount> campaignDiscountList) {
        this.campaignDiscountList = campaignDiscountList;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

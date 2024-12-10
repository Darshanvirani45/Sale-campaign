package com.saleCampaign.Sale.Campaign.service;

import com.saleCampaign.Sale.Campaign.models.Campaign;
import com.saleCampaign.Sale.Campaign.models.CampaignDiscount;
import com.saleCampaign.Sale.Campaign.models.History;
import com.saleCampaign.Sale.Campaign.repositories.CampaignRepo;
import com.saleCampaign.Sale.Campaign.repositories.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class CampaignSer {

    @Autowired
    private CampaignRepo campaignRepo;

    @Autowired
    private HistoryRepo historyRepo;



    public ResponseEntity<?> addCampaign(Campaign campaign){
        try{

            List<CampaignDiscount> campaignDiscountList=campaign.getCampaignDiscountList();

            for(CampaignDiscount campaignDiscount:campaignDiscountList){
                campaignDiscount.setCampaign(campaign);
            }
            Campaign campaignObj= campaignRepo.save(campaign);
            System.out.println(new Date());
            return new ResponseEntity<>(campaignObj, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed to add campaign",HttpStatus.BAD_REQUEST);
    }


}

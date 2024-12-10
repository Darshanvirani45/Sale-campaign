package com.saleCampaign.Sale.Campaign.controllers;


import com.saleCampaign.Sale.Campaign.models.Campaign;
import com.saleCampaign.Sale.Campaign.models.History;
import com.saleCampaign.Sale.Campaign.models.Product;
import com.saleCampaign.Sale.Campaign.service.CampaignSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/campaign")
public class CampaignCon {

    @Autowired
    private CampaignSer campaignSer;

    @PostMapping("/add-campaign")
    public ResponseEntity<?> addCampaign(@RequestBody Campaign campaign){
        return ResponseEntity.ok(campaignSer.addCampaign(campaign));
    }

}

package com.saleCampaign.Sale.Campaign.service;


import com.saleCampaign.Sale.Campaign.models.Campaign;
import com.saleCampaign.Sale.Campaign.models.CampaignDiscount;
import com.saleCampaign.Sale.Campaign.models.History;
import com.saleCampaign.Sale.Campaign.models.Product;
import com.saleCampaign.Sale.Campaign.repositories.CampaignRepo;
import com.saleCampaign.Sale.Campaign.repositories.HistoryRepo;
import com.saleCampaign.Sale.Campaign.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignApplyService {

    @Autowired
    private CampaignRepo campaignRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private HistoryRepo historyRepo;

        @Transactional
        public void applyCampaign(){
            List<Object[]> list=campaignRepo.getStringCampaignDiscountList();
           List<Campaign>  campaigns = list.stream().map(objects -> campaignRepo.findById((int)objects[0]).get()).filter(campaign -> campaign!=null).collect(Collectors.toList());

           campaigns.forEach(this::applyCampaigns); // this syntax is use when we need to pass only single argument
        }


        @Async
        public void applyCampaigns(Campaign campaign){
            List<CampaignDiscount> campaignDiscounts=campaign.getCampaignDiscountList();

           List<Product>  products= campaignDiscounts.stream()
                   .map(campaignDiscount -> productRepo.findById(campaignDiscount.getProductId().getpId()).
                           get()).
                   filter(product -> product!=null).collect(Collectors.toList());

          List<History> histories = products.stream().map(product -> createHistory(campaign,product)).filter(history -> history!=null).collect(Collectors.toList());
           historyRepo.saveAll(histories);

           List<Product>  producctList=  campaignDiscounts.stream().map(campaignDiscount -> applyDiscountOnProduct(campaignDiscount,campaignDiscount.getProductId())).collect(Collectors.toList());

    productRepo.saveAll(producctList);
        }

        public History createHistory(Campaign campaign,Product product){
            History history=new History();
            history.setDate(campaign.getStartDate());
            history.setDiscount(product.getDiscount());
            history.setPrice(product.getCurrentPrice());
            history.setProduct(product);
            return history;
        }


        public Product applyDiscountOnProduct(CampaignDiscount campaignDiscount,Product product){
            double discount=campaignDiscount.getDiscount();
            long currentPrice=product.getCurrentPrice();
            long calculateCurrentPrice=(long)(currentPrice-((discount*currentPrice)/100));

            product.setCurrentPrice(calculateCurrentPrice);
            product.setDiscount(discount+product.getDiscount());

            return product;
        }
}



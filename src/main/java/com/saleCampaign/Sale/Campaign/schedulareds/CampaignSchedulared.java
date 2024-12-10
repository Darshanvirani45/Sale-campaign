package com.saleCampaign.Sale.Campaign.schedulareds;

import com.saleCampaign.Sale.Campaign.models.Campaign;
import com.saleCampaign.Sale.Campaign.models.CampaignDiscount;
import com.saleCampaign.Sale.Campaign.models.History;
import com.saleCampaign.Sale.Campaign.models.Product;
import com.saleCampaign.Sale.Campaign.repositories.CampaignRepo;
import com.saleCampaign.Sale.Campaign.repositories.HistoryRepo;
import com.saleCampaign.Sale.Campaign.repositories.ProductRepo;
import com.saleCampaign.Sale.Campaign.service.CampaignApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class CampaignSchedulared {

    @Autowired
    private CampaignRepo campaignRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private HistoryRepo historyRepo;

    @Autowired
    private CampaignApplyService campaignApplyService;

    @Scheduled(cron = "0 0 0 * * *")
    public void setCampaignDiscount(){
        System.out.println(new java.util.Date());
//        List<Object[]> list=campaignRepo.getStringCampaignDiscountList();
//
//        for(Object[] objects:list){
//            Campaign campaign=campaignRepo.findById((int)objects[0]).get();
//            for(CampaignDiscount campaignDiscount:campaign.getCampaignDiscountList()){
//                Product product=productRepo.findById(campaignDiscount.getProductId().getpId()).get();
//
//                //make history of product
//                History history=new History();
//                history.setDate(new Date(System.currentTimeMillis()));
//                history.setProduct(product);
//                history.setDiscount(product.getDiscount());
//                history.setPrice(product.getCurrentPrice());
//
//                //change current price pf product
//
//                double discount=campaignDiscount.getDiscount();
//                long currentPrice=product.getCurrentPrice();
//                long calculateCurrentPrice=(long)(currentPrice-((discount*currentPrice)/100));
//
//                product.setCurrentPrice(calculateCurrentPrice);
//                product.setDiscount(discount+product.getDiscount());
//
//                productRepo.save(product);
//                historyRepo.save(history);
//            }
//        }

        campaignApplyService.applyCampaign();
        System.out.println(new java.util.Date());
    }

    @Scheduled(cron="59 59 23 * * *")
    public void removeCampaignDiscount(){

        List<Object[]> list=campaignRepo.getEndingCampaignDiscountList();

        for(Object[] objects:list){
            Campaign campaign=campaignRepo.findById((int)objects[0]).get();
            for(CampaignDiscount campaignDiscount:campaign.getCampaignDiscountList()) {
                History oldHistory=historyRepo.getHistory(campaign.getStartDate(),campaignDiscount.getProductId().getpId());

                //find product
                Product product=productRepo.findById(campaignDiscount.getProductId().getpId()).get();

                History newHistory=new History();
                newHistory.setProduct(product);
                newHistory.setDiscount(product.getDiscount());
                newHistory.setPrice(product.getCurrentPrice());
                newHistory.setDate(new Date(System.currentTimeMillis()));

                // make change in product to remove campaign

                product.setCurrentPrice(oldHistory.getPrice());
                product.setDiscount(oldHistory.getDiscount());

                productRepo.save(product);
                historyRepo.save(newHistory);

            }
        }
    }
}

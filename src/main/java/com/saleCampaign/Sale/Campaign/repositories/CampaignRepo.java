package com.saleCampaign.Sale.Campaign.repositories;

import com.saleCampaign.Sale.Campaign.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign,Integer> {

    @Query(nativeQuery = true,value = "select * from campaign where start_date=current_date()")
    List<Object[]> getStringCampaignDiscountList();

    @Query(nativeQuery = true,value = "select * from campaign where end_date=current_date()")
    List<Object[]> getEndingCampaignDiscountList();


}

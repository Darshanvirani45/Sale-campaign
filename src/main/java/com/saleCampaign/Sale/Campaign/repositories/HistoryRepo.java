package com.saleCampaign.Sale.Campaign.repositories;

import com.saleCampaign.Sale.Campaign.models.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface HistoryRepo extends JpaRepository<History,Integer> {

    @Query(value = "select * from history where date=?1 and p_id=?2",nativeQuery = true)
    History getHistory(Date date,int pId);
}

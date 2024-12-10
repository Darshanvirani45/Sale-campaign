package com.saleCampaign.Sale.Campaign.repositories;

import com.saleCampaign.Sale.Campaign.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}

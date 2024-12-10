package com.saleCampaign.Sale.Campaign.service;

import com.saleCampaign.Sale.Campaign.dto.PageDto;
import com.saleCampaign.Sale.Campaign.dto.ProductDto;
import com.saleCampaign.Sale.Campaign.models.Product;
import com.saleCampaign.Sale.Campaign.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductSer {

    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<?> saveAllProduct(List<Product> products){
        System.out.println(new Date());
        try{
            List<Product> list=productRepo.saveAll(products);
            System.out.println(new Date());
            return new ResponseEntity<>(list, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Entry Failed",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?>  sort(String filed) {
        try{
            return new ResponseEntity<>(productRepo.findAll(Sort.by(Sort.Direction.DESC,filed)),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Data not found",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> getProduct(int offset, int pageSize) {
        try{
            Pageable  pageable=PageRequest.of(offset,pageSize);
            Page<Product> page=productRepo.findAll(pageable);

            List<ProductDto> list=new ArrayList<>();
            for (Product product:page.getContent()){
                ProductDto productDto=new ProductDto();
                productDto.setProductID(product.getpId());
                productDto.setDescription(product.getDescription());
                productDto.setDiscount(product.getDiscount());
                productDto.setTitle(product.getTitle());
                productDto.setMrp(product.getMrp());
                productDto.setCurrentPrice(product.getCurrentPrice());

                list.add(productDto);
            }

            PageDto pageDto=new PageDto();
            pageDto.setProducts(list);
            pageDto.setPage(offset);
            pageDto.setPageSize(pageSize);
            pageDto.setTotalPages(page.getTotalPages());
            return new ResponseEntity<>(pageDto,HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("no data found",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getProductAndSort(int offset, int pageSize,String field) {
        try{
            Pageable  pageable=PageRequest.of(offset,pageSize).withSort(Sort.by(Sort.Direction.DESC,field));
            Page<Product> page=productRepo.findAll(pageable);

            List<ProductDto> list=new ArrayList<>();
            for (Product product:page.getContent()){
                ProductDto productDto=new ProductDto();
                productDto.setProductID(product.getpId());
                productDto.setDescription(product.getDescription());
                productDto.setDiscount(product.getDiscount());
                productDto.setTitle(product.getTitle());
                productDto.setMrp(product.getMrp());
                productDto.setCurrentPrice(product.getCurrentPrice());

                list.add(productDto);
            }

            PageDto pageDto=new PageDto();
            pageDto.setProducts(list);
            pageDto.setPage(offset);
            pageDto.setPageSize(pageSize);
            pageDto.setTotalPages(page.getTotalPages());
            return new ResponseEntity<>(pageDto,HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("no data found",HttpStatus.BAD_REQUEST);
    }



}

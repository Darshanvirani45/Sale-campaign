package com.saleCampaign.Sale.Campaign.dto;

import com.saleCampaign.Sale.Campaign.models.Product;

import java.util.List;

public class PageDto {
    private List<ProductDto> products;
    private int page;
    private int pageSize;
    private int totalPages;

    public PageDto() {
    }

    public PageDto(int page, int pageSize, List<ProductDto> products, int totalPages) {
        this.page = page;
        this.pageSize = pageSize;
        this.products = products;
        this.totalPages = totalPages;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}

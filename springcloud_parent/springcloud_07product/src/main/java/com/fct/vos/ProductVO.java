package com.fct.vos;

import com.fct.entity.Product;

import java.util.List;

public class ProductVO {
    private List<Product> products;
    private Long rows;

    public ProductVO(List<Product> products, Long rows) {
        this.products = products;
        this.rows = rows;
    }

    public ProductVO() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getRows() {
        return rows;
    }

    public void setRows(Long rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "products=" + products +
                ", rows=" + rows +
                '}';
    }
}

package com.hj.aftersaleservice.domain;

import java.math.BigDecimal;

public class Product {
    private Integer product_id; //产品id
    private String product_type; //产品类型
    private String product_brand; //产品品牌
    private String product_name; //产品名称
    private String product_spec; //规格型号
    private String product_factory; //生产厂家
    private String product_detail; //产品详情
    private BigDecimal sale_price; //销售价
    private BigDecimal purchase_price; //采购价

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_spec() {
        return product_spec;
    }

    public void setProduct_spec(String product_spec) {
        this.product_spec = product_spec;
    }

    public String getProduct_factory() {
        return product_factory;
    }

    public void setProduct_factory(String product_factory) {
        this.product_factory = product_factory;
    }

    public String getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(String product_detail) {
        this.product_detail = product_detail;
    }

    public BigDecimal getSale_price() {
        return sale_price;
    }

    public void setSale_price(BigDecimal sale_price) {
        this.sale_price = sale_price;
    }

    public BigDecimal getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(BigDecimal purchase_price) {
        this.purchase_price = purchase_price;
    }
}

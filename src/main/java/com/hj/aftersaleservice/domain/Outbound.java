package com.hj.aftersaleservice.domain;

import java.math.BigDecimal;

public class Outbound {
    private Integer outbound_id;
    private String buyer;
    private String productName;
    private String productSpec;
    private BigDecimal sell_price;
    private Integer quantity;
    private BigDecimal cost;
    private String salesclerk;
    private String outbound_time;

    public Outbound() {
        super();
    }

    public Outbound(String buyer, String productName, String productSpec, BigDecimal sell_price,
                    Integer quantity, BigDecimal cost, String salesclerk, String outbound_time) {
        this.buyer = buyer;
        this.productName = productName;
        this.productSpec = productSpec;
        this.sell_price = sell_price;
        this.quantity = quantity;
        this.cost = cost;
        this.salesclerk = salesclerk;
        this.outbound_time = outbound_time;
    }

    public Integer getOutbound_id() {
        return outbound_id;
    }

    public void setOutbound_id(Integer outbound_id) {
        this.outbound_id = outbound_id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public BigDecimal getSell_price() {
        return sell_price;
    }

    public void setSell_price(BigDecimal sell_price) {
        this.sell_price = sell_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getSalesclerk() {
        return salesclerk;
    }

    public void setSalesclerk(String salesclerk) {
        this.salesclerk = salesclerk;
    }

    public String getOutbound_time() {
        return outbound_time;
    }

    public void setOutbound_time(String outbound_time) {
        this.outbound_time = outbound_time;
    }
}

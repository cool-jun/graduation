package com.hj.aftersaleservice.domain;

import java.math.BigDecimal;

public class Inbound {
    private Integer inbound_id; //id
    private String counterpart; //交易方
    private String inbound_way; //入库方式
    private String product_name; //产品名称
    private String product_spec; //规格型号
    private BigDecimal unit_price; //单价
    private Integer amount; //数量
    private BigDecimal cargo_value; //货值
    private String operator; //操作员
    private String inbound_time; //入库时间

    public Integer getInbound_id() {
        return inbound_id;
    }

    public void setInbound_id(Integer inbound_id) {
        this.inbound_id = inbound_id;
    }

    public String getCounterpart() {
        return counterpart;
    }

    public void setCounterpart(String counterpart) {
        this.counterpart = counterpart;
    }

    public String getInbound_way() {
        return inbound_way;
    }

    public void setInbound_way(String inbound_way) {
        this.inbound_way = inbound_way;
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

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getCargo_value() {
        return cargo_value;
    }

    public void setCargo_value(BigDecimal cargo_value) {
        this.cargo_value = cargo_value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getInbound_time() {
        return inbound_time;
    }

    public void setInbound_time(String inbound_time) {
        this.inbound_time = inbound_time;
    }
}

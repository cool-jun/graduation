package com.hj.aftersaleservice.domain;

import java.math.BigDecimal;

public class SaleReport {
    private String c; //客户
    private String tel; //电话
    private String area; //小区
    private String p_name; //产品
    private String p_spec; //规格型号
    private Integer amount; //数量
    private BigDecimal price; //单价
    private BigDecimal total; //小计
    private String s_type; //销售类型
    private String s_person; //销售员
    private String s_date; //销售日期

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_spec() {
        return p_spec;
    }

    public void setP_spec(String p_spec) {
        this.p_spec = p_spec;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public String getS_person() {
        return s_person;
    }

    public void setS_person(String s_person) {
        this.s_person = s_person;
    }

    public String getS_date() {
        return s_date;
    }

    public void setS_date(String s_date) {
        this.s_date = s_date;
    }
}

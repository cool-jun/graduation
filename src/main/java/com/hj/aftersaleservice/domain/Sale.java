package com.hj.aftersaleservice.domain;

import java.math.BigDecimal;

public class Sale {
    private Integer sale_id; //销售id
    private String customer_name; //姓名
    private String telephone; //电话
    private String address; //地址
    private String area; //区域/小区
    private String service_status; //服务状态
    private String sponsor; //介绍人
    private String sale_number; //销售单号
    private String sale_type; //销售分类
    private String product_name; //产品名称
    private String product_spec; //规格/型号
    private BigDecimal price; //价格
    private Integer number; //数量
    private BigDecimal money; //金额
    private String sale_person; //销售员
    private String sale_date; //销售日期

    public Sale() {
        super();
    }

    public Sale(String customer_name, String telephone, String address, String area, String service_status,
                String sponsor, String sale_number, String sale_type, String product_name, BigDecimal price,
                Integer number, BigDecimal money, String sale_person, String sale_date, String product_spec) {
        this.customer_name = customer_name;
        this.telephone = telephone;
        this.address = address;
        this.area = area;
        this.service_status = service_status;
        this.sponsor = sponsor;
        this.sale_number = sale_number;
        this.sale_type = sale_type;
        this.product_name = product_name;
        this.price = price;
        this.number = number;
        this.money = money;
        this.sale_person = sale_person;
        this.sale_date = sale_date;
        this.product_spec = product_spec;
    }

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getService_status() {
        return service_status;
    }

    public void setService_status(String service_status) {
        this.service_status = service_status;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSale_number() {
        return sale_number;
    }

    public void setSale_number(String sale_number) {
        this.sale_number = sale_number;
    }

    public String getSale_type() {
        return sale_type;
    }

    public void setSale_type(String sale_type) {
        this.sale_type = sale_type;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getSale_person() {
        return sale_person;
    }

    public void setSale_person(String sale_person) {
        this.sale_person = sale_person;
    }

    public String getSale_date() {
        return sale_date;
    }

    public void setSale_date(String sale_date) {
        this.sale_date = sale_date;
    }
}

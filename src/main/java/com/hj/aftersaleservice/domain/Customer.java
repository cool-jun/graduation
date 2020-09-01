package com.hj.aftersaleservice.domain;

public class Customer {
    private Integer customer_id;  //id
    private String customer_name;  //姓名
    private String telephone;  //联系电话
    private String address;  //联系地址
    private String area;  //区域
    private String sale_type;  //销售分类
    private String service_status; //服务状态
    private String sponsor; //介绍人

    public Customer() {
        super();
    }

    public Customer(String customer_name, String telephone, String address,
                    String area, String sale_type, String service_status, String sponsor) {
        this.customer_name = customer_name;
        this.telephone = telephone;
        this.address = address;
        this.area = area;
        this.sale_type = sale_type;
        this.service_status = service_status;
        this.sponsor = sponsor;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
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

    public String getSale_type() {
        return sale_type;
    }

    public void setSale_type(String sale_type) {
        this.sale_type = sale_type;
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
}

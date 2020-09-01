package com.hj.aftersaleservice.domain;

public class StockCheck {
    private Integer stock_id;
    private String commodity_name; //商品名称
    private String commodity_spec; //规格型号
    private Integer current_stock; //当前库存

    public StockCheck() {
        super();
    }

    public StockCheck(String commodity_name, String commodity_spec) {
        this.commodity_name = commodity_name;
        this.commodity_spec = commodity_spec;
    }

    public StockCheck(String commodity_name, String commodity_spec, Integer current_stock) {
        this.commodity_name = commodity_name;
        this.commodity_spec = commodity_spec;
        this.current_stock = current_stock;
    }

    public Integer getStock_id() {
        return stock_id;
    }

    public void setStock_id(Integer stock_id) {
        this.stock_id = stock_id;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCommodity_spec() {
        return commodity_spec;
    }

    public void setCommodity_spec(String commodity_spec) {
        this.commodity_spec = commodity_spec;
    }

    public Integer getCurrent_stock() {
        return current_stock;
    }

    public void setCurrent_stock(Integer current_stock) {
        this.current_stock = current_stock;
    }
}

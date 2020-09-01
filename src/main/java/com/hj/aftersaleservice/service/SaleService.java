package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.Sale;
import com.hj.aftersaleservice.domain.SaleReport;

import java.util.List;

public interface SaleService {
    /**
     * 新增销售记录
     * @param sale 参数
     */
    boolean addSaleInfo(Sale sale);

    /**
     * 根据id得到销售记录
     * @param sale_id
     * @return
     */
    Sale getSaleById(Integer sale_id);

    /**
     * 根据id删除销售记录
     * @param sale_id
     * @return
     */
    boolean deleteSaleById(Integer sale_id);

    List<Sale> getPurchaseListByTelephone(String telephone, String purchase_keyword);

    /**
     * 根据条件得到销售记录
     * @param keywords
     * @return
     */
    List<Sale> getAllSaleList(String keywords);

    /**
     * 修改销售信息
     * @param sale
     * @return
     */
    boolean modifySale(Sale sale);

    List<SaleReport> getAllSaleReportList(String saleReportWords);

    List<SaleReport> getAllSaleReportExcel(String saleReportExcel);
}

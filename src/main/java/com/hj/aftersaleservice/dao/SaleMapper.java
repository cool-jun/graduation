package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.Sale;
import com.hj.aftersaleservice.domain.SaleReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleMapper {
    int addSaleInfo(Sale sale);

    Sale getSaleById(@Param(value = "sale_id") Integer sale_id);

    int deleteSaleById(@Param(value = "sale_id") Integer sale_id);

    List<Sale> getAllSaleList(@Param(value = "keywords") String keywords);

    List<Sale> getPurchaseListByTelephone(@Param(value = "telephone") String telephone,
                                          @Param(value = "purchase_keyword") String purchase_keyword);

    int modifySale(Sale sale);

    List<SaleReport> getAllSaleReportList(@Param(value = "saleReportWords") String saleReportWords);

    List<SaleReport> getAllSaleReportExcel(@Param(value = "saleReportExcel") String saleReportExcel);
}

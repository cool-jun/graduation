package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.SaleMapper;
import com.hj.aftersaleservice.domain.Sale;
import com.hj.aftersaleservice.domain.SaleReport;
import com.hj.aftersaleservice.service.SaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Resource
    private SaleMapper saleMapper;

    @Override
    public boolean addSaleInfo(Sale sale) {
        boolean flag = false;
        if (saleMapper.addSaleInfo(sale) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Sale getSaleById(Integer sale_id) {
        return saleMapper.getSaleById(sale_id);
    }

    @Override
    public boolean deleteSaleById(Integer sale_id) {
        boolean flag = false;
        if (saleMapper.deleteSaleById(sale_id) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Sale> getAllSaleList(String keywords) {
        return saleMapper.getAllSaleList(keywords);
    }

    @Override
    public boolean modifySale(Sale sale) {
        boolean flag = false;
        if (saleMapper.modifySale(sale) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<SaleReport> getAllSaleReportList(String saleReportWords) {
        return saleMapper.getAllSaleReportList(saleReportWords);
    }

    @Override
    public List<SaleReport> getAllSaleReportExcel(String saleReportExcel) {
        return saleMapper.getAllSaleReportExcel(saleReportExcel);
    }

    @Override
    public List<Sale> getPurchaseListByTelephone(String telephone, String purchase_keyword) {
        return saleMapper.getPurchaseListByTelephone(telephone, purchase_keyword);
    }
}

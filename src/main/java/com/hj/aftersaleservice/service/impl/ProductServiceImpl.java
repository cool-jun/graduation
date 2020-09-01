package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.ProductMapper;
import com.hj.aftersaleservice.domain.Product;
import com.hj.aftersaleservice.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public boolean addProductInfo(Product product) {
        boolean flag = false;
        if (productMapper.addProductInfo(product) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Product> getAllProductList(String product_name, String product_type, String product_brand) {
        return productMapper.getAllProductList(product_name, product_type, product_brand);
    }

    @Override
    public boolean deleteProductById(Integer product_id) {
        boolean flag = false;
        if (productMapper.deleteProductById(product_id) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Product showProductById(Integer product_id) {
        return productMapper.showProductById(product_id);
    }

    @Override
    public boolean modifyProduct(Product product) {
        boolean flag = false;
        if (productMapper.modifyProduct(product) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Product getProductById(Integer product_id) {
        return productMapper.getProductById(product_id);
    }

    @Override
    public List<Product> getProductNameList() {
        return productMapper.getProductNameList();
    }

    @Override
    public BigDecimal getPriceByProduct(String product_name, String product_spec) {
        return productMapper.getPriceByProduct(product_name, product_spec);
    }

    @Override
    public List<Product> getProductSpecList(String product_name) {
        return productMapper.getProductSpecList(product_name);
    }
}

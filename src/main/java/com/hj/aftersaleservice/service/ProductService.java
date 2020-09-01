package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    /**
     * 新增产品信息
     * @param product
     * @return
     */
    boolean addProductInfo(Product product);

    /**
     * 根据条件查询所有的产品记录
     * @param product_name
     * @param product_type
     * @param product_brand
     * @return
     */
    List<Product> getAllProductList(String product_name, String product_type, String product_brand);

    /**
     * 通过id删除产品信息
     * @param product_id
     * @return
     */
    boolean deleteProductById(Integer product_id);

    /**
     * 通过id查看产品信息
     * @param product_id
     * @return
     */
    Product showProductById(Integer product_id);

    /**
     * 修改产品信息
     * @param product
     * @return
     */
    boolean modifyProduct(Product product);

    /**
     * 根据id得到产品信息
     * @param product_id
     * @return
     */
    Product getProductById(Integer product_id);

    /**
     * 得到产品名称列表
     * @return
     */
    List<Product> getProductNameList();

    /**
     * 得到规格/型号列表
     * @return
     */
    List<Product> getProductSpecList(String product_name);

    /**
     * 根据产品名得到产品价格
     * @param product_name
     * @return
     */
    BigDecimal getPriceByProduct(String product_name, String product_spec);
}

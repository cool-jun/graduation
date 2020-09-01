package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductMapper {
    int addProductInfo(Product product);

    List<Product> getAllProductList(@Param(value = "product_name") String product_name,
                                      @Param(value = "product_type") String product_type,
                                      @Param(value = "product_brand") String product_brand);

    int deleteProductById(@Param(value = "product_id") Integer product_id);

    Product showProductById(@Param(value = "product_id") Integer product_id);

    int modifyProduct(Product product);

    Product getProductById(@Param(value = "product_id") Integer product_id);

    List<Product> getProductNameList();

    List<Product> getProductSpecList(@Param(value = "product_name") String product_name);

    BigDecimal getPriceByProduct(@Param(value = "product_name") String product_name,
                                 @Param(value = "product_spec") String product_spec);
}

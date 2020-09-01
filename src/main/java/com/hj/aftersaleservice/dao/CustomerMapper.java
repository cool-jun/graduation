package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int addCustomerInfo(Customer customer);

    List<Customer> getAllCustomerList(@Param(value = "customer_name") String customer_name,
                                   @Param(value = "telephone") String telephone,
                                   @Param(value = "area") String area);

    int deleteCustomerById(@Param(value = "customer_id") Integer customer_id);

    Customer showCustomerById(@Param(value = "customer_id") Integer customer_id);

    int modifyCustomer(Customer customer);

    Customer getCustomerById(@Param(value = "customer_id") Integer customer_id);

    Customer getCustomerByTelephone(@Param(value = "telephone") String telephone);
}

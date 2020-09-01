package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * 增加客户信息
     * @param customer
     * @return
     */
    boolean addCustomerInfo(Customer customer);

    /**
     * 根据条件查询所有的客户记录
     * @param customer_name
     * @param telephone
     * @param area
     * @return
     */
    List<Customer> getAllCustomerList(String customer_name, String telephone, String area);

    /**
     * 通过id删除客户信息
     * @param customer_id
     * @return
     */
    boolean deleteCustomerById(Integer customer_id);

    /**
     * 通过id查看客户信息
     * @param customer_id
     * @return
     */
    Customer showCustomerById(Integer customer_id);

    /**
     * 修改客户信息
     * @param customer
     * @return
     */
    boolean modifyCustomer(Customer customer);

    /**
     * 根据id得到客户信息
     * @param customer_id
     * @return
     */
    Customer getCustomerById(Integer customer_id);

    Customer getCustomerByTelephone(String telephone);
}

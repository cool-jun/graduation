package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.CustomerMapper;
import com.hj.aftersaleservice.domain.Customer;
import com.hj.aftersaleservice.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public boolean addCustomerInfo(Customer customer) {
        boolean flag = false;
        if (customerMapper.addCustomerInfo(customer) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Customer> getAllCustomerList(String customer_name, String telephone, String area) {
        return customerMapper.getAllCustomerList(customer_name, telephone, area);
    }

    @Override
    public boolean deleteCustomerById(Integer customer_id) {
        boolean flag = false;
        if (customerMapper.deleteCustomerById(customer_id) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Customer showCustomerById(Integer customer_id) {
        return customerMapper.showCustomerById(customer_id);
    }

    @Override
    public boolean modifyCustomer(Customer customer) {
        boolean flag = false;
        if (customerMapper.modifyCustomer(customer) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Customer getCustomerById(Integer customer_id) {
        return customerMapper.getCustomerById(customer_id);
    }

    @Override
    public Customer getCustomerByTelephone(String telephone) {
        return customerMapper.getCustomerByTelephone(telephone);
    }
}

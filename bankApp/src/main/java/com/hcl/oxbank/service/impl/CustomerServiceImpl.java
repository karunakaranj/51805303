package com.hcl.oxbank.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.oxbank.beans.CustomerBean;
import com.hcl.oxbank.customExc.CustomException;
import com.hcl.oxbank.model.Customer;
import com.hcl.oxbank.repository.CustomerRepo;
import com.hcl.oxbank.service.CustomerService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	@Override
	public String addCustomer(CustomerBean customerBean) {

		String successMessage = null;
		Customer customer = new Customer();

		if (customerBean != null) {
			int noOfAcc = custRepo.findByName(customerBean.getName());
			if (noOfAcc >= 2) {
				throw new CustomException("Record not found");
			} else {
				try {
					BeanUtils.copyProperties(customer, customerBean);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				if (custRepo.save(customer) != null) {
					successMessage = "Contrags! Customer created.";
				} else {
					successMessage = "Failed to create customer.";
				}
			}
		}
		return successMessage;
	}
}
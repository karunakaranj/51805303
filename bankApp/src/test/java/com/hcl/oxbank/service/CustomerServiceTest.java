package com.hcl.oxbank.service;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.oxbank.beans.CustomerBean;
import com.hcl.oxbank.model.Customer;
import com.hcl.oxbank.repository.CustomerRepo;
import com.hcl.oxbank.service.impl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@Mock
	private CustomerRepo customerRepo;
	
	@Test
	public void createAccount() {
		CustomerBean custBean = new CustomerBean(1, "Laxman verma", "903939304", "Bangalore", "Male");
		String expectedMessage = "Contrags! Customer created.";
		Customer customer = new Customer();
		try {
			BeanUtils.copyProperties(customer, custBean);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		Mockito.when(customerRepo.save(Mockito.anyObject())).thenReturn(customer);
		String actualMessage = customerServiceImpl.addCustomer(custBean);
		
		assertEquals(expectedMessage, actualMessage);
		
	}
	
}

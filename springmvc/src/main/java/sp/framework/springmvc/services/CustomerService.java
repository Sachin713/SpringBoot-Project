package sp.framework.springmvc.services;

import sp.framework.springmvc.domain.Customer;
import sp.framework.springmvc.domain.Product;

import java.util.List;

public interface CustomerService {
	//this service is for just customers 
	
    List<Customer> listOfAllCustomers();

    Customer getCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(Integer id);
}

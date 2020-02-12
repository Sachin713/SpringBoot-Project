package sp.framework.springmvc.services;

import org.springframework.stereotype.Service;
import sp.framework.springmvc.domain.Customer;
import sp.framework.springmvc.domain.Product;

import java.math.BigDecimal;
import java.util.*;


@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadProducts();
    }


    private void loadProducts(){
        customers = new HashMap<>();
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Micheal");
        customer1.setLastName("Weston");
        customer1.setAddressLine1("1 Main St");
        customer1.setCity("Miami");
        customer1.setState("Florida");
        customer1.setZipCode("33101");
        customer1.setEmail("micheal@burnnotice.com");
        customer1.setPhoneNumber("305.333.0101");


        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Fiona");
        customer2.setLastName("Glenanne");
        customer2.setAddressLine1("1 Key Biscane Ave");
        customer2.setCity("Miami");
        customer2.setState("Florida");
        customer2.setZipCode("33101");
        customer2.setEmail("fiona@burnnotice.com");
        customer2.setPhoneNumber("305.323.0233");

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Sam");
        customer3.setLastName("Axe");
        customer3.setAddressLine1("1 Little Cuba Road");
        customer3.setCity("Miami");
        customer3.setState("Florida");
        customer3.setZipCode("33101");
        customer3.setEmail("sam@burnnotice.com");
        customer3.setPhoneNumber("305.426.9832");

        customers.put(1, customer1);
        customers.put(2, customer2);
        customers.put(3, customer3);
    }

    @Override
    public List<Customer> listOfAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
       return  customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if(customer != null){
            if(customer.getId() == null)
                customer.setId(getNextKey());
            customers.put(customer.getId(),customer);
            return  customer;
        }else
            throw  new RuntimeException("Customer can not be nill");
    }
    private Integer getNextKey(){
        return Collections.max(customers.keySet())+1;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }
}

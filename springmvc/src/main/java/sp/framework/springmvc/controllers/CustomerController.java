package sp.framework.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sp.framework.springmvc.domain.Customer;
import sp.framework.springmvc.domain.Product;
import sp.framework.springmvc.services.CustomerService;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){this.customerService = customerService;}

    @RequestMapping("/customers")
    public String listOfCustomers(Model model) {
        model.addAttribute("customers", customerService.listOfAllCustomers());
        return "customers";
    }

    @RequestMapping("/customer/{id}")
    public String listOfCustomers(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    @RequestMapping("/customer/new")
    public String newProduct(Model model){
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customer/" + savedCustomer.getId();
    }

    @RequestMapping("/customer/edit/{id}")
    public String edit(@PathVariable Integer id, Model  model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerform";
    }
    @RequestMapping("/customer/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}

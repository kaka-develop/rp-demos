package com.cmc.demo.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmc.demo.model.Customer;
import com.cmc.demo.service.CustomerService;
import com.cmc.demo.util.ConverterUtil;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = { "", "/all" })
    public String getAll(Model model) {
        model.addAttribute("customers",customerService.findAll());
        return "customer-all";
    }
    
    @GetMapping(value = { "/add"})
    public String getAdd(Model model) {
      model.addAttribute("customer",new Customer());
      return "form-customer";
    }
    
    @GetMapping(value = { "/edit"})
    public String getEdit(Model model, @Param(value = "id") String id) {
      model.addAttribute("customer",customerService.findById(ConverterUtil.convertStringToInteger(id)));
      return "form-customer";
    }
    
    @PostMapping(value = { "/save"})
    public String add (@ModelAttribute Customer customer) {
      customerService.save(customer);
      return "redirect:/customer";
    }
    
    @GetMapping(value = { "/delete"})
    public String add (@Param(value = "id") String id) {
      customerService.delete(Integer.parseInt(id));
      return "redirect:/customer";
    }

}

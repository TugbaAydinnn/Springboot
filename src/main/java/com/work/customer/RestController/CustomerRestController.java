package com.work.customer.RestController;

import com.work.customer.Entities.Customer;
import com.work.customer.Repositories.CustomerRepository;
import com.work.customer.Services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerRestController {
    final CustomerService customerService;

    @PostMapping("/customer/save")
    public ResponseEntity save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @GetMapping("/customer/list")
    public ResponseEntity list(){

        return customerService.list();
    }
    @PostMapping("/customer/deleteCustomer/{cid}")
    public ResponseEntity deleteCustomer(@PathVariable("cid") Long cid){
        return customerService.deleteCustomer(cid);

    }
}

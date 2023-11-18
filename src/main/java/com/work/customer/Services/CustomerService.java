package com.work.customer.Services;

import com.work.customer.Entities.Customer;
import com.work.customer.Repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    final CustomerRepository customerRepository;
    public ResponseEntity save(Customer customer){
        HashMap<String, Object> hm=new LinkedHashMap<>();
        Optional<Customer> emailKontrol=customerRepository.findByEmailEquals(customer.getEmail());
        if(emailKontrol.isPresent()){
            //email varsa
            hm.put("status",false);
            hm.put("result","This email use! "+customer.getEmail());
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);

        }else{
            customerRepository.save(customer);
            hm.put("status",true);
            hm.put("result",customer);
            return new ResponseEntity(hm, HttpStatus.OK);
        }


    }

    public ResponseEntity list(){
        HashMap<String,Object> hm=new LinkedHashMap<>();
        hm.put("result", customerRepository.findAll());
        return new ResponseEntity(hm,HttpStatus.OK);
    }
    public ResponseEntity deleteCustomer(Long cid) {
        HashMap<String,Object> hm=new LinkedHashMap<>();
        Optional<Customer> silinecekId=customerRepository.findByCidEquals(cid);
        if(silinecekId.isEmpty()){
            hm.put("status",false);
            hm.put("result","ID not found!");
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
        }else{
            customerRepository.deleteByCid(cid);
            hm.put("status",true);
            hm.put("result","Id is remove :) ");
            return new ResponseEntity(hm,HttpStatus.OK);
        }
    }
}

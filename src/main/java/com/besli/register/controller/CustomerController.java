package com.besli.register.controller;

import com.besli.register.dto.CustomerDto;
import com.besli.register.dto.RegisterCustomerRequest;
import com.besli.register.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/register")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody @Valid RegisterCustomerRequest request){
        return ResponseEntity.ok(customerService.registerCustomer(request));
    }
    @GetMapping("/{number}")
    public ResponseEntity<CustomerDto> getCustomerByPhoneNumber(@PathVariable String number){
        return ResponseEntity.ok(customerService.getCustomerByPhoneNumber(number));
    }
}

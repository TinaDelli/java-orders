package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customer;
import com.lambdaschool.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/customer/order",
                produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        ArrayList<Customer> myList = orderService.findAllCust();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/name/{custname}",
                produces = {"application/json"})
    public ResponseEntity<?> getCustomerByName(
            @PathVariable
                String custname)
    {
        Customer c = orderService.findCustomerByName(custname);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}

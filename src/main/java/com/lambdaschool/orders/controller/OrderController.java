package com.lambdaschool.orders.controller;

import com.lambdaschool.orders.model.Customer;
import com.lambdaschool.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping(value="/data/customer/new",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                            @RequestBody Customer newCustomer)
    {
        newCustomer = orderService.saveCust(newCustomer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{custname}").buildAndExpand(newCustomer.getCustname()).toUri();
        responseHeaders.setLocation((newCustomerURI));

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/data/customer/update/{custcode}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateCustomerById(
            @RequestBody
            Customer updateCustomer,
            @PathVariable
            long custcode)
    {
        orderService.updateCust(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/data/customer/delete/{custcode}")
    public ResponseEntity<?> deleteCustomerById(
            @PathVariable
            long custcode)
    {
        orderService.deleteCust(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/agent/{agentcode}")
    public ResponseEntity<?>deleteAgentById(
            @PathVariable
            long agentcode)
    {
        orderService.delete(agentcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

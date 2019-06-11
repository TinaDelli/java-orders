package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Agent;
import com.lambdaschool.orders.model.Customer;

import java.util.ArrayList;

public interface OrderService
{
    ArrayList<Agent> findAll();

    Agent findAgentById(long id);

    Agent findAgentByName(String name);

    void delete(long id);

    Agent save(Agent agent);

    Agent update(Agent agent, long id);

    ArrayList<Customer> findAllCust();

    Customer findCustomerById(long id);

    Customer findCustomerByName(String name);

    void deleteCust(long id);

    Customer saveCust(Customer customer);

    Customer updateCust(Customer customer, long id);
}

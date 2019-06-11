package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Agent;
import com.lambdaschool.orders.model.Customer;
import com.lambdaschool.orders.repos.AgentRepository;
import com.lambdaschool.orders.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private CustomerRepository custrepos;

    @Autowired
    private AgentRepository agentrepos;

    @Override
    public ArrayList<Agent> findAll()
    {
        return null;
    }

    @Override
    public Agent findAgentById(long id)
    {
        return null;
    }

    @Override
    public Agent findAgentByName(String name)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }

    @Override
    public Agent save(Agent agent)
    {
        return null;
    }

    @Override
    public Agent update(Agent agent, long id)
    {
        return null;
    }

    @Override
    public ArrayList<Customer> findAllCust()
    {
        return null;
    }

    @Override
    public Customer findCustomerById(long id)
    {
        return null;
    }

    @Override
    public Customer findCustomerByName(String name)
    {
        return null;
    }

    @Override
    public void deleteCust(long id)
    {

    }

    @Override
    public Customer saveCust(Customer customer)
    {
        return null;
    }

    @Override
    public Customer updateCust(Customer customer, long id)
    {
        return null;
    }
}

package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Agent;
import com.lambdaschool.orders.model.Customer;
import com.lambdaschool.orders.model.Order;
import com.lambdaschool.orders.repos.AgentRepository;
import com.lambdaschool.orders.repos.CustomerRepository;
import com.lambdaschool.orders.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private CustomerRepository custrepos;

    @Autowired
    private AgentRepository agentrepos;

    @Autowired
    private OrderRepository orderrepos;

    @Override
    public ArrayList<Agent> findAll()
    {
        ArrayList<Agent> list = new ArrayList<>();
        agentrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Agent findAgentById(long id)
    {
        return agentrepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Agent findAgentByName(String name)
    {
        Agent agent = agentrepos.findByAgentname(name);

        if(agent == null)
        {
            throw new EntityNotFoundException("Agent " + name + " not found!");
        }
        return agent;
    }

    @Override
    public void delete(long id)
    {
        if(agentrepos.findById(id).isPresent())
        {
            agentrepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Agent save(Agent agent)
    {
        Agent newAgent = new Agent();
        newAgent.setAgentname(agent.getAgentname());
        newAgent.setCommission(agent.getCommission());
        newAgent.setCountry(agent.getCountry());
//        newAgent.setCustomers(agent.getCustomers());
//        newAgent.setOrders(agent.getOrders());
        newAgent.setPhone(agent.getPhone());
        newAgent.setWorkingarea(agent.getWorkingarea());

        for (Customer c: agent.getCustomers())
        {
            newAgent.getCustomers().add(new Customer(c.getCustname(), c.getCustcity(), c.getWorkingarea(), c.getCustcountry(), c.getGrade(), c.getOpeningamt(), c.getReceiveamt(), c.getPaymentamt(), c.getOutstandingamt(), c.getPhone(), newAgent));
        }
        return agentrepos.save(newAgent);
    }

  @Transactional
    @Override
    public Agent update(Agent agent, long id)
    {
        Agent currentAgent = agentrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (agent.getAgentname() != null)
        {
            currentAgent.setAgentname(agent.getAgentname());
        }

        if (agent.getCommission() != null)
        {
            currentAgent.setCommission(agent.getCommission());
        }

        if (agent.getCountry() != null)
        {
            currentAgent.setCountry(agent.getCountry());
        }

        if (agent.getPhone() != null)
        {
            currentAgent.setPhone(agent.getPhone());
        }
        if (agent.getWorkingarea() != null)
        {
            currentAgent.setWorkingarea(agent.getWorkingarea());
        }

        if (agent.getCustomers().size() > 0)
        {
            for (Customer c : agent.getCustomers())
            {
                currentAgent.getCustomers().add(new Customer(c.getCustname(), c.getCustcity(), c.getWorkingarea(), c.getCustcountry(), c.getGrade(), c.getOpeningamt(), c.getReceiveamt(), c.getPaymentamt(), c.getOutstandingamt(), c.getPhone(), currentAgent ));
            }
        }
        return null;
    }

    @Override
    public ArrayList<Customer> findAllCust()
    {
        ArrayList<Customer> custlist = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(custlist::add);
        return custlist;
    }

    @Override
    public Customer findCustomerById(long id)
    {
        return custrepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Customer findCustomerByName(String name)
    {
        Customer customer = custrepos.findByCustname(name);

        if(customer == null)
        {
            throw new EntityNotFoundException("Customer " + name + " not found!");
        }
        return customer;
    }

    @Override
    public void deleteCust(long id)
    {
        if(custrepos.findById(id).isPresent())
        {
            custrepos.deleteById(id);
        }
        else
            {
             throw new EntityNotFoundException(Long.toString(id));
            }
    }

    @Transactional
    @Override
    public Customer saveCust(Customer customer)
    {
        Customer newCustomer = new Customer();
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());

        for (Order o: customer.getOrders())
        {
            newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), newCustomer, o.getAgent(), o.getOrdescription()));
        }
        return custrepos.save(newCustomer);
    }



    @Override
    public Customer updateCust(Customer customer, long id)
    {
        Customer currentCustomer = custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (customer.getCustname() != null)
        {
            currentCustomer.setCustname(customer.getCustname());
        }

        if (customer.getCustcity() != null)
        {
            currentCustomer.setCustcity(customer.getCustcity());
        }

        if (customer.getWorkingarea() != null)
        {
            currentCustomer.setWorkingarea(customer.getWorkingarea());
        }

        if (customer.getCustcountry() != null)
        {
            currentCustomer.setCustcountry(customer.getCustcountry());
        }

        if (customer.getGrade() != null)
        {
            currentCustomer.setGrade(customer.getGrade());
        }
        if (customer.getOpeningamt() != 0)
        {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if (customer.getReceiveamt() != 0)
        {
            currentCustomer.setReceiveamt(customer.getReceiveamt());
        }
        if (customer.getPaymentamt() != 0)
        {
            currentCustomer.setPaymentamt(customer.getPaymentamt());
        }
        if (customer.getOutstandingamt() != 0)
        {
            currentCustomer.setOutstandingamt(customer.getOutstandingamt());
        }
        if (customer.getOpeningamt() != 0)
        {
            currentCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if (customer.getPhone() != null)
        {
            currentCustomer.setPhone(customer.getPhone());
        }

        if (customer.getOrders().size() > 0)
        {
            for (Order o : customer.getOrders())
            {
                currentCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), currentCustomer, o.getAgent(), o.getOrdescription()));
            }
        }
        return custrepos.save(currentCustomer);
    }
}

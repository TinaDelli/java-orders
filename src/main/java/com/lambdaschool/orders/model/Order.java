package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    @Column(nullable = false)
    private double ordamount;
    private double advanceamount;

    @ManyToOne
    @JoinColumn(name = "custcode",
                nullable = false)
    @JsonIgnoreProperties("custcode")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "agentcode",
                nullable = false)
    @JsonIgnoreProperties("agentcode")
    private Agent agent;

    private  String ordescription;

    public Order()
    {
    }

    public Order(double ordamount, double advanceamount, Customer customer, Agent agent, String ordescription)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = customer;
        this.agent = agent;
        this.ordescription = ordescription;
    }

    public long getOrdnum()
    {
        return ordnum;
    }

//    public void setOrdnum(long ordnum)
//    {
//        this.ordnum = ordnum;
//    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Agent getAgent()
    {
        return agent;
    }

    public void setAgent(Agent agent)
    {
        this.agent = agent;
    }

    public String getOrdescription()
    {
        return ordescription;
    }

    public void setOrdescription(String ordescription)
    {
        this.ordescription = ordescription;
    }


}

package com.lambdaschool.orders.repos;

import com.lambdaschool.orders.model.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long>
{
    Agent findByAgentname(String name);
}

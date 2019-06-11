package com.lambdaschool.orders.repos;

import com.lambdaschool.orders.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{
    Order findByOrdnum(double amt);
}

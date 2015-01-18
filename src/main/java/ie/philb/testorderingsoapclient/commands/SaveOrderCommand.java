/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.commands;

import ie.philb.testorderingsoapclient.Application;
import ie.philb.testorderingsoapclient.ws.Order;
import ie.philb.testorderingsoapclient.ws.OrderDetail;

/**
 *
 * @author philb
 */
public class SaveOrderCommand extends AbstractCommand<Order, Order> {

    @Override
    public Order execute(Order order) throws Exception {

        logger.info("Saving order " + order.getId());

        for (OrderDetail od : order.getDetails()) {
            logger.info("Order detail to save " + od.getId());
        }

        Order saved = service().saveOrder(order);
        logger.info("Saved order " + saved.getId());

        for (OrderDetail od : saved.getDetails()) {
            logger.info("Saved detail " + od.getId());
        }

        Application.getApplication().refreshOrder(saved);
        return saved;
    }

}

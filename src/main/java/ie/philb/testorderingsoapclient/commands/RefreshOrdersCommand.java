/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.commands;

import ie.philb.testorderingsoapclient.ws.Order;
import java.util.List;

/**
 *
 * @author philb
 */
public class RefreshOrdersCommand extends AbstractCommand<Long, List<Order> > {

    @Override
    public List<Order> execute(Long buyerId) throws Exception {
        
        List<Order> orders = service().getOrdersByBuyer(buyerId);
        app().setOrders(orders);
        
        return orders;
    }
    
}

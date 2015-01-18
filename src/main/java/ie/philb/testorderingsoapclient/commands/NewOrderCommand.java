/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.commands;

import ie.philb.testorderingsoapclient.ws.Order;
import ie.philb.testorderingsoapclient.ws.Party;

/**
 *
 * @author philb
 */
public class NewOrderCommand extends AbstractCommand<Party, Order> {

    @Override
    public Order execute(Party buyer) throws Exception {

        Order order = service().createOrder(buyer.getId());
        order.setBuyer(buyer);
        
        new RefreshOrdersCommand().execute(buyer.getId());
        return order;
    }

}

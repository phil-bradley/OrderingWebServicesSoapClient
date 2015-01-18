/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient;

import ie.philb.testorderingsoapclient.ui.nav.orders.OrderCategory;
import ie.philb.testorderingsoapclient.ws.Order;

/**
 *
 * @author philb
 */
public interface ApplicationListener {

    public void productsUpdated();

    public void orderUpdated(Order oldOrder, Order newOrder);

    public void categoryUpdated(OrderCategory node);
}

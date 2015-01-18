/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.ui.nav.orders;

import ie.philb.testorderingsoapclient.ws.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author philb
 */
public class OrderCategory {

    private Long id;
    private String name;
    private List<Order> orders = new ArrayList<>();

    public OrderCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderCategory {" + "id=" + id + ", name=" + name + ", order count " + orders.size() + '}';
    }



}

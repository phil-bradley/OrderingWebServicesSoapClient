/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient;

import ie.philb.testorderingsoapclient.ws.Money;
import ie.philb.testorderingsoapclient.ws.Order;
import ie.philb.testorderingsoapclient.ws.OrderDetail;
import ie.philb.testorderingsoapclient.ws.Product;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author philb
 */
public class OrderFacade {

    private final Order order;

    public OrderFacade(Order order) {
        this.order = order;
    }

    public OrderFacade() {
        this.order = new Order();
    }

    public Long getId() {
        if (order == null) {
            return 0L;
        }
        return order.getId();
    }

    public Date getCreated() {

        if (order == null) {
            return new Date(0);
        }

        return order.getCreated().toGregorianCalendar().getTime();
    }

    public int getDetailCount() {

        if (order == null) {
            return 0;
        }

        return order.getDetails().size();
    }

    public OrderDetail getDetail(int i) {
        if (order == null) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return order.getDetails().get(i);
    }

    public int getItemCount() {
        int count = 0;

        if (order == null) {
            return count;
        }

        count = order.getDetails().stream().map((od) -> od.getQuantity()).reduce(count, Integer::sum);
        return count;
    }

    public BigDecimal getTotalValue() {
        BigDecimal value = BigDecimal.ZERO;

        if (order == null) {
            return value;
        }

        if (order.getDetails() == null) {
            return value;
        }

        for (OrderDetail od : order.getDetails()) {
            value = value.add(od.getLineTotal().getValue());
        }

        return value;
    }

    public Order getOrder() {
        return order;
    }

    public void addProduct(Product product) {
        OrderDetail d = new OrderDetail();
        d.setQuantity(1);
        d.setSkuCode(product.getSkuCode());
        d.setDescription(product.getDescription());
        d.setUnitPrice(product.getUnitPrice());
        d.setLineTotal(product.getUnitPrice());
        d.setOrderId(order.getId());
               
        order.getDetails().add(d);
    }

}

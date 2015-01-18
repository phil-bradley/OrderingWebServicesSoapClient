/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient;

import ie.philb.testorderingsoapclient.commands.AbstractCommand;
import ie.philb.testorderingsoapclient.ui.nav.orders.OrderCategory;
import ie.philb.testorderingsoapclient.ws.Order;
import ie.philb.testorderingsoapclient.ws.OrderingAppService;
import ie.philb.testorderingsoapclient.ws.OrderingAppService_Service;
import ie.philb.testorderingsoapclient.ws.Party;
import ie.philb.testorderingsoapclient.ws.Product;
import ie.philb.testorderingsoapclient.ws.ServiceException_Exception;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author philb
 */
public class Application {

    protected static final Logger logger = Logger.getLogger(Application.class.getSimpleName());
    private static Application application;

    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<ApplicationListener> listeners = new ArrayList<>();
    private Order order = null;
    private Party buyer;
    private OrderingAppService oas;

    public static synchronized Application getApplication() {
        if (application == null) {
            application = new Application();
        }

        return application;
    }

    private Application() {

    }

    public OrderingAppService getService() {
        initService();
        return oas;
    }

    public void addListener(ApplicationListener l) {
        this.listeners.add(l);
    }

    public void removeListener(ApplicationListener l) {
        this.listeners.remove(l);
    }

    private synchronized void initService() {
        if (oas == null) {
            OrderingAppService_Service oass = new OrderingAppService_Service();
            oas = oass.getOrderingAppServicePort();
        }
    }

    public void load() throws ServiceException_Exception {
        initService();
        products = oas.getProducts();
        buyer = oas.getParty(1L);
        orders = oas.getOrdersByBuyer(buyer.getId());

        logger.info("Got " + orders.size() + " orders");
        fireApplicationProductsUpdated();
    }

    private void fireApplicationProductsUpdated() {
        listeners.stream().forEach((l) -> {
            l.productsUpdated();
        });
    }

    private void fireApplicationOrderUpdated(Order oldOrder, Order newOrder) {
        listeners.stream().forEach((l) -> {
            l.orderUpdated(oldOrder, newOrder);
        });
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderFacade getOrderFacade() {
        return new OrderFacade(order);
    }

    public Party getBuyer() {
        return buyer;
    }

    public void setOrder(Order order) {
        Order oldOrder = this.order;

        this.order = order;
        fireApplicationOrderUpdated(oldOrder, order);
    }

    public Order getOrder(Long orderId) {
        for (Order o : orders) {
            if (Objects.equals(o.getId(), orderId)) {
                return o;
            }
        }
        
        return null;
    }
    
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
        fireApplicationProductsUpdated();
    }

    public void refreshOrder(Order saved) {

        for (int i = 0; i < orders.size(); i++) {
            Order o = orders.get(i);
            if (Objects.equals(o.getId(), saved.getId())) {
                orders.set(i, saved);
                logger.info("Refreshed order " + saved.getId());
                break;
            }
        }
    }

    public void setSelectedCategory(OrderCategory node) {
        fireSelectedCategoryUpdated(node);
    }

    private void fireSelectedCategoryUpdated(OrderCategory node) {
    }

}

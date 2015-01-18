/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.ui.nav.orders;

import ie.philb.testorderingsoapclient.ws.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author philb
 */
public class OrdersTreeModel implements TreeModel {

    private final List<TreeModelListener> treeModelListeners = new ArrayList<>();

    private final OrderCategory root = new OrderCategory(0L, "Orders");
    private final List<OrderCategory> categories = new ArrayList<>();

    public OrdersTreeModel(List<OrderCategory> orderCategories) {
        this.categories.addAll(orderCategories);
    }

//    public void setOrderCategories(List<OrderCategory> categories) {
//        this.categories.clear();
//        this.categories.addAll(categories);
//        
//        List<Object> treePathObjects = new ArrayList<>();
//        treePathObjects.add(root);
//        treePathObjects.add(categories.get(0));
//        
////        TreeModelEvent evt = new TreeModelEvent(this, new TreePath(treePathObjects.toArray()));
////                
////        for (TreeModelListener tnl : treeModelListeners) {
////            tnl.treeNodesChanged(evt);
////        }
//    }
    
    public List<OrderCategory> getOrderCategories() {
        return categories;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {

        Object child = null;

        if (parent instanceof OrderCategory) {
            OrderCategory oc = (OrderCategory) parent;

            if (oc.getId() == 0) {
                child = categories.get(index);
            } else {
                child = oc.getOrders().get(index);
            }
        }

//        System.out.println("Got child " + child + " from parent " + parent + ", idx " + index);
        return child;
    }

    @Override
    public int getChildCount(Object parent) {

        int count = 0;

        if (parent instanceof OrderCategory) {
            OrderCategory oc = (OrderCategory) parent;

            if (oc.getId() == 0) {
                count = categories.size();
            } else {
                count = oc.getOrders().size();
            }
        }

//        System.out.println("Return child count " + count + " for parent " + parent);
        return count;
    }

    @Override
    public boolean isLeaf(Object node) {
        if (node instanceof Order) {
            return true;
        }

        return false;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // Don't care, tree is not editable
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {

        if (child instanceof Order) {
            Order order = (Order) child;
            OrderCategory category = (OrderCategory) parent;
            return getIndexOfOrder(category, order);
        }

        int index = 0;

        if (child instanceof OrderCategory) {
            OrderCategory category = (OrderCategory) child;
            for (OrderCategory oc : categories) {
                if (Objects.equals(category.getId(), oc.getId())) {
                    return index;
                }

                index++;
            }
        }

        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        treeModelListeners.add(l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        treeModelListeners.remove(l);
    }

    private int getIndexOfOrder(OrderCategory category, Order order) {

        int index = 0;

        for (Order o : category.getOrders()) {
            if (Objects.equals(order.getId(), o.getId())) {
                return index;
            }

            index++;
        }

        return 0;
    }
}

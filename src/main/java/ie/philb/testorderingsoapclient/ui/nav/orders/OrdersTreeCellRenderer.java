/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.ui.nav.orders;

import ie.philb.testorderingsoapclient.ws.Order;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author philb
 */
public class OrdersTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (value instanceof OrderCategory) {
            OrderCategory orderCategory = (OrderCategory) value;

            if (orderCategory.getId() == 0) {
                setIcon(new ImageIcon(getClass().getResource("/ie/philb/testorderingsoapclient/icons/mailbox.png")));
                setText("Orders");
            } else {
                setIcon(new ImageIcon(getClass().getResource("/ie/philb/testorderingsoapclient/icons/folder.png")));
                setText(orderCategory.getName());
            }
        }
        
//        if (value instanceof Order) {
//            Order order = (Order)value;
//            setIcon(new ImageIcon(getClass().getResource("/ie/philb/testorderingsoapclient/icons/order.png")));
//            setText("Order " + order.getId());
//        }

        return this;
    }
}

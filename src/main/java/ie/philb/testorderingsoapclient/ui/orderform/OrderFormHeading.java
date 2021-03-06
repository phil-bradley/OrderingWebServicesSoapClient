/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.ui.orderform;

import ie.philb.testorderingsoapclient.Application;
import ie.philb.testorderingsoapclient.ApplicationListener;
import ie.philb.testorderingsoapclient.OrderFacade;
import ie.philb.testorderingsoapclient.ui.nav.orders.OrderCategory;
import ie.philb.testorderingsoapclient.ws.Order;

/**
 *
 * @author philb
 */
public class OrderFormHeading extends javax.swing.JPanel implements ApplicationListener {

    /**
     * Creates new form OrderFormHeading
     */
    public OrderFormHeading() {
        initComponents();
        Application.getApplication().addListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOrderNo = new javax.swing.JLabel();
        lblOrderDate = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();

        lblOrderNo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblOrderNo.setText("Order #");

        lblOrderDate.setText("dd MMM yyyy");

        lblCount.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOrderNo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblOrderDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCount))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblOrderNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderDate)
                    .addComponent(lblCount)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JLabel lblOrderNo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void orderUpdated(Order oldOrder, Order order) {
        OrderFacade of = Application.getApplication().getOrderFacade();
        lblOrderNo.setText("Order " + of.getId());
        lblOrderDate.setText(of.getCreated().toGMTString());
        lblCount.setText(of.getDetailCount() + " lines");
    }

    @Override
    public void productsUpdated() {
    }
    
        
    @Override
    public void categoryUpdated(OrderCategory category) {
        
    }
}

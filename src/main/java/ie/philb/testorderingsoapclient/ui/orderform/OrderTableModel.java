/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.ui.orderform;

import ie.philb.testorderingsoapclient.Application;
import ie.philb.testorderingsoapclient.OrderFacade;
import ie.philb.testorderingsoapclient.ws.OrderDetail;
import ie.philb.testorderingsoapclient.ws.Product;
import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author philb
 */
public class OrderTableModel extends DefaultTableModel {

    private OrderFacade of;
    private NumberFormat currencyFormat = DecimalFormat.getCurrencyInstance();
    private final String[] headings = {"Id", "Sku", "Name", "Unit Price", "Qty", "Line Total"};

    public OrderTableModel() {
    }

    public OrderTableModel(OrderFacade of, NumberFormat currencyFormat) {
        this.of = of;
        this.currencyFormat = currencyFormat;
    }

    @Override
    public int getRowCount() {
        if (of == null) {
            return (0);
        }

        return of.getDetailCount();
    }

    @Override
    public int getColumnCount() {
        return headings.length;
    }

    @Override
    public String getColumnName(int col) {
        if (col < headings.length) {
            return headings[col];
        }

        return ("");
    }

    @Override
    public boolean isCellEditable(int row, int column) {

        if (of.getId() == 0) {
            return false;
        }

//        if (column == 3) {
//            return true;
//        }
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if ((row < 0) || (row >= getRowCount())) {
            return;
        }

        if (col != 3) {
            return;
        }

        long quantity = 0;

        // TODO Figure out how to make the value consistantly
        // long or integer
        if (value instanceof Long) {
            quantity = (Long) value;
        } else {
            quantity = Long.valueOf((Integer) value);
        }

//        if (quantity == 0) {
//            String msg = "Are you sure you wish to remove this line?";
//            if (!Dialogs.showConfirmMessage(msg)) {
//                return;
//            }
//        }
//        of.setQuantity(row, quantity);
    }

    @Override
    public Object getValueAt(int row, int col) {

        if ((row < 0) || (row >= getRowCount())) {
            return null;
        }

        if (col >= headings.length) {
            return null;
        }

        OrderDetail od = of.getDetail(row);
        // Long productId = ol.getProductId();

        switch (col) {
            case 0:
                return od.getId();
            case 1:
                return od.getSkuCode();
            case 2:
                return od.getDescription();
            case 3:
                BigDecimal amt = od.getUnitPrice().getValue();
                //if (currencyFormat == null) {
                //  return amt.setScale(2, RoundingMode.HALF_UP).toString();
                //} else {
                return currencyFormat.format(amt);
            //}

            case 4:
                return od.getQuantity();
            case 5:
                BigDecimal unitPrice = od.getUnitPrice().getValue();
                BigDecimal quantity = BigDecimal.valueOf(od.getQuantity());
                BigDecimal lineTotal = unitPrice.multiply(quantity);

                if (currencyFormat == null) {
                    return lineTotal.setScale(2, RoundingMode.HALF_UP).toString();
                } else {
                    return currencyFormat.format(lineTotal);
                }

        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 0:
                return Long.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return BigDecimal.class;
            case 4:
                return Long.class;
            case 5:
                return BigDecimal.class;
            default:
                return String.class;
        }
    }

//    private Product getProductBySku(String skuCode) throws Exception {
//        List<Product> products = getProducts();
//
//        for (Product product : products) {
//            if (product.getSkuCode().equals(skuCode)) {
//                return product;
//            }
//        }
//
//        throw new Exception("Cannot find product " + skuCode);
//    }
    private List<Product> getProducts() {
        return Application.getApplication().getProducts();
    }

    void setOrder(OrderFacade of) {
        this.of = of;
        fireTableDataChanged();
    }
}

class OrderLineRenderer extends JLabel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        switch (column) {
            case 0:
                setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case 1:
                setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case 2:
                setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case 3:
                setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case 4:
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case 5:
                setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            default:
                setHorizontalAlignment(SwingConstants.LEFT);
        }

        Color stripeColor = new Color(232, 240, 255);

        if ((row % 2) == 0) {
            setBackground(stripeColor);
        } else {
            setBackground(Color.white);
        }

        setOpaque(true);

        return this;
    }
}

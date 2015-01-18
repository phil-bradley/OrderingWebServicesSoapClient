/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.ui.nav.products;

import ie.philb.testorderingsoapclient.ws.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author philb
 */
class ProductListModel extends DefaultListModel<Product> {

    private final List<Product> products = new ArrayList<>();

    public ProductListModel() {
        this(Collections.EMPTY_LIST);
    }

    public ProductListModel(List<Product> products) {
        this.products.addAll(products);
    }

    @Override
    public int getSize() {
        return products.size();
    }

    @Override
    public Product getElementAt(int index) {
        return products.get(index);
    }

    void setProducts(List<Product> products) {
        this.products.clear();
        this.products.addAll(products);
        fireContentsChanged(this, 0, products.size() - 1);
    }
    
}

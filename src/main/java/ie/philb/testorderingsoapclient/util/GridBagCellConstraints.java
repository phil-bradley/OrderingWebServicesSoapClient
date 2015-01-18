package ie.philb.testorderingsoapclient.util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagCellConstraints extends GridBagConstraints {

    private static final long serialVersionUID = 1L;

    public GridBagCellConstraints(int x, int y) {
        this(x, y, GridBagConstraints.NONE, GridBagConstraints.NONE);
    }

    public GridBagCellConstraints(int x, int y, int anchor) {
        this(x, y, anchor, GridBagConstraints.NONE);
    }

    public GridBagCellConstraints(int x, int y, int anchor, int fill) {
        this(x, y, anchor, fill, GridBagInsets.ZERO);
    }

    public GridBagCellConstraints(int x, int y, int anchor, int fill, int insetSize) {
        this(x, y, anchor, fill, new GridBagInsets(insetSize));
    }

    public GridBagCellConstraints(int x, int y, int anchor, int fill, Insets insets) {
        this(x, y, anchor, fill, insets, 0);
    }

    public GridBagCellConstraints(int x, int y, int anchor, int fill, Insets insets, double weight) {
        super(x, y, 1, 1, weight, weight, anchor, fill, insets, 0, 0);
    }

    public GridBagCellConstraints setWeight(double w) {
        if (w > 1) {
            w = 1;
        }
        if (w < 0) {
            w = 0;
        }
        weightx = w;
        weighty = w;

        return (this);
    }

    public GridBagCellConstraints anchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    public GridBagCellConstraints weight(double w) {
        return this.setWeight(w);
    }

    public GridBagCellConstraints gridx(int x) {
        this.gridx = x;
        return this;
    }

    public GridBagCellConstraints grid(int x, int y) {
        this.gridx = x;
        this.gridy = y;
        return this;
    }

    public GridBagCellConstraints gridy(int y) {
        this.gridy = y;
        return this;
    }

    public GridBagCellConstraints width(int w) {
        return gridwidth(w);
    }

    public GridBagCellConstraints height(int h) {
        return gridheight(h);
    }

    public GridBagCellConstraints gridwidth(int w) {
        this.gridwidth = w;
        return this;
    }

    public GridBagCellConstraints gridheight(int h) {
        this.gridheight = h;
        return this;
    }

    public GridBagCellConstraints x(int x) {
        return gridx(x);
    }

    public GridBagCellConstraints y(int y) {
        return gridy(y);
    }

    public GridBagCellConstraints xy(int x, int y) {
        return x(x).y(y);
    }

    public GridBagCellConstraints fill(int f) {
        this.fill = f;
        return this;
    }

    public GridBagCellConstraints ipad(int p) {
        this.ipadx = p;
        this.ipady = p;
        return this;
    }

    public GridBagCellConstraints setInsetSize(int s) {
        insets = new Insets(s, s, s, s);
        return (this);
    }

    public GridBagCellConstraints inset(int s) {
        return this.setInsetSize(s);
    }

    public GridBagCellConstraints insets(Insets insets) {
        this.insets = insets;
        return this;
    }

    public GridBagCellConstraints setPadding(int x, int y) {
        this.ipadx = x;
        this.ipady = y;

        return this;
    }

    public GridBagCellConstraints pad(int x, int y) {
        return this.setPadding(x, y);
    }

    public GridBagCellConstraints pad(int x) {
        return this.setPadding(x, x);
    }
}

package ie.philb.testorderingsoapclient.util;

import java.awt.Insets;

public class GridBagInsets extends Insets {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Insets ZERO = new Insets(0, 0, 0, 0);
	public static Insets ONE = new Insets(1, 1, 1, 1);	
	
	public GridBagInsets() {
		this(0);
	}
	
	public GridBagInsets(int size) {
		super(size, size, size, size);
	}
}

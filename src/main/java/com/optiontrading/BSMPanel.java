/**
 * 
 */
package com.optiontrading;

import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * @author telberrak
 *
 */
public class BSMPanel extends JPanel {

	public BSMPanel() {
		super();
	}

	public BSMPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public BSMPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public BSMPanel(LayoutManager layout) {
		super(layout);
	}

}

/**
 * 
 */
package com.optiontrading.views;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import com.optiontrading.domain.Instrument;

/**
 * @author telberrak
 *
 */
public class WatchlistPanel extends JPanel {
	
	private String name;
	private List<Instrument> tickers;
	public WatchlistPanel(String name, Color color) {
		super();
		this.name = name;
		this.setBackground(color);
	}

}

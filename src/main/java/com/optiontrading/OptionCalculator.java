package com.optiontrading;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class OptionCalculator extends JFrame {
	private JTable table;

	public OptionCalculator() {

		initUI();
	}

	private void initUI() {

		setTitle("Option Trader");
		setSize(991, 661);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		BSMPanel bsmPanel = new BSMPanel();
		bsmPanel.setSize(200, 200);
		bsmPanel.setLocation(0, 20);
		bsmPanel.setBackground(Color.black);
		//getContentPane().add(bsmPanel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Dashboard");
		menuBar.setBounds(0, 0, 975, 22);
		getContentPane().add(menuBar);

		JMenu mnDashboards = new JMenu("Dashboard");
		mnDashboards.setHorizontalAlignment(SwingConstants.CENTER);
		mnDashboards.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnDashboards);

		JMenu mnTickers = new JMenu("Tickers");
		mnTickers.setHorizontalAlignment(SwingConstants.CENTER);
		mnTickers.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnTickers);
		
		JMenu mnCalculators = new JMenu("Calculators");
		mnCalculators.setHorizontalAlignment(SwingConstants.CENTER);
		mnCalculators.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnCalculators);
		
		JMenu mnBatches = new JMenu("Batches");
		mnBatches.setHorizontalAlignment(SwingConstants.CENTER);
		mnBatches.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnBatches);
		
		table = new JTable();
		table.setBounds(0, 20, this.getWidth(), this.getHeight());
		getContentPane().add(table);
	}

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(OptionCalculator.class).headless(false).run(args);

		EventQueue.invokeLater(() -> {

			var ex = ctx.getBean(OptionCalculator.class);
			ex.setVisible(true);
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

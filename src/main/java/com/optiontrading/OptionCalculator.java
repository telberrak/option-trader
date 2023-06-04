package com.optiontrading;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.optiontrading.views.BSMPanel;
import com.optiontrading.views.InstrumentPanel;
import com.optiontrading.views.WatchlistPanel;

@SpringBootApplication
public class OptionCalculator extends JFrame {
	
	private static final Logger logger = Logger.getLogger(OptionCalculator.class);
	private JTable table;
	private BSMPanel bsmPanel;
	private InstrumentPanel instrumentPanel;
	
	private OptionCalculator mainFrame;
	private JTable table_1;

	public OptionCalculator() {
		mainFrame = this;
		initUI();
		
	}

	private void initUI() {

		WatchlistPanel watchlist = new WatchlistPanel("watchlist", Color.black);
		bsmPanel = new BSMPanel();
		
		setTitle("Option Trader");
		setSize(991, 661);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		BSMPanel bsmPanel = new BSMPanel();
		bsmPanel.setBounds(100, 50, 500, 800);

		instrumentPanel = new InstrumentPanel();
		instrumentPanel.setBounds(0, 0, mainFrame.getWidth(), mainFrame.getHeight());


		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Dashboard");
		menuBar.setBounds(0, 0, 975, 22);
		getContentPane().add(menuBar);

		JMenu mnDashboards = new JMenu("Dashboard");
		mnDashboards.setHorizontalAlignment(SwingConstants.CENTER);
		mnDashboards.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnDashboards);
		
		JMenu mnWatchlists = new JMenu("Watchlists");
		mnWatchlists.setHorizontalAlignment(SwingConstants.CENTER);
		mnWatchlists.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnWatchlists);

		JMenu mnTickers = new JMenu("Instruments");
		mnTickers.setHorizontalAlignment(SwingConstants.CENTER);
		mnTickers.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnTickers);
		
		JMenuItem mntmAllInst = new JMenuItem("All");
		mntmAllInst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				logger.info("Opening List of instruments");
				mainFrame.getContentPane().add(instrumentPanel);
				bsmPanel.setVisible(false);
				instrumentPanel.setVisible(true);
			}
		});
		mntmAllInst.setHorizontalAlignment(SwingConstants.LEFT);
		mntmAllInst.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnTickers.add(mntmAllInst);
		
		JMenuItem mntmSearchhInst = new JMenuItem("Search F5");
		mntmSearchhInst.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSearchhInst.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnTickers.add(mntmSearchhInst);
		
		JMenu mnCalculators = new JMenu("Calculators");
		mnCalculators.setHorizontalAlignment(SwingConstants.CENTER);
		mnCalculators.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnCalculators);
		
		JMenuItem mntmBSM = new JMenuItem("Black Sholes Calculator");
		
		
		mntmBSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				logger.info("Opening BSM caculator");
				mainFrame.getContentPane().add(bsmPanel);
				instrumentPanel.setVisible(false);
				bsmPanel.setVisible(true);
			
			}
		});
		mnCalculators.add(mntmBSM);
		
		JMenuItem mntmOptionWheelCalculator = new JMenuItem("Option Wheel Calculator");
		mntmOptionWheelCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Make BSM caculator disapear");
				bsmPanel.setVisible(false);
			}
		});
		mnCalculators.add(mntmOptionWheelCalculator);
		
		JMenu mnBatches = new JMenu("Batches");
		mnBatches.setHorizontalAlignment(SwingConstants.CENTER);
		mnBatches.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnBatches);

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

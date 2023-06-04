/**
 * 
 */
package com.optiontrading.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.optiontrading.domain.Instrument;
import com.optiontrading.services.InstrumentService;

/**
 * @author telberrak
 *
 */
@SuppressWarnings("serial")
@Component
public class InstrumentPanel extends JPanel {

	@Autowired
	private InstrumentService instrumentService;

	String[] header = { "Id", "Ticker" };

	List<Instrument> instruments = new ArrayList<Instrument>();

	private JTable table;

	public InstrumentPanel() {

		this(new ArrayList<Instrument>());
	}

	/**
	 * 
	 * @param instruments
	 */
	public InstrumentPanel(List<Instrument> instruments) {

		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Instruments",
				TitledBorder.CENTER, TitledBorder.TOP));

		table = new JTable();
		table.setModel(new InstrmentTableModel(instrumentService.retrieveAllInstruments()));

		add(new JScrollPane(table));

	}

	/**
	 * 
	 * @author telberrak
	 *
	 */
	@SuppressWarnings("serial")
	public class InstrmentTableModel extends AbstractTableModel {
		private List<Instrument> instruments = new ArrayList();

		public InstrmentTableModel(List<Instrument> instruments) {
			this.instruments = instruments;
		}

		@Override
		public int getRowCount() {
			return instruments.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Instrument instrument = instruments.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return instrument.getId();
			case 1:
				return instrument.getTicker();

			}
			return null;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
			case 0:
				return Long.class;
			case 1:
				return String.class;

			}
			return null;
		}
	}
}

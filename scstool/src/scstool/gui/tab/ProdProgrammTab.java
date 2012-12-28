package scstool.gui.tab;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import scstool.obj.ProductionProg;

/**
 * Eingabe des Produktionsprogramms, Prognosen und Direktverkaeufe
 * 
 * @author haeff
 *
 */
public class ProdProgrammTab extends JPanel 
{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Vector<ProductionProg> programm = new Vector<ProductionProg>();
	private Vector<TableModelListener> listeners = new Vector<TableModelListener> ();
	
	public ProdProgrammTab()
	{
		init();
	}
	
	private void init()
	{
		//TODO fuer Andre: programm in Controller
		//setBackground(Color.RED);
		final Model model = new Model();
		JTable table = new JTable( model );
		programm.add(new ProductionProg(1, 2, 3, 4));
		
		model.addProdprogramm();
		JScrollPane pane = new JScrollPane(table);
		
		add(pane);
		
		
	}
	
	
	class Model implements TableModel
	{

		public void addProdprogramm()
		{
			int index = programm.size();
			
	        // Zuerst ein Event, "neue Row an der Stelle index" herstellen
	        TableModelEvent e = new TableModelEvent( this, index, index, 
	                TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT );
	        
	        // Nun das Event verschicken
	        for( int i = 0, n = listeners.size(); i<n; i++ ){
	            ((TableModelListener)listeners.get( i )).tableChanged( e );
	        }
			
		}
		
		
		@Override
		public void addTableModelListener(TableModelListener l) 
		{
			listeners.add( l );
			
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) 
		{
	        switch( columnIndex )
	        {
	            case 0: 
	            	return Integer.class;
	            case 1: 
	            	return Integer.class;
	            case 2: 
	            	return Integer.class;
	            case 3: 
	            	return Integer.class;
	            case 4: 
	            	return Integer.class; 
	            default: 
	            	return null;
		        }
		}

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public String getColumnName(int column) {
			switch(column)
			{
				case 0:
					return "Periode";	
				case 1:
					return "n";	
				case 2:
					return "n+1";				
				case 3:
					return "n+2";			
				case 4:
					return "n+3";			
				default:
					return null;
			}
			
		}

		@Override
		public int getRowCount() {
			return programm.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) 
		{
			ProductionProg prog = (ProductionProg)programm.get( rowIndex );
	        switch( columnIndex )
	        {
	            case 0: 
	            	return "11";
	            case 1: 
	            	return new Integer( prog.getN());
	            case 2: 
	            	return new Integer( prog.getN1());
	            case 3: 
	            	return new Integer( prog.getN2());
	            case 4: 
	            	return new Integer( prog.getN3());
	            default: 
	            	return null;
	        }
		}

		@Override
		public boolean isCellEditable(int arg0, int arg1) {
			return false;
		}

		@Override
		public void removeTableModelListener(TableModelListener l) 
		{
			programm.remove( l );
		}

		@Override
		public void setValueAt(Object arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class HeaderRenderer extends JLabel implements TableCellRenderer
	{
		public HeaderRenderer()
		{
			super();
			this.setHorizontalAlignment(SwingConstants.LEFT);
			setEnabled(true);
			setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Border paddingBaorder = BorderFactory.createEmptyBorder(0, 5, 0, 0);
			setHorizontalAlignment(SwingConstants.LEFT);
			setText(" "+value.toString());
			return this;
		}
		
		
	}
}

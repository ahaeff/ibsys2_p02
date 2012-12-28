package scstool.gui.tab;


import java.awt.Component;
import java.util.Vector;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import scstool.obj.ProductionProg;
import scstool.utils.Repository;

/**
 * Eingabe des Produktionsprogramms, Prognosen und Direktverkaeufe
 * 
 * @author haeff
 *
 */
public class ProdProgrammTab extends JPanel 
{
	

	private static final long serialVersionUID = 1L;

	private Vector<ProductionProg> prog;
	private Vector<TableModelListener> listeners = new Vector<TableModelListener> ();
	
	public ProdProgrammTab()
	{
		
		init();
	}
	
	private void init()
	{
		Repository repo = Repository.getInstance();
		prog = repo.getProdProg();
		
		//setBackground(Color.RED);
		final Model model = new Model();
		model.addTableModelListener(new TableListener());
		JTable table = new JTable( model );

		
		model.addProdprogramm();
		JScrollPane pane = new JScrollPane(table);
		
		add(pane);
	}
	
	
	/**
	 * @author haeff
	 *
	 * eigenes tablemodel fuer die Darstellung und Handhabung der Tabelle
	 */
	class Model implements TableModel
	{

	
		public void addProdprogramm()
		{
			int index = prog.size();
			
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
		public int getColumnCount() 
		{
			return 5;
		}

		@Override
		public String getColumnName(int column) 
		{
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
		public int getRowCount() 
		{
			return prog.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) 
		{
			ProductionProg p = (ProductionProg)prog.get( rowIndex );
	        switch( columnIndex )
	        {
	            case 0: 
	            	return "11";
	            case 1: 
	            	return new Integer( p.getN());
	            case 2: 
	            	return new Integer( p.getN1());
	            case 3: 
	            	return new Integer( p.getN2());
	            case 4: 
	            	return new Integer( p.getN3());
	            default: 
	            	return null;
	        }
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) 
		{
			switch (columnIndex) 
			{
				case 0:
					return false;
				case 1:
					return true;
				case 2:
					return true;
				case 3:
					return true;
				case 4:
					return true;
				default:
					return false;
			}
		}

		@Override
		public void removeTableModelListener(TableModelListener l) 
		{
			prog.remove( l );
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) 
		{
			ProductionProg p = prog.get(rowIndex);
			switch (columnIndex) {
			case 1:
				p.setN((Integer)aValue);
				break;
			case 2:
				p.setN1((Integer)aValue);
				break;
			case 3:
				p.setN2((Integer)aValue);
				break;
			case 4:
				p.setN3((Integer)aValue);
				break;
			}
			
			TableModelEvent event = new TableModelEvent(this, rowIndex, rowIndex,
					columnIndex, TableModelEvent.UPDATE);
			for (TableModelListener listener : listeners) {
				listener.tableChanged(event);
			}
			
		}
		
	}
	
	class HeaderRenderer extends JLabel implements TableCellRenderer
	{

		private static final long serialVersionUID = 1L;

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
			//Border paddingBaorder = BorderFactory.createEmptyBorder(0, 5, 0, 0);
			setHorizontalAlignment(SwingConstants.LEFT);
			setText(" "+value.toString());
			return this;
		}
		
		
	}
	public class TableListener implements TableModelListener 
	{

		//Bei jedem aendern einer Zelle wird dieses Element ausgeloest
		@Override
		public void tableChanged(TableModelEvent e) 
		{
			
			System.out.println("test");
		}

	}
}

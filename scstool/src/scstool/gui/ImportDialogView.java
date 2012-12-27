package scstool.gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


import scstool.utils.Dic;

public class ImportDialogView extends JFileChooser
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ImportDialogView()
	{
		 setFileFilter(new myFileFilter());
	}
	
	
	/**
	 * 
	 * Filterklasse für den "Datei oeffnen" Dialog
	 * @author haeff
	 *
	 */
	private class myFileFilter extends FileFilter
	{

		@Override
		public boolean accept(File f) {
	        return f.isDirectory() || f.getName().toLowerCase().endsWith( ".xml" );
		}

		@Override
		public String getDescription() {
			return Dic.getValue("filter.text", "xml");
		}
		
	}
	
}

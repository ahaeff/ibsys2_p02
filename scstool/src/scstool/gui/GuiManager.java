package scstool.gui;

import scstool.proc.DatabaseContentHandler;
import scstool.proc.ProcImportXml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * 
 * Hier soll das Verhalten des GUI gesteuert werden
 * 
 * @author haeff
 * 
 */
public class GuiManager {

	private MainWindow mainWindow;
	private MainMenu mainMenu;
	private static GuiManager instance;

	private ActionListener menuListener;

	private GuiManager() {

		mainWindow = new MainWindow();
		mainMenu = new MainMenu(new MenuListener());
		mainWindow.setJMenuBar(mainMenu);

		mainWindow.setVisible(true);
		// menuListener = new MenuListener();
	}

	public static GuiManager getInstance() {
		if (instance == null) {
			instance = new GuiManager();
		}
		return instance;
	}

	public JFrame getMainWindow() {
		return mainWindow;
	}

	public ActionListener getMenulistener() {
		return menuListener;
	}

	public JMenuBar getMenuBar() {
		return mainMenu;
	}

	private class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mainMenu.getMenuItem(MainMenu.MENU_EXIT)) {
				System.exit(0);
			} else if (e.getSource() == mainMenu
					.getMenuItem(MainMenu.MENU_IMPORTXML)) {
				ProcImportXml proc = new ProcImportXml();
				proc.openDialog();
			} else if (e.getSource() == mainMenu
					.getMenuItem(MainMenu.MENU_USER_INPUT)) {
				mainWindow.addContent(new TabbedPane());
				mainWindow.invalidate();
				mainWindow.validate();
			}
		}

	}

}

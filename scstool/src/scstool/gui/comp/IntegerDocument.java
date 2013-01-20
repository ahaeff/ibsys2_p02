package scstool.gui.comp;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * @author haeff
 * Filter fuer Numerische Eigabefelder
 *
 */
public class IntegerDocument extends PlainDocument {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxCharacters = 4;
	
	public IntegerDocument(int maxc) 
	{
		maxCharacters = maxc;
	}
	public void insertString(int offset, String s, AttributeSet attributeSet)
			throws BadLocationException {
		int len = getLength() + s.length();
		try {
			if(len <= maxCharacters)
			{
				Integer.parseInt(s);
				super.insertString(offset, s, attributeSet);
			}
		} 
		catch (Exception ex)
		{
			Toolkit.getDefaultToolkit().beep();
			return;
		}
		
	}
}

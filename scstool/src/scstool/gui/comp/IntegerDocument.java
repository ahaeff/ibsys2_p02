package scstool.gui.comp;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class IntegerDocument extends PlainDocument
{
   public void insertString(int offset, String s, AttributeSet attributeSet) throws BadLocationException
    {
      try{
             Integer.parseInt(s);
         }
         catch(Exception ex)   //only allow integer values
         {
            Toolkit.getDefaultToolkit().beep(); //macht ein DßT
            //System.out.println("Keine Zahl!");
            return ;
         }
      super.insertString(offset,s, attributeSet);
    }
}

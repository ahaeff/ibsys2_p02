package scstool.gui;

import java.util.Vector;

import scstool.utils.Repository;

public class StatusMessageEventMulticaster implements MessageListenerIF {

	
	private static StatusMessageEventMulticaster instance;
	protected static Vector<MessageListenerIF> listener = new Vector<MessageListenerIF>();

	public static StatusMessageEventMulticaster getInstance() {
		if (instance == null) {
			instance = new StatusMessageEventMulticaster();
		}
		return instance;
	}
	
	
    public static void remove(MessageListenerIF l) {
        listener.remove(l);
      }
    
    public  static void add(MessageListenerIF a) {
        if(! listener.contains(a))
          listener.addElement(a);
      }

	public void setStatusMessage(StatusMessageEvent e) {
		 for(int i=0; i < listener.size(); i++)
		 {
			 listener.elementAt(i).setStatusMessage(e);
		 }
		
	}

}

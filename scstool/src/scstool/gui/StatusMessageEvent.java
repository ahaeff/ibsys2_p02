package scstool.gui;

import java.util.EventObject;

public class StatusMessageEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public StatusMessageEvent(Object o, String msg) {
		super(o);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	

	
}

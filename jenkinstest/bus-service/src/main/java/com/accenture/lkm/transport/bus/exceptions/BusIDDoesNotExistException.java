package com.accenture.lkm.transport.bus.exceptions;

public class BusIDDoesNotExistException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public BusIDDoesNotExistException() {
		super("Bus ID does not exist");
	}

}

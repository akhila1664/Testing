package com.accenture.lkm.transport.bus.bean;

public class BusBean {

	private Integer busId;
	private String source;
	private String destination;
	private String busNumber;
	private String busType;
	public BusBean() {
	}

	public Integer getBusId() {
		return busId;
	}
	public String getBusNumber() {
		return busNumber;
	}

	public String getBusType() {
		return busType;
	}

	public String getDestination() {
		return destination;
	}

	public String getSource() {
		return source;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setSource(String source) {
		this.source = source;
	}

}

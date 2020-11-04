package com.accenture.lkm.transport.bus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="BUS")
@Entity
public class BusEntity {
	
	@Id
	@Column(name="BUSID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer busId;
	@Column(name="SOURCE")
	private String source;
	@Column(name="DESTINATION")
	private String destination;
	@Column(name="BUSNUMBER")
	private String busNumber;
	@Column(name="BUSTYPE")
	private String busType;
	public BusEntity() {
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

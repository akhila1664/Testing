package com.accenture.lkm.transport.bus.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.transport.bus.bean.BusBean;
import com.accenture.lkm.transport.bus.exceptions.BusIDDoesNotExistException;
import com.accenture.lkm.transport.bus.service.BusService;

@RestController
@CrossOrigin("http://localhost:4200")
public class BusController {
	
	@Autowired
	BusService service;
	
	@GetMapping(value = "/getAllBuses", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<BusBean> getAllBuses() {
		return service.getAllBuses();
	}
	
	
	@GetMapping(value = "/getBusById/{busId}") 
	public ResponseEntity<BusBean> getBusById(@PathVariable("busId") int busId) throws BusIDDoesNotExistException {
		BusBean busBean = service.getBusById(busId);
		if(busBean != null) {
			return new  ResponseEntity<BusBean>(busBean, HttpStatus.OK);
		} else {
			throw new BusIDDoesNotExistException();
		}
	}	
	
	@PostMapping(value="/addBus",consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addBus(@RequestBody BusBean busBean){
		int busId = service.addBus(busBean);
		return new ResponseEntity<String>("Bus added with busId: "+busId+" successfully!!",HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updateBus/{busId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BusBean> updateBus(@PathVariable("busId") int busId,@RequestBody BusBean busBean) throws BusIDDoesNotExistException{
		BusBean busRetrieved = service.getBusById(busId);
		if(busRetrieved  != null) {
			busRetrieved.setBusNumber(busBean.getBusNumber());
			busRetrieved.setBusType(busBean.getBusType());
			busRetrieved.setSource(busBean.getSource());
			busRetrieved.setDestination(busBean.getDestination());
			BusBean updatedBusBean = service.updateBus(busRetrieved);
			return new ResponseEntity<BusBean>(updatedBusBean,HttpStatus.OK);
		} else {
		throw new BusIDDoesNotExistException();
		}
	}
	
	
	@DeleteMapping(value="deleteBus/{busId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteBus(@PathVariable("busId") int busId) throws BusIDDoesNotExistException{
		service.deleteBus(busId);
			return new ResponseEntity<String>("Bus deleted successfully!!",HttpStatus.OK);
		}
	
}

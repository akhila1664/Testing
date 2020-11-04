package com.accenture.lkm.transport.bus.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.transport.bus.bean.BusBean;
import com.accenture.lkm.transport.bus.dao.BusDAO;
import com.accenture.lkm.transport.bus.entity.BusEntity;
import com.accenture.lkm.transport.bus.exceptions.BusIDDoesNotExistException;

@Service
public class BusService {
	@Autowired
	BusDAO dao;
	
    public Collection<BusBean> getAllBuses() {
    	Collection<BusEntity> buses =dao.findAll();
		List<BusBean> busList = new ArrayList<BusBean> ();
		for (BusEntity busEntity : buses) {
			BusBean bean=new BusBean();
			BeanUtils.copyProperties(busEntity, bean);
			busList.add(bean);
		}
		return busList;
    }
    
    public BusBean getBusById(int busId) throws BusIDDoesNotExistException{
		BusBean bean =null;
		BusEntity busEntity= dao.getOne(busId);
		if(busEntity != null){
			bean= new BusBean();
			BeanUtils.copyProperties(busEntity, bean);
		}
		return bean;
	}
	
    public int addBus(BusBean busBean) {
		BusEntity busEntity = new BusEntity();
		BeanUtils.copyProperties(busBean, busEntity);
		busEntity= dao.save(busEntity);
		 return busEntity.getBusId();
	}
    
    public BusBean updateBus(BusBean busBean) throws BusIDDoesNotExistException {
		BusBean busCopy = null;
		BusEntity busEntity = dao.getOne(busBean.getBusId());
		if (busEntity != null) {
			BeanUtils.copyProperties(busBean, busEntity);
			dao.save(busEntity);
			busCopy = new BusBean();
			BeanUtils.copyProperties(busEntity, busCopy);
		} else {
			throw new BusIDDoesNotExistException();
		}
		return busCopy;
	}
    
    public void deleteBus(int busId) throws BusIDDoesNotExistException{
    		BusEntity busEntity = dao.getOne(busId);
    	if (busEntity.getBusId() == 0) {
    		throw new BusIDDoesNotExistException();
    	}
    	dao.delete(busId);
	}
    

}

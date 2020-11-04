package com.accenture.lkm.transport.bus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.transport.bus.entity.BusEntity;

@Repository
public interface BusDAO  extends JpaRepository<BusEntity, Integer>{

}

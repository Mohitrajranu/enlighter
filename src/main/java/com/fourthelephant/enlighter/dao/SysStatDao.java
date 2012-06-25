package com.fourthelephant.enlighter.dao;

import com.fourthelephant.enlighter.model.SysStat;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class SysStatDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<SysStat> list() {
		return entityManager.createQuery("select s from SysStat s").getResultList();
	}

}

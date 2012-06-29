package com.fourthelephant.enlighter.dao;

import com.fourthelephant.enlighter.model.ServerConnection;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ServerConnectionDao {

	@PersistenceContext(unitName="localunit")
	private EntityManager entityManager;

	@Transactional
	public void save(ServerConnection serverConnection) {
		entityManager.persist(serverConnection);
	}

	@SuppressWarnings("unchecked")
	public List<ServerConnection> list() {
		return entityManager.createQuery("select t from ServerConnection t").getResultList();
	}

}

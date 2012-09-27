package com.fourthelephant.enlighter.dao;

import com.fourthelephant.enlighter.message.Sender;
import com.fourthelephant.enlighter.model.Task;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class TaskDao {

    @PersistenceContext
	private EntityManager entityManager;

    @Inject
    private Sender sender;

    @Transactional
	public void save(Task task) {
		entityManager.persist(task);
        sender.sendMail();
	}

    //TODO: cacheable should be by key
	@SuppressWarnings("unchecked")
    @Cacheable(value = "tasks")
	public List<Task> list() {
		return entityManager.createQuery("select t from Task t").getResultList();
	}

}

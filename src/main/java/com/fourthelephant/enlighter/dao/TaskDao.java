package com.fourthelephant.enlighter.dao;

import com.fourthelephant.enlighter.message.Sender;
import com.fourthelephant.enlighter.model.Task;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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

    @Inject
    PlatformTransactionManager transactionManager;

    //@Transactional
	public void save(Task task) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

		entityManager.persist(task);
        System.out.println("sending message");
        sender.sendMail();
        System.out.println("message sent");
        transactionManager.rollback(status);
        //transactionManager.commit(status);
	}

	@SuppressWarnings("unchecked")
	public List<Task> list() {
		return entityManager.createQuery("select t from Task t").getResultList();
	}

}

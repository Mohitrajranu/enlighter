package com.fourthelephant.enlighter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

/**
 * @author Vadim Bobrov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class TaskManagerTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Inject
    private TaskManager taskManager;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Before
    public void init() {
        TaskManager taskManager = (TaskManager) applicationContext.getBean("taskManagerImpl");
    }

    @Test
    @Repeat(5)
    @Timed(millis = 5000)
    @Transactional
    public void deposit() {
        assertEquals(1, 1);
    }
}
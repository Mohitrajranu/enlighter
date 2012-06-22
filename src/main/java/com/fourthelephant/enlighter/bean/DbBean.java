package com.fourthelephant.enlighter.bean;

import com.fourthelephant.enlighter.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("dbHome")
@Scope("request")
public class DbBean {

	private static final Logger logger = LoggerFactory.getLogger(DbBean.class);

	private Task task = new Task();
	private List<Task> schemas = new ArrayList<Task>();

	public List<Task> getSchemas() {
		if (schemas.size() == 0) {
            Task task1 = new Task();
            task1.setDescription("ffffffffffffffffff");
            task1.setId(3l);
			schemas.add(task1);
		}
		return schemas;
		
	}
}

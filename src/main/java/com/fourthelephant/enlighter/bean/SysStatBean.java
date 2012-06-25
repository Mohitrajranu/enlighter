package com.fourthelephant.enlighter.bean;

import com.fourthelephant.enlighter.dao.SysStatDao;
import com.fourthelephant.enlighter.model.SysStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SysStatBean {

	private static final Logger logger = LoggerFactory.getLogger(SysStatBean.class);

	@Autowired
	private SysStatDao sysStatDao;

	
	public List<SysStat> getSysStats() {
		return sysStatDao.list();
	}

}

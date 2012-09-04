package com.fourthelephant.enlighter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: Vadim Bobrov
 */
@Entity
public class AlertDescriptor {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}

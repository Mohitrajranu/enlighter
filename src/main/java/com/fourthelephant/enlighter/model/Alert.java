package com.fourthelephant.enlighter.model;

import javax.persistence.*;

/**
 * @author: Vadim Bobrov
 */
@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

/*
    adapterId number(38) not null references adapters (id) on delete cascade,
    raisedTime number(38) not null,
    canceledTime number(38) not null,

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private AlertDescriptor descriptorId;

    alertTypeId smallint not null,

    text varchar2(300) not null
*/
}

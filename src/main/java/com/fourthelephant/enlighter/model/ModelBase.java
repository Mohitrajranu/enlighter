package com.fourthelephant.enlighter.model;

import javax.persistence.*;

/**
 * @author: Vadim Bobrov
 */
@MappedSuperclass
public abstract class ModelBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

/*
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private User createdByUser;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCreated;

    @ManyToOne(fetch=FetchType.LAZY)
    private User updatedByUser;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateUpdated;
*/
}

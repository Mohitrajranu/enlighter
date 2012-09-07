package com.fourthelephant.enlighter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vadim Bobrov
 */
@Entity
@Table(name = "V$SYSSTAT")
public class SysStat {

    @Id
    @Column(name = "STATISTIC#")
    private int statNumber;

    private String name;

    @Column(name = "CLASS")
    private int statClass;

    private long value;

    @Column(name = "STAT_ID")
    private long statId;

    public int getStatNumber() {
        return statNumber;
    }

    public void setStatNumber(int statNumber) {
        this.statNumber = statNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatClass() {
        return statClass;
    }

    public void setStatClass(int statClass) {
        this.statClass = statClass;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getStatId() {
        return statId;
    }

    public void setStatId(long statId) {
        this.statId = statId;
    }
}

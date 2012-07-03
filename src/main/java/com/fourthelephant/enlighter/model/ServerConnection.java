package com.fourthelephant.enlighter.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ServerConnection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length=48)
	@NotEmpty
	@Size(max=4)
	private String name;

    @Column(length=48)
    @NotEmpty
    @Size(max=48)
    private String userName;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private OracleConnectionRole connectionRole = OracleConnectionRole.NORMAL;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private OracleConnectionType connectionType = OracleConnectionType.BASIC;

    public OracleConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(OracleConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public OracleConnectionRole getConnectionRole() {
        return connectionRole;
    }

    public void setConnectionRole(OracleConnectionRole connectionType) {
        this.connectionRole = connectionType;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

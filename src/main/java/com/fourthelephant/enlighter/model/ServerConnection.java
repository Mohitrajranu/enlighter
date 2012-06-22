package com.fourthelephant.enlighter.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class ServerConnection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length=48)
	@NotEmpty
	@Size(max=48)
	private String name;

    @Column(length=48)
    @NotEmpty
    @Size(max=48)
    private String userName;

    private OracleConnectionType connectionType = OracleConnectionType.NORMAL;



    public OracleConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(OracleConnectionType connectionType) {
        this.connectionType = connectionType;
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

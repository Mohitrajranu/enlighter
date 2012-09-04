package com.fourthelephant.enlighter.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class OracleServerConnection extends ServerConnection {

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

}

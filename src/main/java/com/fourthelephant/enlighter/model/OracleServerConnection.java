package com.fourthelephant.enlighter.model;

import javax.faces.model.SelectItem;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

    public List<SelectItem> getConnectionRoles(){
        List<SelectItem> connectionTypes = new ArrayList<SelectItem>();

        for(OracleConnectionRole type : OracleConnectionRole.values())
            connectionTypes.add(new SelectItem(type));

        return connectionTypes;
    }

    public List<SelectItem> getConnectionTypes(){
        List<SelectItem> connectionTypes = new ArrayList<SelectItem>();

        for(OracleConnectionType type : OracleConnectionType.values())
            connectionTypes.add(new SelectItem(type));

        return connectionTypes;
    }

}

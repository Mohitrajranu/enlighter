package com.fourthelephant.enlighter.model;

public enum OracleConnectionRole {

    NORMAL("normal"),
    SYSDBA("as sysdba"),
    SYSOPER("as sysoper");

    private String connectString;

    private OracleConnectionRole(String connectString) {
        this.connectString = connectString;
    }

    public String getConnectString() {
        return connectString;
    }
}

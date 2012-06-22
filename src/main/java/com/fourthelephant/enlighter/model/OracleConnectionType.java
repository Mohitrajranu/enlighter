package com.fourthelephant.enlighter.model;

public enum OracleConnectionType {

    NORMAL("normal"),
    SYSDBA("as sysdba"),
    SYSOPER("as sysoper");

    private String connectString;

    private OracleConnectionType(String connectString) {
        this.connectString = connectString;
    }

    public String getConnectString() {
        return connectString;
    }
}

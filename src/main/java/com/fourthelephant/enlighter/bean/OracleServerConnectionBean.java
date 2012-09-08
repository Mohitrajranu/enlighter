package com.fourthelephant.enlighter.bean;

import com.fourthelephant.enlighter.dao.OracleServerConnectionDao;
import com.fourthelephant.enlighter.model.OracleConnectionRole;
import com.fourthelephant.enlighter.model.OracleConnectionType;
import com.fourthelephant.enlighter.model.OracleServerConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@Component
public class OracleServerConnectionBean extends ServerConnectionBean {

	private static final Logger logger = LoggerFactory.getLogger(OracleServerConnectionBean.class);
    private OracleServerConnection oracleServerConnection = new OracleServerConnection();

    @Autowired
    private OracleServerConnectionDao serverConnectionDao;

    public OracleServerConnection getServerConnection() {
        return oracleServerConnection;
    }

    public void saveServerConnection() {
        serverConnectionDao.save(oracleServerConnection);
        oracleServerConnection = new OracleServerConnection();
        invalidateServerConnections();
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

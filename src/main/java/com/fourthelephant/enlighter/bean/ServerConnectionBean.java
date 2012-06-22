package com.fourthelephant.enlighter.bean;

import com.fourthelephant.enlighter.dao.ServerConnectionDao;
import com.fourthelephant.enlighter.model.OracleConnectionRole;
import com.fourthelephant.enlighter.model.OracleConnectionType;
import com.fourthelephant.enlighter.model.ServerConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServerConnectionBean {

	private static final Logger logger = LoggerFactory.getLogger(ServerConnectionBean.class);

	private ServerConnection serverConnection = new ServerConnection();
	private List<ServerConnection> serverConnections;

	@Autowired
	private ServerConnectionDao serverConnectionDao;

	
	public ServerConnection getServerConnection() {
		return serverConnection;
	}

	public void saveServerConnection() {
		serverConnectionDao.save(serverConnection);
		serverConnection = new ServerConnection();
		invalidateServerConnections();
	}

	private void invalidateServerConnections() {
		serverConnections = null;
	}

	public List<ServerConnection> getServerConnections() {
		if (serverConnections == null)
			serverConnections = serverConnectionDao.list();

		return serverConnections;
		
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

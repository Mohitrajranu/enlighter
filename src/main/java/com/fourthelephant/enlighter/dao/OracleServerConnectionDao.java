package com.fourthelephant.enlighter.dao;

import com.fourthelephant.enlighter.model.OracleConnectionRole;
import com.fourthelephant.enlighter.model.OracleConnectionType;
import org.springframework.stereotype.Component;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@Component
public class OracleServerConnectionDao extends ServerConnectionDao {

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

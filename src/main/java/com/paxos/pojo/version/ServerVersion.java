package com.paxos.pojo.version;

import com.paxos.enums.RoleType;
import com.paxos.enums.ValueType;
import com.paxos.pojo.Version;

/**
 * 描述:
 * 服务端的版本号 也就是Acceptor的版本号
 *
 * @author Mac
 * @create 2021-05-22 下午7:11
 */
public class ServerVersion extends Version {
    @Override
    public RoleType getRoleType() {
        return RoleType.ACCEPTOR;
    }

    public static ServerVersion origin() {
        ServerVersion version = new ServerVersion();
        version.setRnd(0);
        version.setRoleType(RoleType.ACCEPTOR);
        version.setLastRnd(-1);
        version.setValue(ValueType.NIL.getValue());
        return version;
    }

    public void update() {
        this.setLastRnd(this.getRnd());
    }
}

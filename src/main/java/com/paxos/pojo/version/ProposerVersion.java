package com.paxos.pojo.version;

import com.paxos.enums.RoleType;
import com.paxos.pojo.Version;

/**
 * 描述:
 * 客户端 也就是proposer版本号
 *
 * @author Mac
 * @create 2021-05-22 下午7:12
 */
public class ProposerVersion extends Version {
    @Override
    public RoleType getRoleType() {
        return RoleType.PROPOSER;
    }
}

package com.paxos.role.impl;

import com.paxos.exception.NullProposerException;
import com.paxos.pojo.Version;
import com.paxos.pojo.version.ProposerVersion;
import com.paxos.role.Client;
import com.paxos.role.Proposer;

/**
 * 描述:
 * 客户端实现
 *
 * @author Mac
 * @create 2021-05-22 下午7:14
 */
public class ClientImpl implements Client {
    private String value;
    @Override
    public Version transToVersion(Proposer proposer) {
        if (proposer==null){
            throw  new NullProposerException("current proposer {} is Null"+proposer);
        }
        Version version=proposer.getVersion();
        if (proposer.getVersion()==null){
            version=new ProposerVersion();
        }
        version.setLastRnd(version.getRnd());
        version.setRnd(version.getRnd()+1);
        version.setValue(value);
        return version;
    }
}

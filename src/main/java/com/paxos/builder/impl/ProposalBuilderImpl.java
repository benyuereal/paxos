package com.paxos.builder.impl;

import com.paxos.builder.ProposalBuilder;
import com.paxos.enums.PhaseType;
import com.paxos.message.request.ReadRequestMsg;
import com.paxos.pojo.Version;

import java.util.UUID;

/**
 * 描述:
 * 构造者
 *
 * @author Mac
 * @create 2021-07-15 下午9:41
 */
public class ProposalBuilderImpl implements ProposalBuilder {
    private Version version;

    public ProposalBuilderImpl(Version version) {
        this.version = version;
    }

    @Override
    public ReadRequestMsg buildReadRequestMsg() {
        ReadRequestMsg requestMsg = new ReadRequestMsg();
        requestMsg.setProposalCode(UUID.randomUUID().toString());
        requestMsg.setRnd(version.getRnd());
        requestMsg.setValue(version.getValue());
        requestMsg.setPhase(PhaseType.READ);
        return requestMsg;
    }
}

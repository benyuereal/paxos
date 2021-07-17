package com.paxos.builder.impl;

import com.paxos.builder.AcceptorBuilder;
import com.paxos.enums.PhaseType;
import com.paxos.message.request.RequestMsg;
import com.paxos.message.response.ResponseMsg;
import com.paxos.pojo.ProposalOfServer;
import com.paxos.pojo.version.ServerVersion;

/**
 * 描述:
 * 构造者实现类
 *
 * @author Mac
 * @create 2021-07-10 上午11:48
 */
public class AcceptorBuilderImpl implements AcceptorBuilder {
    private ServerVersion serverVersion;
    private RequestMsg requestMsg;

    public AcceptorBuilderImpl(ServerVersion serverVersion) {
        this.serverVersion = serverVersion;
    }

    public AcceptorBuilderImpl(RequestMsg requestMsg) {
        this.requestMsg = requestMsg;
    }

    @Override
    public ResponseMsg buildResMsg() {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setValue(serverVersion.getValue());
        responseMsg.setRnd(serverVersion.getRnd());
        responseMsg.setLastRnd(serverVersion.getLastRnd());
        responseMsg.setPhase(PhaseType.READ);
        return responseMsg;
    }

    @Override
    public ProposalOfServer buildProposal() {
        ProposalOfServer proposalOfServer=new ProposalOfServer();
        proposalOfServer.setProposalCode(requestMsg.proposalCode());
        proposalOfServer.setValue(requestMsg.getValue());
        proposalOfServer.setPhaseType(PhaseType.READ);
        proposalOfServer.setRnd(requestMsg.getRnd());
        return proposalOfServer;
    }
}

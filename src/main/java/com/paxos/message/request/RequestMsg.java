package com.paxos.message.request;

import com.paxos.enums.PhaseType;
import com.paxos.message.Message;
import com.paxos.message.MessageBody;

/**
 * 描述:
 * proposer提议案消息体
 *
 * @author Mac
 * @create 2021-05-22 下午6:36
 */
public abstract class RequestMsg extends MessageBody implements Message {
    private String proposalCode;

    public String proposalCode() {
        return this.proposalCode;
    }

    public void setProposalCode(String proposalCode) {
        this.proposalCode = proposalCode;
    }
}

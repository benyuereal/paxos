package com.paxos.builder;

import com.paxos.message.response.ResponseMsg;
import com.paxos.pojo.ProposalOfServer;

/**
 * 描述:
 * 返回响应构造者
 *
 * @author Mac
 * @create 2021-07-10 上午11:47
 */
public interface AcceptorBuilder {
    public ResponseMsg buildResMsg();

    ProposalOfServer buildProposal();
}

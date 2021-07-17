package com.paxos.builder;

import com.paxos.message.request.ReadRequestMsg;
import com.paxos.pojo.Version;

/**
 * 描述:
 * Proposal构建者
 *
 * @author Mac
 * @create 2021-07-15 下午9:40
 */
public interface ProposalBuilder {
    /**
     * 构造readRequestMsg
     * @return
     */
    public ReadRequestMsg buildReadRequestMsg();
}

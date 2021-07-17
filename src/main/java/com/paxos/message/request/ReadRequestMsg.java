package com.paxos.message.request;

import com.paxos.enums.PhaseType;

/**
 * 描述:
 * 读请求消息体
 *
 * @author Mac
 * @create 2021-05-22 下午6:47
 */
public class ReadRequestMsg extends RequestMsg {

    public ReadRequestMsg() {
    }

    @Override
    public PhaseType getPhase() {
        return PhaseType.READ;
    }


}

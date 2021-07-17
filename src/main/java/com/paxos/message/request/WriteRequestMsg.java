package com.paxos.message.request;

import com.paxos.enums.PhaseType;

/**
 * 描述:
 * 写请求消息体
 *
 * @author Mac
 * @create 2021-05-22 下午6:48
 */
public class WriteRequestMsg extends RequestMsg {
    public WriteRequestMsg() {
    }

    @Override
    public PhaseType getPhase() {
        return PhaseType.WRITE;
    }

    @Override
    public String proposalCode() {
        return null;
    }
    public static WriteRequestMsg fromRead(ReadRequestMsg readRequestMsg){
        WriteRequestMsg requestMsg=new WriteRequestMsg();
        requestMsg.setRnd(readRequestMsg.getRnd());
        requestMsg.setValue(readRequestMsg.getValue());
        requestMsg.setPhase(PhaseType.WRITE);
        return requestMsg;
    }
}

package com.paxos.message.response;

import com.paxos.enums.PhaseType;
import com.paxos.message.Message;
import com.paxos.message.MessageBody;

/**
 * 描述:
 * 写入消息体
 *
 * @author Mac
 * @create 2021-05-22 下午6:44
 */
public class ResponseMsg extends MessageBody implements Message{
    private int lastRnd;
    public int getLastRnd() {
        return lastRnd;
    }
    public void setLastRnd(int lastRnd) {
        this.lastRnd = lastRnd;
    }


    public static ResponseMsg successWrite(int rnd){
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setLastRnd(rnd);
        responseMsg.setRnd(rnd);
        return responseMsg;
    }

}

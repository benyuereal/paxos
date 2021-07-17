package com.paxos.role;

import com.paxos.enums.PhaseType;
import com.paxos.exception.IllegalReadException;
import com.paxos.message.request.RequestMsg;
import com.paxos.message.response.ResponseMsg;

/**
 * 描述:
 * 决策者
 *
 * @author Mac
 * @create 2021-05-22 下午6:34
 */
public interface Acceptor {
    public ResponseMsg read(RequestMsg requestMsg) throws IllegalReadException;
    public ResponseMsg write(RequestMsg requestMsg) throws IllegalReadException;
    public boolean synWrite(RequestMsg requestMsg);
    public boolean isWritable(RequestMsg requestMsg, PhaseType phaseType);
}

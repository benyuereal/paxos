package com.paxos.role;

import com.paxos.exception.IllegalReadException;
import com.paxos.message.request.ReadRequestMsg;
import com.paxos.message.request.WriteRequestMsg;
import com.paxos.message.response.ResponseMsg;
import com.paxos.pojo.Version;

/**
 * 描述:
 * 议案提出者
 *
 * @author Mac
 * @create 2021-05-22 下午6:34
 */
public interface Proposer {
    public ResponseMsg read(ReadRequestMsg readRequestMsg, Acceptor acceptor) throws IllegalReadException;

    public ResponseMsg write(WriteRequestMsg readRequestMsg, Acceptor acceptor) throws IllegalReadException;

    /**
     * 发起paxos进程
     * @param version
     */
    public boolean paxos(Version version) throws IllegalReadException;

    public WriteRequestMsg getWriteRequestMsg();

    public Version getVersion();
}

package com.paxos.role.impl;

import com.paxos.builder.ProposalBuilder;
import com.paxos.builder.impl.ProposalBuilderImpl;
import com.paxos.enums.PhaseType;
import com.paxos.exception.IllegalReadException;
import com.paxos.message.request.ReadRequestMsg;
import com.paxos.message.request.WriteRequestMsg;
import com.paxos.message.response.ResponseMsg;
import com.paxos.pojo.Version;
import com.paxos.role.Acceptor;
import com.paxos.role.Client;
import com.paxos.role.Proposer;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 描述:
 * Proposer实现 集群中仅有一个proposer 所有的client请求都需要经过proposer来向
 * acceptor传递信息
 *
 * @author Mac
 * @create 2021-05-22 下午7:06
 */
public class ProposerImpl implements Proposer {
    private Client client;
    private Version version;
    private List<Acceptor> activeAcceptorList;


    public ProposerImpl(Client client) {
        this.client = client;
        this.version = client.transToVersion(this);
    }

    @Override
    public ResponseMsg read(ReadRequestMsg readRequestMsg, Acceptor acceptor) throws IllegalReadException {
        return acceptor.read(readRequestMsg);
    }

    @Override
    public ResponseMsg write(WriteRequestMsg writeRequestMsg, Acceptor acceptor) throws IllegalReadException {
        return acceptor.write(writeRequestMsg);
    }

    @Override
    public boolean paxos(Version version) throws IllegalReadException {
        ProposalBuilder proposalBuilder = new ProposalBuilderImpl(version);
        ReadRequestMsg readRequestMsg = proposalBuilder.buildReadRequestMsg();
        boolean activeReadFun = this.activeReadList(readRequestMsg);
        if (activeReadFun) {
            //过滤出可以进行写入的acceptor节点
            List<Acceptor> writableList = this.activeAcceptorList.stream().
                    filter(s -> s.isWritable(readRequestMsg,PhaseType.READ))
                    .collect(Collectors.toList());
            //均写入成功就返回

            return activeWriteList(WriteRequestMsg.fromRead(readRequestMsg), writableList);

        } else {
            //不足半数进行返回
            return false;
        }

    }

    private boolean activeWriteList(WriteRequestMsg requestMsg, List<Acceptor> acceptorList) throws IllegalReadException {
        int c = 0;
        for (Acceptor acceptor : acceptorList) {
            ResponseMsg responseMsg = acceptor.write(requestMsg);
            if (responseMsg.getRnd() == responseMsg.getRnd()) {
                c++;
            }
        }
        return c >= activeAcceptorList.size();

    }

    private boolean activeReadList(ReadRequestMsg readRequestMsg) {
        int c = 0;
        for (Acceptor acceptor : activeAcceptorList) {
            try {
                boolean readFun = this.readOfUpdate(readRequestMsg, acceptor);
                if (readFun) {
                    c++;
                }
            } catch (IllegalReadException e) {
                //更新read信息 todo1
                e.printStackTrace();
            }
        }
        return c >>> 1 > activeAcceptorList.size();
    }

    private boolean readOfUpdate(ReadRequestMsg readRequestMsg, Acceptor acceptor) throws IllegalReadException {
        int count = 3;
        int rnd = -1;
        while (count > 0 && (rnd = this.read(readRequestMsg, acceptor).getRnd()) >= readRequestMsg.getRnd()) {
            count--;
            this.updateRequestMsg(readRequestMsg);
        }
        return rnd >= readRequestMsg.getRnd();
    }

    private void updateRequestMsg(ReadRequestMsg readRequestMsg) {
        readRequestMsg.setRnd(readRequestMsg.getRnd() + 1);
    }


    @Override
    public WriteRequestMsg getWriteRequestMsg() {
        return null;
    }

    @Override
    public Version getVersion() {
        return version;
    }


}

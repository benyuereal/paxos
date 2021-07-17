package com.paxos.role.impl;

import com.paxos.builder.AcceptorBuilder;
import com.paxos.builder.impl.AcceptorBuilderImpl;
import com.paxos.enums.PhaseType;
import com.paxos.exception.IllegalReadException;
import com.paxos.message.request.RequestMsg;
import com.paxos.message.response.ResponseMsg;
import com.paxos.pojo.ProposalOfServer;
import com.paxos.pojo.version.ServerVersion;
import com.paxos.role.Acceptor;

/**
 * 描述:
 * Acceptor实现类
 * 有三个组成部分：当前版本、读取版本proposal、写入poposal
 *
 * @author Mac
 * @create 2021-07-10 上午11:41
 */
public class AcceptorImpl implements Acceptor {
    private ServerVersion version;
    private ProposalOfServer proposalOfServer;

    public AcceptorImpl() {
        //如果为空创建一个默认的version
        version = ServerVersion.origin();
        proposalOfServer = new ProposalOfServer();
    }

    public ServerVersion getVersion() {

        return version;
    }

    @Override
    public ResponseMsg read(RequestMsg requestMsg) throws IllegalReadException {
        if (!requestMsg.getPhase().equals(PhaseType.READ)) {
            throw new IllegalReadException("current request should be PhaseType of Read");
        }
        //写入值
        this.synProposalVersion(requestMsg);
        ServerVersion version = this.getVersion();
        AcceptorBuilder acceptorBuilder = new AcceptorBuilderImpl(version);
        return acceptorBuilder.buildResMsg();
    }

    private void synProposalVersion(RequestMsg requestMsg) {
        //读取随意 可以替换
        AcceptorBuilder acceptorBuilder = new AcceptorBuilderImpl(requestMsg);
        proposalOfServer.replaceOf(acceptorBuilder.buildProposal());
    }

    @Override
    public ResponseMsg write(RequestMsg requestMsg) throws IllegalReadException {
        if (!requestMsg.getPhase().equals(PhaseType.WRITE)) {
            throw new IllegalReadException("current request should be PhaseType of Read");
        }
        //判断是否是写入的值 如果是判定可以写入 那么就进行写入 并将rnd+1
        if (isSerailWritable(requestMsg)) {
            ServerVersion version = this.getVersion();
            version.update();
            //proposal更新为可读阶段
            ProposalOfServer proposalOfServer = this.proposalOfServer;
            proposalOfServer.update();
            /**
             * 返回结果
             */
            return ResponseMsg.successWrite(requestMsg.getRnd());

        }
        return null;
    }

    @Override
    public boolean synWrite(RequestMsg requestMsg) {
        return false;
    }

    /**
     * 如果round==acceptor的rnd 并且是出于读的阶段 就可以写入
     *
     * @param requestMsg
     * @return
     */
    @Override
    public boolean isWritable(RequestMsg requestMsg, PhaseType phaseType) {
        ProposalOfServer proposalOfServer = this.proposalOfServer;
        return proposalOfServer.getPhaseType().equals(phaseType) &&
                proposalOfServer.getRnd() == requestMsg.getRnd();
    }

    private boolean isSerailWritable(RequestMsg requestMsg) {
        return isWritable(requestMsg, PhaseType.WRITE) &&
                (requestMsg.proposalCode().equals(this.proposalOfServer.getProposalCode()))
                ;

    }
}

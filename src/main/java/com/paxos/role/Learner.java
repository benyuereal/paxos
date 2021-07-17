package com.paxos.role;

import java.util.List;

/**
 * 描述:
 * 学习者
 *
 * @author Mac
 * @create 2021-05-22 下午6:35
 */
public abstract class Learner implements Proposer{
    private Proposer proposer;
    public Learner(Proposer proposer){
        this.proposer=proposer;
    }

    /**
     * 对
     * @param acceptorList
     */
    public  void broadcast(List<Acceptor> acceptorList){
        for (int i = 0; i < acceptorList.size(); i++) {
            Acceptor acceptor=acceptorList.get(i);
            if (acceptor!=null&&acceptor.synWrite(proposer.getWriteRequestMsg())){

            }
        }
    }
}

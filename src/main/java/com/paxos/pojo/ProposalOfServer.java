package com.paxos.pojo;

import com.paxos.enums.PhaseType;

import java.util.Timer;

/**
 * 描述:
 * Proposal版本
 *
 * @author Mac
 * @create 2021-07-10 下午12:02
 */
public class ProposalOfServer {
    /**
     * 当前的phaseType 是读取阶段还是写入阶段
     */
    private PhaseType phaseType;
    /**
     * value值
     */
    private String value;
    /**
     * proposal编码
     */
    private String proposalCode;
    /**
     * rnd
     */
    private int rnd;



    public PhaseType getPhaseType() {
        return phaseType;
    }

    public void setPhaseType(PhaseType phaseType) {
        this.phaseType = phaseType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getProposalCode() {
        return proposalCode;
    }

    public void setProposalCode(String proposalCode) {
        this.proposalCode = proposalCode;
    }

    public int getRnd() {
        return rnd;
    }

    public void setRnd(int rnd) {
        this.rnd = rnd;
    }

    public void replaceOf(ProposalOfServer buildProposal) {
        this.setValue(buildProposal.getValue());
        this.setProposalCode(buildProposal.getProposalCode());
        this.setPhaseType(buildProposal.getPhaseType());
        this.setRnd(buildProposal.getRnd());
    }

    public void update() {
        this.setPhaseType(PhaseType.READ);
    }
}

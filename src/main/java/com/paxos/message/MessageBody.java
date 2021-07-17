package com.paxos.message;

import com.paxos.enums.PhaseType;

/**
 * 描述:
 * 基础消息体
 *
 * @author Mac
 * @create 2021-05-22 下午6:52
 */
public abstract class MessageBody{
    private int rnd;
    private String value;
    private PhaseType phase;
    public PhaseType getPhase() {
        return phase;
    }
    public void setPhase(PhaseType phase) {
        this.phase = phase;
    }
    public int getRnd() {
        return rnd;
    }

    public void setRnd(int rnd) {
        this.rnd = rnd;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

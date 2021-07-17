package com.paxos.pojo;

/**
 * 描述:
 * 回合
 *
 * @author Mac
 * @create 2021-05-22 下午7:08
 */
public abstract class Round {
    private int rnd;
    private int lastRnd;
    public int getRnd() {
        return rnd;
    }

    public void setRnd(int rnd) {
        this.rnd = rnd;
    }

    public int getLastRnd() {
        return lastRnd;
    }

    public void setLastRnd(int lastRnd) {
        this.lastRnd = lastRnd;
    }


}

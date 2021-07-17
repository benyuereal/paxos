package com.paxos.exception;

/**
 * 描述:
 * 空proposer异常
 *
 * @author Mac
 * @create 2021-05-22 下午7:15
 */
public class NullProposerException extends  NullPointerException{
    public NullProposerException(String message){
        super(message);
    }
}

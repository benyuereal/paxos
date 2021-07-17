package com.paxos.exception;

/**
 * 描述:
 * 非法读取异常
 *
 * @author Mac
 * @create 2021-07-10 上午11:59
 */
public class IllegalReadException extends Exception {
    public IllegalReadException(String msg) {
        super(msg);
    }
}

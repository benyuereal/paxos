package com.paxos.enums;

/**
 * 描述:
 * 服务端存储的值
 *
 * @author Mac
 * @create 2021-07-10 上午11:44
 */
public enum ValueType {
    NIL("nil");
    private String value;

    private ValueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

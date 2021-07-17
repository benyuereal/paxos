package com.paxos.pojo;

import com.paxos.enums.RoleType;

/**
 * 描述:
 * 版本
 *
 * @author Mac
 * @create 2021-05-22 下午7:09
 */
public class Version extends Round{
    private RoleType roleType;
    private String value;
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

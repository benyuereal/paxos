package com.paxos.role;

import com.paxos.pojo.Version;

/**
 * 描述:
 * 客户端
 *
 * @author Mac
 * @create 2021-05-22 下午6:35
 */
public interface Client {
    public Version transToVersion(Proposer proposer);
}

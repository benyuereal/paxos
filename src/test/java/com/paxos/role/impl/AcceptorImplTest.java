package com.paxos.role.impl;


import com.paxos.pojo.version.ServerVersion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * 描述:
 *
 * @author Mac
 * @create 2021-07-17 下午11:40
 */
@RunWith(JUnit4.class)
class AcceptorImplTest {

    private AcceptorImpl acceptor;

    @Before
    public void before() {
        acceptor = new AcceptorImpl();
    }

    @Test
    void getVersion() {
        ServerVersion serverVersion = acceptor.getVersion();
        Assert.assertNotNull(serverVersion);
        assertEquals(serverVersion.getValue(), "");
    }

    @Test
    void read() {
    }

    @Test
    void write() {
    }

    @Test
    void synWrite() {
    }

    @Test
    void isWritable() {
    }
}
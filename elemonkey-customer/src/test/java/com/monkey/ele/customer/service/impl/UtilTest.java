package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.util.DateFormat;
import com.monkey.ele.common.util.Md5Utils;
import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void testCompareTime(){
        Assert.assertTrue(DateFormat.compareOpen("11:00","3:00"));
    }


    @Test
    public void makeMD5PWD(){
        System.out.println(Md5Utils.md5Password("123456"));
    }
}

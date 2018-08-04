package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.util.DateFormat;
import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void testCompareTime(){
        Assert.assertTrue(DateFormat.compareOpen("11:00","3:00"));
    }
}

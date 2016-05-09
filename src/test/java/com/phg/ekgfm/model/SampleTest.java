package com.phg.ekgfm.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by milesporter on 4/25/16.
 * A set of tests to validate how samples will work.
 */

public class SampleTest {

    @Test
    public void testSayHello() {
        Assert.assertEquals(true,true);
    }

    @Test
    public void testCreateSample() {
        Sample sample = new Sample(20,150);
        Assert.assertEquals(sample.getTime(), 20);
        Assert.assertEquals(sample.getVal(), 150);
    }


}

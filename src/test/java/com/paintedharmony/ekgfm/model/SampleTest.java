package com.paintedharmony.ekgfm.model;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;
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
        Sample sample = new Sample(1,150,20);
        Assert.assertEquals(sample.getSeq(), 1);
        Assert.assertEquals(sample.getVal(), 150);
        Assert.assertEquals(sample.getDeltaT(), 20);

    }


}

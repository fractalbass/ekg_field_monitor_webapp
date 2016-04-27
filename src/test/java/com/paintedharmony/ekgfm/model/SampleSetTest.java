package com.paintedharmony.ekgfm.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by milesporter on 4/25/16.
 */
public class SampleSetTest {

    @Test
    public void testBulkSampleSet() {
        SampleSet sSet = genSampleSet(100);
        Assert.assertTrue(sSet.samples.size()==100);
    }

    @Test
    public void testSampleSet() {
        Sample s1 = new Sample(20,100);
        Sample s2 = new Sample(10,200);
        Sample s3 = new Sample(15,10);
        ArrayList<Sample> sArray = new ArrayList<>();
        sArray.add(s1);
        sArray.add(s2);
        sArray.add(s3);
        SampleSet sSet = new SampleSet(sArray);
        Assert.assertEquals(sSet.getSize(), 3);
        Assert.assertEquals(sSet.getMaxSampleValue(), 200);
        Assert.assertEquals(sSet.getMinSampleValue(), 10);
        SampleSet orderedSamples = sSet.getOrderedSampleSet();

        orderedSamples.samples.forEach((s) -> {
            s.print();
        });

        Assert.assertTrue(orderedSamples.getSample(0).equals(s2));
        Assert.assertTrue(orderedSamples.getSample(1).equals(s3));
        Assert.assertTrue(orderedSamples.getSample(2).equals(s1));

    }

    private SampleSet genSampleSet(int samples) {
        SampleSet sSet = new SampleSet();
        for (int i=0;i<samples;i++) {
            Sample s = new Sample(i*10,
                                    (int)(Math.random()*250));
            sSet.samples.add(s);
        }
        return sSet;
    }
}

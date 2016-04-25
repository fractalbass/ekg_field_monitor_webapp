package com.paintedharmony.ekgfm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by milesporter on 4/24/16.
 */
public class SampleSet {

    ArrayList<Sample> samples;
    int minSampleValue = 0;
    int maxSampleValue = 0;

    public SampleSet() {
        samples = new ArrayList<>();
    }

    public SampleSet(ArrayList<Sample> samples) {
        this.samples = samples;
        for(Sample s : samples) {
           checkSample(s);
        }
    }

    public void add(Sample s) {
        samples.add(s);
        checkSample(s);
    }


    public int getSize() {
        return samples.size();
    }

    public int getMaxSampleValue() {
        return maxSampleValue;
    }

    public int getMinSampleValue() {
        return minSampleValue;
    }

    public Sample getSample(int i) {
        return samples.get(i);
    }

    private void checkSample(Sample s) {
        if (minSampleValue==0 && maxSampleValue == 0) {
            System.out.println("=======>  First Sample!");
            minSampleValue = s.getVal();
            maxSampleValue = s.getVal();
        }
        else {
            int v = s.getVal();
            if (v < minSampleValue) minSampleValue = s.getVal();
            if (v > maxSampleValue) maxSampleValue = s.getVal();
        }
    }


    public SampleSet getOrderedSampleSet() {
        ArrayList orderedSamples = samples;
        Collections.sort(orderedSamples, new Comparator<Sample>() {
            @Override public int compare(Sample s1, Sample s2) {
            return s1.getSeq() - s2.getSeq(); // Ascending
            }
        });
        return new SampleSet(orderedSamples);
    }
}


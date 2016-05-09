package com.phg.ekgfm.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by milesporter on 4/24/16.
 */
@Component
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
            return s1.getTime() - s2.getTime(); // Ascending
            }
        });
        return new SampleSet(orderedSamples);
    }
}


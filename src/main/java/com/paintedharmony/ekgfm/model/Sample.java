package com.paintedharmony.ekgfm.model;

/**
 * Created by milesporter on 4/25/16.
 */
public class Sample {

    private int seq;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getDeltaT() {
        return deltaT;
    }

    public void setDeltaT(int deltaT) {
        this.deltaT = deltaT;
    }

    private int val;

    private int deltaT;

    public Sample(){};

    public Sample(int seq, int val, int deltaT) {
        this.seq = seq;
        this.val = val;
        this.deltaT = deltaT;
    }

    public boolean equals(Sample inSample) {
        return ((inSample.getSeq() == this.getSeq()) &&
                (inSample.getVal() == this.getVal()) &&
                (inSample.getDeltaT() == this.getDeltaT()));
    }


}

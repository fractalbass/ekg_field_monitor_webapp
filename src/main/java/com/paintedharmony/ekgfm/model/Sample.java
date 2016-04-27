package com.paintedharmony.ekgfm.model;

/**
 * Created by milesporter on 4/25/16.
 */
public class Sample {


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private int val;

    private int time;

    public Sample(){};

    public Sample(int time, int val) {
        this.val = val;
        this.time = time;
    }

    public boolean equals(Sample inSample) {
       return ((inSample.getTime() == this.getTime()) &&
                (inSample.getVal() == this.getVal()));
    }

    public void print() {
        System.out.println("----------------------------");
        System.out.println("Time  . . . " + time);
        System.out.println("Value . . . " + val);
        System.out.println("----------------------------");
    }


}

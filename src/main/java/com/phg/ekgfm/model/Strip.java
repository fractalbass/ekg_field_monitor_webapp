package com.phg.ekgfm.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by milesporter on 4/24/16.
 */
@Component
public class Strip {

    public void Strip() {
        ID = UUID.randomUUID();
    }

    public static Strip generate() {
        Strip s = new Strip();
        UUID id = UUID.randomUUID();
        s.setID(id);
        return s;
    }

    private UUID ID;

    private Date uploaded;

    public ArrayList<SampleSet> getSampleSet() {
        return sampleSets;
    }

    public void setSampleSets(ArrayList<SampleSet> sampleSets) {
        this.sampleSets = sampleSets;
    }

    public void addSampleSet(SampleSet sampleSet) {
        if (sampleSets==null) {
            sampleSets = new ArrayList<>();
        }
        this.sampleSets.add(sampleSet);
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    private ArrayList<SampleSet> sampleSets;


}

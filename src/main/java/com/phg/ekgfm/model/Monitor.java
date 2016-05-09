package com.phg.ekgfm.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by milesporter on 4/24/16.
 */
@Component
public class Monitor {

    public Monitor() {
    }

    public static Monitor generateMonitor() {
        Monitor m = new Monitor();
        m.id = UUID.randomUUID();
        return m;
    }

    private UUID id;

    public ArrayList<Strip> getStrips() {
        return strips;
    }

    public void setStrips(ArrayList<Strip> strips) {
        this.strips = strips;
    }

    public UUID getID() {
        return id;
    }

    public void setID(UUID id) {
        this.id = id;
    }

    private ArrayList<Strip> strips;

    public boolean equals(Monitor m) {
        //  This is a pretty high level check.  We will
        //  likely want to add a deeper check for equals
        //  later.
        return (m.getID().toString().equals(id.toString()));
    }

}

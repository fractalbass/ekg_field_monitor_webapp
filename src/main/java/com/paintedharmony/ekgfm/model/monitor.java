package com.paintedharmony.ekgfm.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by milesporter on 4/24/16.
 */
public class Monitor {

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

}

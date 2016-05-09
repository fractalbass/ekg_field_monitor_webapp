package com.phg.ekgfm.dao;

import com.phg.ekgfm.model.Strip;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Created by milesporter on 4/27/16.
 */
@Component
public class StripDao {

    public List<Strip> getStrips(UUID monitorId) {
        return null;
    }

    public void saveStrip(UUID monitorId, Strip s) {
        //  Write the strip to the database.
    }
}

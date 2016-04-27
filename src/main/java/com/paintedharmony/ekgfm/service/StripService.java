package com.paintedharmony.ekgfm.service;

import com.paintedharmony.ekgfm.dao.SampleSetDAO;
import com.paintedharmony.ekgfm.dao.StripDao;
import com.paintedharmony.ekgfm.model.Monitor;
import com.paintedharmony.ekgfm.model.SampleSet;
import com.paintedharmony.ekgfm.model.Strip;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by milesporter on 4/27/16.
 */
public class StripService {

    @Autowired
    StripDao stripDao;

    public List<Strip> getStrips(Monitor monitor) {
        return stripDao.getStrips(monitor.getID());
    }

    public void AddStrip(Monitor monitor, Strip strip) {
        //  Do stuff;
    }
}

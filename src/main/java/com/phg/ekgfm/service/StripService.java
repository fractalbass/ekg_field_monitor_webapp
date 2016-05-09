package com.phg.ekgfm.service;

import com.phg.ekgfm.dao.StripDao;
import com.phg.ekgfm.model.Monitor;
import com.phg.ekgfm.model.Strip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milesporter on 4/27/16.
 */
@Component
public class StripService {

    @Autowired
    StripDao stripDao;

    public List<Strip> getStrips(Monitor monitor) {
        return stripDao.getStrips(monitor.getID());
    }

    public Strip createStrip(Monitor monitor) {
        Strip s = Strip.generate();
        return s;
    }

    public void saveStrip(Monitor m, Strip s) {
        stripDao.saveStrip(m.getID(), s);
    }
}

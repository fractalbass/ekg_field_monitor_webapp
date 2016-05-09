package com.phg.ekgfm.service;

import com.phg.ekgfm.dao.MonitorDAO;
import com.phg.ekgfm.model.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by milesporter on 5/9/16.
 */
@Component
public class MonitorService {

    @Autowired
    MonitorDAO monitorDao;

    public Monitor createMonitor() {
        return monitorDao.createMonitor();
    }

    public Monitor getMonitor(UUID monitorId) {
        return monitorDao.getMonitor(monitorId);
    }
}

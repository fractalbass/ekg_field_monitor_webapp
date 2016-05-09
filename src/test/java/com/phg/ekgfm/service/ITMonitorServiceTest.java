package com.phg.ekgfm.service;

import com.phg.ekgfm.EKGFMApplication;
import com.phg.ekgfm.model.Monitor;
import com.phg.ekgfm.model.Strip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by milesporter on 5/2/16.
 * <p>
 * An initial test for creating a monitor using the monitor service.  Note
 * that this is an integration test and will communicate with the backend
 * database.
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EKGFMApplication.class)
@WebAppConfiguration
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:createDatabase.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:dropDatabase.sql")
public class ITMonitorServiceTest {

    @Autowired
    MonitorService monitorService;

    @Test
    public void testITMonitorService() {
        Monitor m = monitorService.createMonitor();
        Monitor m1 = monitorService.getMonitor(m.getID());
        assertTrue(m.equals(m1));
    }

}
package com.phg.ekgfm.service;

import com.phg.ekgfm.EKGFMApplication;
import com.phg.ekgfm.model.Monitor;
import com.phg.ekgfm.model.Strip;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.UUID;

/**
 * Created by milesporter on 5/2/16.
 *
 * Note:  The following comment was from http://stackoverflow.com/questions/29815636/and-in-java-comments
 * The Maven build lifecycle now includes the "integration-test" phase for running integration tests, which are run
 * separately from the unit tests run during the "test" phase. It runs after "package", so if you run "mvn verify",
 * "mvn install", or "mvn deploy", integration tests will be run along the way.
 *
 * By default, integration-test runs test classes named **\/IT*.java, **\/*IT.java, and **\/*ITCase.java, but this
 * can be configured.
 *
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EKGFMApplication.class)
@WebAppConfiguration
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:createDatabase.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:dropDatabase.sql")
public class ITStripServiceTest {

    @Autowired
    StripService stripService;

    @Test
    public void testITStripServiceCreate() {
        Monitor m = new Monitor();
        m.setID(UUID.randomUUID());
        Strip s = stripService.createStrip(m);
        assertNotNull(s);
    }

    @Test
    public void testItStripServiceGet() {
        Monitor m = new Monitor();
        m.setID(UUID.randomUUID());
        System.out.println("Using id ");
        List<Strip> strips = stripService.getStrips(m);
        //assertTrue(strips.size() == 5);
    }

}
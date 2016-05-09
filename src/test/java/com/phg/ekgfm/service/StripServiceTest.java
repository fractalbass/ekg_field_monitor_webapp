package com.phg.ekgfm.service;

import com.phg.ekgfm.dao.StripDao;
import com.phg.ekgfm.model.Monitor;
import com.phg.ekgfm.model.Sample;
import com.phg.ekgfm.model.SampleSet;
import com.phg.ekgfm.model.Strip;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class StripServiceTest {

    private StripDao stripDao;

    private StripService stripService = new StripService();

    @Before
    public void setup() {
        stripDao = mock(StripDao.class);
        when(stripDao.getStrips(any(UUID.class))).thenReturn(getMockStrips());
        stripService.stripDao = stripDao;
    }

    @Test
    public void testGetStrips() {
        Monitor m = new Monitor();
        m.setID(UUID.randomUUID());
        List<Strip> strips = stripService.getStrips(m);
        assertTrue(strips.size()==5);
    }

    private List<Strip> getMockStrips() {
        ArrayList<Strip> strips = new ArrayList<>();
        for (int stripCnt = 0; stripCnt<5;stripCnt++) {
            Strip s = new Strip();
            for (int sampleSetCnt = 0; sampleSetCnt < 5; sampleSetCnt++) {
                SampleSet sSet = new SampleSet();
                for (int sampleCnt = 0; sampleCnt < 100; sampleCnt++) {
                    Sample sample = new Sample(sampleCnt*20, (sampleCnt*5) % 250);
                    sSet.add(sample);

                }
                s.addSampleSet(sSet);
            }
            strips.add(s);
        }
        return strips;
    }
}

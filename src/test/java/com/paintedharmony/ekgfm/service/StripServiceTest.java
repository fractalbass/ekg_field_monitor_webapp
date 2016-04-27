package com.paintedharmony.ekgfm.service;

import com.paintedharmony.ekgfm.dao.StripDao;
import com.paintedharmony.ekgfm.model.Monitor;
import com.paintedharmony.ekgfm.model.Sample;
import com.paintedharmony.ekgfm.model.SampleSet;
import com.paintedharmony.ekgfm.model.Strip;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by milesporter on 4/27/16.
 */
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
                    sSet.add(new Sample(sampleCnt*20, (sampleCnt*5) % 250));
                }
                s.addSampleSet(sSet);
            }
            strips.add(s);
        }
        return strips;
    }
}

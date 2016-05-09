package com.phg.ekgfm.dao;

import com.phg.ekgfm.model.Sample;
import com.phg.ekgfm.model.SampleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milesporter on 4/27/16.
 */
public class SampleSetDAO {

    @Autowired
    DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;


    public SampleSet getAllSampleSets(String monitorId) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        String SQL = "select * from Sample where monitorID = ?";
        jdbcTemplateObject.update(SQL, monitorId);
        List<Sample> samples = jdbcTemplateObject.query(SQL,
                new SamplesMapper());
        SampleSet sampleSet;
        sampleSet = new SampleSet((ArrayList)samples);
        return sampleSet;
    }

    public void addSampleSet(String monitorId, SampleSet sampleSet) {
        //  Do stuff;
    }


}

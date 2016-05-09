package com.phg.ekgfm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.phg.ekgfm.model.Sample;
import org.springframework.jdbc.core.RowMapper;

public class SamplesMapper implements RowMapper<Sample> {
    public Sample mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sample sample = new Sample();
        sample.setTime(rs.getInt("time"));
        sample.setVal(rs.getInt("val"));
        return sample;
    }
}
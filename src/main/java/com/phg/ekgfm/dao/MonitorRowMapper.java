package com.phg.ekgfm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.phg.ekgfm.model.Monitor;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by milesporter on 5/9/16.
 */

@SuppressWarnings("rawtypes")
public class MonitorRowMapper implements RowMapper	{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Monitor monitor = new Monitor();
        monitor.setID(UUID.fromString(rs.getString("UUID")));
        return monitor;
    }
}

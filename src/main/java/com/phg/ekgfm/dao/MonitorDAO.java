package com.phg.ekgfm.dao;

import com.phg.ekgfm.model.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * Created by milesporter on 4/27/16.
 */
@Component
public class MonitorDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbcTemplate;

    public Monitor getMonitors() {
       return null;
    }

    public Monitor createMonitor() {
        Monitor m = Monitor.generateMonitor();
        String SQL = "insert into monitor (UUID) values (?);";

        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(SQL, new Object[] {m.getID()});
        return m;
    }

    @SuppressWarnings({ "unchecked" })
    public Monitor getMonitor(UUID monitorId){
        String sql = "SELECT ID, UUID FROM MONITOR WHERE UUID = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Monitor monitor = (Monitor) jdbcTemplate.queryForObject(
                sql, new Object[] { monitorId.toString() }, new MonitorRowMapper());
        return monitor;

    }

}

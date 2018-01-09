package com.mvc.common.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class JdbcDriverUnregisteringListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        deregisterDrivers(getDrivers());
    }

    /**
     * Retrieves an Enumeration with all of the currently loaded JDBC drivers.
     *
     * @return the list of JDBC Drivers
     */
    Enumeration<Driver> getDrivers() {
        return DriverManager.getDrivers();
    }

    /**
     * Unregistering JDBC drivers given as param.
     *
     * @param drivers {@link Enumeration} of {@link Driver} to unregister
     */
    void deregisterDrivers(Enumeration<Driver> drivers) {
        while (drivers.hasMoreElements()) {
            deregisterDriver(drivers.nextElement());
        }
    }

    /**
     * Unregistering single JDBC driver given as param.
     *
     * @param driver to unregister
     */
    void deregisterDriver(Driver driver) {
        try {
            DriverManager.deregisterDriver(driver);
//            logger.info("Deregistering JDBC driver: {}", driver);
        } catch (SQLException e) {
//            logger.warn("Error deregistering JDBC driver: {}. Root cause: ", driver, e);
        }
    }
}

package com.appfx.vlad.dao.dbLogic;

import org.apache.log4j.Logger;

import java.sql.*;

public class Util {

    private final static Logger logger = Logger.getLogger(Util.class);
    private final static String ORACLE_DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final static String ORACLE_DB_URL = "jdbc:oracle:thin:@localhost:1522:xe"; //1521 or 1522
    private final static String ORACLE_DB_USERNAME = "SYSTEM";
    private final static String ORACLE_DB_PASSWORD = "vladbright";

    static {
        try {
            Class.forName(ORACLE_DB_DRIVER);
            logger.info("Oracle database driver successfully loaded.");
        } catch (ClassNotFoundException e) {
            logger.error("Oracle database driver did not load.");
        }
    }

    public static Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ORACLE_DB_URL, ORACLE_DB_USERNAME, ORACLE_DB_PASSWORD);
            logger.info("Connection to database was established");
        } catch (SQLException e) {
            logger.error("Connection to database was failed");
        }
        return conn;
    }
}

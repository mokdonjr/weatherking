package com.example.weatherking.database;

import com.example.weatherking.BaseBeanTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class PostgreSQLRunnerTest extends BaseBeanTest {

    @Autowired
    private PostgreSQLRunner postgreSQLRunner;

    @Test
    public void testRunDefault() throws SQLException {
        postgreSQLRunner.runDefault();
    }

}
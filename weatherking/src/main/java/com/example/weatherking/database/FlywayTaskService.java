package com.example.weatherking.database;

import com.example.weatherking.BaseBean;
import com.example.weatherking.database.config.DatabaseConfig;
import com.example.weatherking.database.config.FlywayConfig;
import com.example.weatherking.util.LogUtil;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service(value = "flywayTaskService")
public class FlywayTaskService extends BaseBean {

    @Resource
    private FlywayTaskService flywayTaskService;

    @Autowired
    private FlywayConfig flywayConfig;

    @PostConstruct
    public void initFlywayTaskService() {
        LogUtil.runWithStopWatch("[FLYWAY_MIGRATION]", () -> {
            flywayTaskService.migrate();
        });
    }

    public void migrate() {
        Flyway flyway = Flyway.configure()
                .cleanDisabled(true)
                .installedBy("baegseungchan") // TODO : profile
                .validateOnMigrate(true)
                .baselineOnMigrate(true)
                .locations("classpath:" + flywayConfig.getScript())
                // TODO : DatabaseConfiguration
                .dataSource(flywayConfig.getUrl() + "?" + DatabaseConfig.getDefaultOption()
                        , flywayConfig.getUsername(), flywayConfig.getPassword())
                .schemas(flywayConfig.getSchema())
                .sqlMigrationPrefix(flywayConfig.getSchema() + "_v")
                .sqlMigrationSeparator("__")
                .sqlMigrationSuffixes(".sql")
                .load();
        flyway.repair();
        flyway.migrate();
    }
}

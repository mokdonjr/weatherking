package com.example.weatherking.database;

import com.example.weatherking.BaseBean;
import com.example.weatherking.util.LogUtil;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service(value = "flywayTaskService")
public class FlywayTaskService extends BaseBean {

    @Resource
    private FlywayTaskService flywayTaskService;

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
                .locations("classpath:db/migration/mysql/weatherking")
                // TODO : DatabaseConfiguration
                .dataSource("jdbc:mysql://127.0.0.1:3306?" + DatabaseConfiguration.getDefaultOption(), "seungchan", "seungchan")
                .schemas("weatherking")
                .sqlMigrationPrefix("weatherking_v")
                .sqlMigrationSeparator("__")
                .sqlMigrationSuffixes(".sql")
                .load();
        flyway.repair();
        flyway.migrate();
    }
}

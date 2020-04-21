package com.example.weatherking.database.config;

import com.example.weatherking.BaseBean;
import com.example.weatherking.util.StringUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@DependsOn("flywayTaskService")
@Configuration
public class DatabaseConfig extends BaseBean {

    @DependsOn("flywayTaskService")
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @DependsOn("flywayTaskService")
    @Bean(destroyMethod = "close")
    public DataSource dataSource(HikariConfig hikariConfig) {
        DataSource dataSource = new HikariDataSource(hikariConfig);
        System.out.println(dataSource.toString());
        return dataSource;
    }

    public static String getDefaultOption() {
        String timezone = "UTC";
        String currentTimezone = ZoneId.systemDefault().getId();
        if (currentTimezone.equals("Asia/Seoul"))
            timezone = currentTimezone;
        Map<Object, Object> param = new HashMap<>();
        param.put("useAffectedRows", true);
        param.put("characterEncoding", "UTF-8");
//        param.put("pinGlobalTxPhysicalConnection", true);
        param.put("serverTimezone", timezone);
//        param.put("useServerPrepStmts", true);
//        param.put("cachePrepStmts", true);
        param.put("prepStmtCacheSize", 250);
        param.put("prepStmtCacheSqlLimit", 2048);
        param.put("allowMultiqueries", true);
        param.put("autoReconnect", true);
        param.put("rewriteBatchedStatements", true);
        param.put("elideSetAutoCommits", true);
        param.put("useCompression", false);
        param.put("autoCommit", false);
        // 모든 쿼리 출력
        /*param.put("logger", "com.mysql.cj.log.StandardLogger");
        param.put("profileSQL", true);
        param.put("maxQuerySizeToLog", 4096);*/
        return StringUtil.getQueryString(param);
    }
}

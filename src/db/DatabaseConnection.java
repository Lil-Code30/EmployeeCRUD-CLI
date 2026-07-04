package db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseConnection {

    public static HikariDataSource datasource;

    static {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/icorp");
        config.setUsername("postgres");
        config.setPassword("azerty237");

        // pool settings
        config.setDriverClassName("org.postgresql.Driver");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setMaxLifetime(1800000);
        config.setIdleTimeout(30000);

        datasource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return datasource;
    }
}

package dev.danvega.multipleds.subscriber;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class SubscriberDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.subscribers")
    public DataSourceProperties subscribersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "subscriberDataSource")
    public DataSource dataSource(DataSourceProperties subscribersDataSourceProperties) {
        return DataSourceBuilder
                .create()
                .url(subscribersDataSourceProperties.getUrl())
                .username(subscribersDataSourceProperties.getUsername())
                .password(subscribersDataSourceProperties.getPassword())
                .build();
    }

    @Bean("subscriberDataSourceScriptDatabaseInitializer")
    DataSourceScriptDatabaseInitializer subscriberDataSourceScriptDatabaseInitializer(@Qualifier("subscriberDataSource") DataSource dataSource) {
        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:schema-h2.sql"));
        settings.setMode(DatabaseInitializationMode.EMBEDDED);
        return new DataSourceScriptDatabaseInitializer(dataSource,settings);
    }



}

package com.example.mybatis.config

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import javax.sql.DataSource
import org.springframework.jdbc.datasource.DriverManagerDataSource

@TestConfiguration
class TestConfig {
    @Bean
    PostgreSQLContainer postgreSQLContainer() {
        PostgreSQLContainer container = new PostgreSQLContainer("postgres:16-alpine")
        container.start()
        return container
    }

    @Bean
    DataSource dataSource(PostgreSQLContainer container) {
        return new DriverManagerDataSource(
            container.getJdbcUrl(),
            container.getUsername(),
            container.getPassword()
        )
    }
} 
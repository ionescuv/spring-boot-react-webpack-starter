package com.dlizarra.starter;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

	@Profile({ StarterProfiles.STANDALONE, StarterProfiles.TEST })
	@PropertySource("classpath:application-default.properties") // Not loaded by naming convention
	@Configuration
	static class StandaloneDatabaseConfig {
		@Bean
		public DataSource dataSource(final Environment env) {
			final HikariDataSource ds = new HikariDataSource();
			ds.setJdbcUrl(env.getRequiredProperty("h2.jdbcurl"));
			ds.setUsername(env.getRequiredProperty("h2.username"));
			return ds;
		}
	}

	@Profile(StarterProfiles.STAGING)
	@Configuration
	static class StagingDatabaseConfig {
		@Bean
		public DataSource dataSource(final Environment env) {
			final HikariDataSource ds = new HikariDataSource();
			ds.setJdbcUrl(env.getRequiredProperty("psql.jdbcurl"));
			ds.setUsername(env.getRequiredProperty("psql.username"));
			return ds;
		}
	}

	@Profile(StarterProfiles.PRODUCTION)
	@Configuration
	static class ProuctionDatabaseConfig {
		@Bean
		public DataSource dataSource(final Environment env) {
			final HikariDataSource ds = new HikariDataSource();
			ds.setJdbcUrl(env.getRequiredProperty("psql.jdbcurl"));
			ds.setUsername(env.getRequiredProperty("psql.username"));
			return ds;
		}
	}

    @Configuration
    @Slf4j
    static class RestTemplateConfig {
        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
            log.info("Initialised restTemplate");
            return builder.build();
        }
    }

}

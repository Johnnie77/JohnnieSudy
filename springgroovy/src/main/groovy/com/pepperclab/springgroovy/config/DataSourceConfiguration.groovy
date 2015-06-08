package com.pepperclab.springgroovy.config

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

/**
 * Created by johney on 15. 6. 5..
 */
@Configuration
class DataSourceConfiguration {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSourceBuilder builder = new DataSourceBuilder()
		builder.url("jdbc:mysql://localhost:3306/study")
		builder.username("study")
		builder.password("rhdqn")

		return builder.build()
	}
}

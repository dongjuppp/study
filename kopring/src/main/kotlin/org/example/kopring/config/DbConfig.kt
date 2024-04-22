package org.example.kopring.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.sql.DataSource

@Configuration
class DbConfig {

    @Value("\${spring.datasource.hikari.username}")
    val username: String = ""

    @Value("\${db.password}")
    val password: String = ""

    @Value("\${spring.datasource.hikari.jdbc-url}")
    val jdbcUrl: String = ""

    @Value("\${spring.datasource.hikari.driver-class-name}")
    val driverClassName: String = ""

    @Bean
    fun hikariConfig(): HikariConfig {
        val properties = Properties().apply {
            setProperty("password", password)
            setProperty("username", username)
            setProperty("jdbcUrl", jdbcUrl)
            setProperty("driverClassName", driverClassName)
        }
        return HikariConfig(properties)
    }

    @Bean
    fun dataSource(): DataSource {
        return HikariDataSource(hikariConfig())
    }
}
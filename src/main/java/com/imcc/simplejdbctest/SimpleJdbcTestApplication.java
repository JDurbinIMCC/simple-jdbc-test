package com.imcc.simplejdbctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleJdbcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleJdbcTestApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String test() {
        String sql = "select current_time::text";

        return jdbcTemplate.queryForObject(
                sql, new Object[]{}, String.class);
    }
}

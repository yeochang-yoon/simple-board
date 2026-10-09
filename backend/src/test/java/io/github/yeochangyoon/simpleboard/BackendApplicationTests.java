package io.github.yeochangyoon.simpleboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void databaseSessionUsesUtc() {
        String timeZone = jdbcTemplate.queryForObject(
                "SELECT current_setting('TimeZone')", String.class);

        assertEquals("UTC", timeZone);
    }

}

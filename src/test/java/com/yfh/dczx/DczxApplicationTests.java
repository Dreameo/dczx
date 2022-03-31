package com.yfh.dczx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DczxApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
//        Object object = jdbcTemplate.queryForObject("select count(*) from t_user", Object.class);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_user");
        System.out.println(maps);
    }

}

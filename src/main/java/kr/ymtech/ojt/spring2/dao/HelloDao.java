package kr.ymtech.ojt.spring2.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
    private JdbcTemplate jdbcTemplate;
    
    public HelloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(String name) {
        String SQL = "insert into HELLO(name) values(?)";
        jdbcTemplate.update(SQL, new Object[] { name });
    }

    public int countByName(String name) {
        String sql = "select count(*) from Hello where name=?";
        // 하나의 객체 결과값 반환
        return jdbcTemplate.queryForObject(sql, Integer.class, name);
    }
}

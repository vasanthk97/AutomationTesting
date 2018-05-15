package com.zemoso.automation.DAOs;

import com.zemoso.automation.models.Student;
import com.zemoso.automation.utils.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }
    public List<Student> findFemale() {
        return jdbcTemplate.query("select * from student where age=?",new Object[] { "female" }, new StudentRowMapper());
    }
}

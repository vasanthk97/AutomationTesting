package com.zemoso.automation.utils;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zemoso.automation.models.Student;
import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper{


        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("NAME"));
            student.setGender(rs.getString("GENDER"));
            return student;
        }

}


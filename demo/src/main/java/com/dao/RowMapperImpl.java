package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entities.Student;
public class RowMapperImpl implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet arg0, int arg1) throws SQLException {
       
        Student student = new Student();
        student.setId(arg0.getInt("id"));
        student.setName(arg0.getString("name"));
        student.setCity(arg0.getString("city"));
        return student;
    }

}

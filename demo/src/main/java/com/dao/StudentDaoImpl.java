package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.entities.Student;

public class StudentDaoImpl implements StudentDao{
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student)
    {
        String query = "INSERT INTO student(id,name,city) VALUES (?,?,?)";
        int r = this.jdbcTemplate.update(query, student.getId(),student.getName(),student.getCity());
        System.out.println(r+" row inserted!");
        return r;
    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public StudentDaoImpl() {
    }
   
    
}

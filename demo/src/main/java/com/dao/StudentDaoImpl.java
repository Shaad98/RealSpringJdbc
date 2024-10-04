package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.entities.Student;
import java.util.*;
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

    public int change(Student student)
    {
        String query = "UPDATE student SET name = ? , city = ? WHERE id = ?";
        int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        System.out.println(r+" row updated!");
        return r;
    }
    public int delete(int studentId)
    {
        String query = "DELETE FROM student WHERE id = ?";
        int r = this.jdbcTemplate.update(query, studentId);
        System.out.println(r+" row deleted!");
        return r;
    }
    public Student getStudent(int studentId)
    {
        String query = "SELECT * FROM student WHERE id = ?";
        Student student = this.jdbcTemplate.queryForObject(query, new RowMapperImpl(),studentId);
        return student;
    }
    public List<Student> getAllStudents()
    {
        String query = "SELECT * FROM student";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
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

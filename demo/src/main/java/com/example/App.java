package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;
import com.dao.StudentDao;
import com.entities.Student;

// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Hello world!
 * @author Shaad Bangi
 * @version 1.1
 * @since  2024
 */
    //Date :  3/8/2024 
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int id ,ch; 
        String name , city;
        System.out.println( "Hello World!" );
      
        // String query = "INSERT INTO student (id,name,city) VALUES (?,?,?)";

        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDaoImpl",StudentDao.class);
        Student student = new Student();

        while(true)
        {
            System.out.print("\n1.Insert\n2.Update\n3.Delete\n4.Select Single Object\n5.Select All\n6.Exit\nEnter Your Choice : ");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1->{
                    System.out.print("Enter student id : ");
                    id = sc.nextInt();
                    student.setId(id);
                    sc.nextLine();
                    System.out.print("Enter student name : ");
                    name = sc.nextLine();
                    student.setName(name);
                    System.out.print("Enter student city : ");
                    city = sc.nextLine();
                    student.setCity(city);
                    studentDao.insert(student);
                }
                case 2->{
                    System.out.print("Enter student id : ");
                    id = sc.nextInt();
                    student.setId(id);
                    sc.nextLine();
                    System.out.print("Enter new name : ");
                    name = sc.nextLine();
                    student.setName(name);
                    System.out.print("Enter new city : ");
                    city = sc.nextLine();
                    student.setCity(city);
                    studentDao.change(student);
                }
                case 3->{
                    System.out.print("Enter student id : ");
                    id = sc.nextInt();
                    studentDao.delete(id);
                }
                case 4->{
                    System.out.print("Enter id of student : ");
                    id = sc.nextInt();
                    Student st = studentDao.getStudent(id);
                    System.out.println("The student details are as follows : ");
                    System.out.println(st);
                }
                case 5->{
                    System.out.println("All students Details are as follows : ");
                    List<Student> students = studentDao.getAllStudents();
                    for (Student student2 : students) {
                        System.out.println(student2);
                    }
                }
               case 6->{
                sc.close();
                System.exit(0);
               }
            }
        }
    }
}

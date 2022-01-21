package com.myhibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, 1);
        //course.setName("New course");

        List<Student> studentList = course.getStudents();
        for (Student st : studentList)
        {
            System.out.println(st.getName());
        }
        System.out.println(course.getStudents().size());

//        Course course = new Course();
//        course.setName("Новый курс");
//        course.setTeacher(5);
//        course.setType(CourseType.BUSINESS);

        //session.save(course);

       // Course course = session.get(Course.class,1);
        //System.out.println(course.getStudents().toString());

        transaction.commit();
        sessionFactory.close();



    }
}

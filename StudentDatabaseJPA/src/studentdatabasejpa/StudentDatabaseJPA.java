/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class StudentDatabaseJPA{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student st1 = new Student(1, "John", 2.0);
       Student st2 = new Student(2, "Marry", 3.3);
       StudentTable.insertStudent(st1);
       StudentTable.insertStudent(st2);
       List<Student> empList = StudentTable.findAllStudent();
       printAllStudent(empList);
    }
    public static void printAllStudent(List<Student> studentList) {
        for(Student st : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGPA() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

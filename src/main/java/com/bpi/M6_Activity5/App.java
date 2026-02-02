package com.bpi.M6_Activity5;

import java.util.List;

import jakarta.persistence.EntityManager;


public class App {
	

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
		 
		int studentIdSearch = 1;
		int ageSearch = 30;
        try {
 
            List<String> names = findStudentNames(em);
            System.out.println("All student names:");
            names.forEach(System.out::println);
 
            //Long courseCount = countCoursesByStudentId(em, 1);
            //System.out.println("Number of courses for student with ID "+studentIdSearch+ ": " + courseCount);
 
            Long olderStudents = findStudentsByAgeGreaterThan(em, 25);
            System.out.println("Number of students older than " + ageSearch + ": "+ olderStudents);
 
 
        } finally {
            em.close();
        }
	}
    public static List<String> findStudentNames(EntityManager em) {
        return em.createQuery("SELECT s.name FROM Student s", String.class)
                 .getResultList();
    }
 
    public static Long countCoursesByStudentId(EntityManager em, int id) {
        return em.createQuery("SELECT COUNT(c) FROM Course c WHERE c.student.id = ?1", Long.class)
                 .setParameter(1, id)   
                 .getSingleResult();
    }
 
    public static Long findStudentsByAgeGreaterThan(EntityManager em, int age) {
        return em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.age > ?1", Long.class)
                 .setParameter(1, age) 
                 .getSingleResult();
    }
}

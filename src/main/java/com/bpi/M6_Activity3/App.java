package com.bpi.M6_Activity3;

import jakarta.persistence.EntityManager;


public class App {
	

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			runM6Activity3(em);
				} finally {
					EntityManagerUtil.getInstance().closeEntityManager(em);
					EntityManagerUtil.getInstance().shutdownFactory();
				}
		}
	   
	   public static void runM6Activity3(EntityManager em) {
		    try {
		        em.getTransaction().begin();

		        // Create a student
		        Student student = new Student("Jass Cruz", 24, "jass@gmail.com");
		        em.persist(student);

		        // Create courses and assign to student
		        Course pe = new Course("P.E", 95.6, student);
		        Course ap = new Course("AP", 85.9, student);

		        em.persist(pe);
		        em.persist(ap);

		        em.getTransaction().commit();
		        System.out.println("Student and courses persisted successfully!");
		    } catch (Exception e) {
		        if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        if (em.isOpen()) {
		            em.close();
		        }
		    }
		}
}

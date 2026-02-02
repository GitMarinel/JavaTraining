package com.bpi.M6_Activity2;

import jakarta.persistence.EntityManager;

public class App {
	
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
 
		try {
			runM6Activity2(em);
				} finally {
					EntityManagerUtil.getInstance().closeEntityManager(em);
					EntityManagerUtil.getInstance().shutdownFactory();
				}
		}
		
 
	static void runM6Activity2(EntityManager em) {
		
		try {
			em.getTransaction().begin();
 
			Student newStudent = new Student();
			newStudent.setName("Marinel De Leon");
			newStudent.setAge(63);
			newStudent.setEmail("Marinel@gmail.com");
 
			em.persist(newStudent);
			em.getTransaction().commit();
		} finally {
			 if (em.isOpen()) {
		            em.close();
		        }
 
		}
 
	}
}


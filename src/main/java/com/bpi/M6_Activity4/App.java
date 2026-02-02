package com.bpi.M6_Activity4;

import jakarta.persistence.EntityManager;


public class App {
	

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

		try {
			m6Activity4Solution(em);
				} finally {
					EntityManagerUtil.getInstance().closeEntityManager(em);
					EntityManagerUtil.getInstance().shutdownFactory();
				}
		}
	   
	  static void m6Activity4Solution(EntityManager em) {
	    em.getTransaction().begin();
	
	    // 1. create Student object, assign values
	    Student newStudent = new Student();
	    newStudent.setName("Lucy");
	    newStudent.setAge(33);
	    newStudent.setEmail("lucy@gmail.com");
	
	    // 2. attach transient student object to persistence context
	    em.persist(newStudent);
	
	    // 3. call flush()
	    em.flush();
	
	    // 4. detach the managed newStudent from the persistence context
	    em.detach(newStudent);
	
	    // 5. check if inside persistence context
	    System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
	
	    // 6. reattach the detached newStudent
	    newStudent = em.merge(newStudent);
	
	    // 7. update newStudent, change some values
	    newStudent.setAge(27);
	    newStudent.setEmail("lucy06@gmail.com.com");
	
	    // 8. call flush()
	    em.flush();
	
	    // 9. check again
	    System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
	
	    // 11. mark managed newStudent for deletion
	    em.remove(newStudent);
	
	    // 12. call flush()
	    em.flush();
	
	    // 13. check again
	    System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
	
	    em.getTransaction().commit();
}
}

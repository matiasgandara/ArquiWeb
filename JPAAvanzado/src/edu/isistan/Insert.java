package edu.isistan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Direccion;
import edu.isistan.dao.Persona;

	public class Insert {
		
		public static void main(String[] args) {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion d = new Direccion("Tandil","piccirilli 142");
		em.persist(d);
		Persona p = new Persona(1,"Matias",35,d);
		Persona a = new Persona(2,"Lorena",32,d);
		em.persist(p);
		em.persist(a);
		em.close();
		emf.close();
		}
}

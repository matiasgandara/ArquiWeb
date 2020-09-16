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
		Direccion d2 = new Direccion("Rauch","lolamento 142");
		Direccion d3= new Direccion("Balcarce","peperinopomoro 142");
		Direccion d4 = new Direccion("Tandil","Rodriguez 255");
		em.persist(d);
		em.persist(d2);
		em.persist(d3);
		em.persist(d4);
		Persona m = new Persona(6,"Matias",35,d);
		Persona aa = new Persona(7,"Lorena",45,d4);
		Persona pp = new Persona(3,"Pepe",54,d2);
		Persona c = new Persona(4,"Cacho",75,d3);
		em.persist(m);
		em.persist(aa);
		em.persist(pp);
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		emf.close();
		}
}

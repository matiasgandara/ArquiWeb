package torneo.servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import torneo.dao.Jugador;

public class ManagerJugador {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Jugador a = new Jugador("Matias","DeTodaLaCancha",null);
		Jugador b = new Jugador("Andres","arquero",null);
		Jugador c = new Jugador("Pep","Medio",null);
		Jugador d = new Jugador("Ken","DeTodaLaCancha",null);
	
		em.persist(a);
		em.persist(b);
		em.persist(c);
		em.persist(d);
		em.getTransaction().commit();
		em.close();
		emf.close();
		}
	
}

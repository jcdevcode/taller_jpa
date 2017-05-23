package mx.bluecode;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.bluecode.model.entities.Persona;

public class TestPersona {

	private static final Logger log = LoggerFactory.getLogger(TestPersona.class);
	
	private static EntityManager em;
	
	private static EntityManagerFactory emf;
	
	public static void main(String[] args)
	{
		emf = Persistence.createEntityManagerFactory("ApplicationPU");
		em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT o FROM Persona AS o");
		@SuppressWarnings("unchecked")
		List<Persona> personas = query.getResultList();
		log.info("Existen {} personas en la base de datos.", personas.size());
		
	}
}

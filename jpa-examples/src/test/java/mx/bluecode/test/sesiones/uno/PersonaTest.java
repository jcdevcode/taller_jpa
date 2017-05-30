package mx.bluecode.test.sesiones.uno;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.bluecode.model.entities.Persona;



/**
 * Test unitario para comprobar el acceso a datos.
 * @author Julio Cesar Bolaños Palacios
 *
 */
public class PersonaTest{

	private static final Logger log = LoggerFactory.getLogger(PersonaTest.class);
	
	private static final String PERSISTENCE_UNIT_NAME = "ApplicationPU";
	
	private static final String FIND_ALL_PERSON = "SELECT o FROM Persona AS o";
	
	/**
	 * Si tuvieramos EJB's el entity manager se injecta con:
	 * @PersistenceContext(unitName="ApplicationPU") 
	 */	
	private EntityManager em;
		
	@Before
	public void initialize(){
		log.info("Creando un entity manager para: {} ", PERSISTENCE_UNIT_NAME);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em  = emf.createEntityManager();		
		log.info("Entity Manager creado!!! \n \n");		
	}
		
	@SuppressWarnings("unchecked")
	@Test
	public void findAllPersonTest(){
		
		log.info("---- Find All Person Test ----");
		
		// Se crea un objecto query.
		Query query = em.createQuery(FIND_ALL_PERSON);
		
		// Se obtienen todos los resultados.
		List<Persona> personas = query.getResultList();
		
		Assert.assertNotNull(personas);
		log.info("La lista no es null.");
		
		Assert.assertTrue(personas.isEmpty());
		log.info("La tabla personas no contiene elementos.");	
		
	}	
	

}

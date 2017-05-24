package mx.bluecode;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.bluecode.model.entities.Persona;

/**
 * Test unitario para comprobar un crud con JPA
 * @author Julio Cesar Bolaños Palacios
 *
 */
public class CrudPersonaTest {

	private static final Logger log = LoggerFactory.getLogger(CrudPersonaTest.class);
	
	private static final String FIND_ALL_PERSON = "SELECT o FROM Persona AS o";
	
	private static final String PERSISTENCE_UNIT_NAME = "ApplicationPU";
	
	private EntityManager em;
	
	@Before
	public void initialize(){
		log.info("Creando un entity manager para: {} ", PERSISTENCE_UNIT_NAME);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em  = emf.createEntityManager();		
		log.info("Entity Manager creado!!! \n \n");		
	}
	
	
	@Test
	public void createRowTest() throws InterruptedException{
		log.info("---- Insertando un registro en la tabla: TBL_PERSONAS ----");
		Persona persona = new Persona(1L, "Pepito", "Pérez", new GregorianCalendar(1985, 4, 30).getTime());		
		em.getTransaction().begin();		
		em.persist(persona);		
		em.getTransaction().commit();
		log.info("Registro insertado !!! \n \n");
		
		imprimirPersonas();
	}
	
	@SuppressWarnings("unchecked")
	private void imprimirPersonas(){
		log.info("---- Imprimiendo el contenido de la tabla: TBL_PERSONAS -----");
		List<Persona> personas = em.createQuery(FIND_ALL_PERSON).getResultList();
		for (Persona persona : personas) {			
			log.info("Registro: {} ", persona);
		}
	}
	
}

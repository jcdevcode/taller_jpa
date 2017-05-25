package mx.bluecode;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
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
	
	
	/**
	 * Inicializa el entity manager.
	 */
	@Before
	public void initialize(){
		log.info("CREANDO EL ENTITY MANAGER PARA LA UNIDAD DE PERSISTENCIA: {} ", PERSISTENCE_UNIT_NAME);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em  = emf.createEntityManager();		
		log.info("ENTITY MANAGER CREADO. \n \n");		
	}
	
	/**
	 * Método para crear un registro y demostrar el estado de una transacción.
	 */
	public void createRow(){
		log.info("---- INSERT EN LA TABLA: TBL_PERSONAS ----");
		
		// Se crea el entity a persistir.
		Persona persona = new Persona(1L, "Pepito", "Pérez", new GregorianCalendar(1985, 4, 30).getTime());
				
		
		log.info("[ANTES] LA TRANSACCIÓN ESTA ACTIVA?: {}",  em.getTransaction().isActive());
		
		log.info("SE OBTIENE E INICIA UNA TRANSACCIÓN.");
		em.getTransaction().begin();
		
		log.info("[DURANTE] LA TRANSACCIÓN ESTA ACTIVA?: {}", em.getTransaction().isActive());
		log.info("SE PERSISTE EL ELEMENTO CON DATOS: {}", persona);
		em.persist(persona);
		persona.setApellidos("SAnchez");
			
		log.info("SE CIERRA LA TRANSACCIÓN HACIENDO COMMIT.");
		em.getTransaction().commit();
		
		log.info("[DESPUÉS] LA TRANSACCIÓN ESTA ACTIVA?: {} \n \n", em.getTransaction().isActive());				
	
	}
	
	/**
	 * Imprime todo el contenido de la tabla persona
	 */
	@SuppressWarnings("unchecked")
	public void imprimirPersonas(){
		log.info("\n\n");
		log.info("---- IMPRIMIENDO EL CONTENIDO DE LA TABLA: TBL_PERSONAS -----");
		List<Persona> personas = em.createQuery(FIND_ALL_PERSON).getResultList();
		for (Persona persona : personas) {			
			log.info("REGISTRO ENCONTRADO: {} ", persona);
		}
		log.info("------------------------ \n \n");
	}
	
	
	/**
	 * Encuentra un elemento en la tabla por id.
	 */	
	public void findRowById(){
		log.info("---- FIND ROW BY ID ----");
		Long idRegistro = 1L;
		log.info("Se va a buscar el registro con id: ", idRegistro);
		Persona row = em.find(Persona.class, idRegistro);
		log.info("Row: {}", row);
		
		Assert.assertNotNull(row);
		Assert.assertEquals(idRegistro, row.getId());
		log.info("------------------- \n \n");
	}
	
	
	
	public void checkLifeCycle(){
		log.info("---- CHECK LIFE CYCLE ENTITY ----");
			
		Persona persona = new Persona(2L, "Fulanito", "Sanchez", new GregorianCalendar(1990, 0, 17).getTime());
		log.info("[NEW / TRANSIENT] SE CREA UN OBJETO DE LA CLASE: {}", Persona.class.getName());
		log.info("[NEW / TRANSIENT] PERSONA NUEVA: {}", persona);		
		log.info("[NEW / TRANSIENT] SE VERIFICA QUE SU ESTADO SEA: NEW/TRANSIENT.");
		log.info("[NEW / TRANSIENT] ¿EL OBJETO SE ENCUENTRA EN EL CONTEXTO DE PERSISTENCIA?: {} \n \n", em.contains(persona));		
		Assert.assertFalse(em.contains(persona) == true);
			
		log.info("SE CREA UNA TRANSACCIÓN, SE PERSISTE EL OBJETO Y SE DEMUESTRA SU NUEVO ESTADO: MANAGED");
		em.getTransaction().begin();		
		log.info("[MANAGED] TRANSACCIÓN INICIADA.");
		em.persist(persona);		
		log.info("[MANAGED] SE HA PERSISTIDO EL OBJECTO. ¿EL OBJETO TIENE ESTADO MANAGED?: {}", em.contains(persona));		
		Assert.assertTrue(em.contains(persona) == true);
		
		imprimirPersonas();
		
		log.info("ANTES DE CERRAR LA TRANSACCIÓN HACEMOS UN DETACHED A LA ENTIDAD MEDIANTE EL MÉTODO em.detach()");
		em.detach(persona);
		log.info("[DETACHED] SE VERIFICA EL ESTADO DE LA ENTIDAD: ¿EL OBJETO TIENE ESTADO MANAGED?: {}", em.contains(persona));
		Assert.assertFalse(em.contains(persona) == true);
		em.getTransaction().commit();		
		log.info("SE HA CERRADO LA TRANSACCIÓN. \n \n");
				
		log.info("SE BUSCA EL REGISTRO POR ID.");
		Persona fulanito = em.find(Persona.class, 2L);
		Assert.assertNotNull(fulanito);
		log.info("[MANAGED] SE IMPRIME EL CONTENIDO DEL REGISTRO: {}", fulanito);		
		log.info("[MANAGED] AHORA LA ENTIDAD ESTA EN ESTADO ADMINISTRADO. ¿EL OBJETO TIENE ESTADO MANAGED?: {} \n \n", em.contains(fulanito));
		
		
		log.info("SE PROCEDE A REMOVER DE LA BASE DE DATOS EL REGISTRO UTILIZANDO EL MÉTODO remove(), CAMBIANDO EL ESTADO DE LA ENTIDAD A REMOVED.");
		em.getTransaction().begin();
		em.remove(fulanito);
		log.info("[REMOVED]SE VERIFICA EL ESTADO DE LA ENTIDAD: ¿EL OBJETO TIENE ESTADO MANAGED?: {}", em.contains(fulanito));
		em.getTransaction().commit();
		imprimirPersonas();
		
	}
	
	
	
	
	
	/**
	 * TEST EXECUTION
	 */
	
	/**
	 * TEST UNITARIO QUE REALIZA LA INSERCIÓN DE UN 
	 * REGISTRO EN LA BASE DE DATOS E IMPRIME EL CONTENIDO
	 * DEMOSTRANDO EL ESTADO DE UNA TRANSACCIÓN.
	 */
	@Test
	public void testA(){
		createRow();
		imprimirPersonas();
	}
	
	
	/**
	 * TEST UNITARIO QUE REALIZA LA INSERCIÓN DE UN REGISTRO
	 * EN LA BASE DE DATOS Y REALIZA LA BUSQUEDA POR ID.
	 */
	@Test
	public void testB(){
		createRow();
		findRowById();
	}
	
	/**
	 * TEST UNITARIO PARA CORROBORAR EL CICLO DE VIDA
	 * DE UNA ENTIDAD JPA
	 */
	@Test
	public void testC(){
		checkLifeCycle();
		
	}
	
	
}

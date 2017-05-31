package mx.bluecode.test.sesiones.dos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.bluecode.model.entities.Animal;
import mx.bluecode.model.enums.TipoAlimentacion;


/**
 * Test Unitario para conocer los constrains
 * utilizados en JPA
 * @author devcode
 *
 */
public class TestConstraints {
	
	private static final Logger log = LoggerFactory.getLogger(TestConstraints.class);
	
	private static final String PERSISTENCE_UNIT_NAME = "ApplicationPU";
		
	private EntityManager em;
		
	@Before
	public void initialize(){
		log.info("Creando un entity manager para: {} ", PERSISTENCE_UNIT_NAME);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em  = emf.createEntityManager();		
		log.info("Entity Manager creado!!! \n \n");		
	}
	
	
	private void insertarAnimales(){
		log.info("---- Insertando Animales ----");
		
		log.info("Preparando datos.");
		Animal winniePhoo = new Animal(1L, "Winnie Phoo", "Oso", TipoAlimentacion.HERVIVORO);
		Animal ranaRene = new Animal(2L, "Rana Rene", "Rana", TipoAlimentacion.HERVIVORO);
		Animal scoobyDoo = new Animal(3L, "Scoooooooooooby Doooooooobye Dooooooooooooooooooo", "Perro", TipoAlimentacion.OMNIVORO);
		Animal simba = new Animal(4L, "Simba", null, TipoAlimentacion.CARNIVORO);
		Animal timon = new Animal(5L, "Timón", "Suricata", null);
			
		em.getTransaction().begin();
		log.info("Abriendo una transacción.");
		em.persist(winniePhoo);
		em.persist(ranaRene);
		em.persist(scoobyDoo);
		em.persist(simba);
		em.persist(timon);
		log.info("Llamando al commit.");
		em.getTransaction().commit();
		log.info("Commit realizado.");
		
		log.info("---- ---- ---- ---- \n \n");
	}
	
	/**
	 * Imprime el contenido de la tabla TBL_ANIMALES
	 */
	@SuppressWarnings("unchecked")
	private void imprimirAnimales(){
		log.info("---- Imprimiento el contenido de la tabla: TBL_ANIMALES ----");
		Query query = em.createQuery("SELECT o FROM Animal AS o");
		List<Animal> animales =  query.getResultList();
		for (Animal animal : animales) {
			log.info(animal.toString());
		}		
		log.info("---- ---- ---- ---- \n \n");		
	}
	

	/**
	 * Prueba unitaria que intenta insertar un registro
	 * que no cumple con los constraints especificados en JPA.
	 * en esta prueba se espera que se lance una excepción del
	 * tipo PersistenceException.
	 */
	@Test(expected=PersistenceException.class)
	public void testA(){
		insertarAnimales();
		imprimirAnimales();
		// Si la prueba llega hasta este punto se marca como fallida.
		Assert.fail();
	}
	
}

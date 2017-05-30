package mx.bluecode.test.sesiones.dos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.bluecode.model.entities.Animal;
import mx.bluecode.model.enums.TipoAlimentacion;


/**
 * Test unitario para conocer la utilidad 
 * de las enumeraciones en una entidad.
 * @author devcode
 *
 */
public class TestEnumeraciones {
	
	private static final Logger log = LoggerFactory.getLogger(TestEnumeraciones.class);
	
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
		Animal scoobyDoo = new Animal(3L, "Scooby Doo", "Perro", TipoAlimentacion.OMNIVORO);
		Animal simba = new Animal(4L, "Simba", "León", TipoAlimentacion.CARNIVORO);
		Animal timon = new Animal(5L, "Timón", "Suricata", TipoAlimentacion.OMNIVORO);
		
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
			log.info("Animal[ id = {}, "
					+ "nombre = {}, "
					+ "tipo = {}, "
					+ "tipoAlimentacion = {}, "
					+ "tipoAlimentacionDescripcion = {} ]",
					animal.getId(),
					animal.getNombre(),
					animal.getTipo(),
					animal.getTipoAlimentacion(),
					animal.getTipoAlimentacion().getDescription());
		}		
		log.info("---- ---- ---- ---- \n \n");		
	}
	

	@Test
	public void testA(){
		insertarAnimales();
		imprimirAnimales();
	}
	
	

}

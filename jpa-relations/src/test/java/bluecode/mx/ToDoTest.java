package bluecode.mx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bluecode.mx.jpa.model.entities.ToDo;

/**
 * Prueba Unitara para verificar el funcionamiento
 * del proyecto JPA con Eclipse Link como implementación.
 * @author devcode
 *
 */
public class ToDoTest {
	
	private static final Logger log = LoggerFactory.getLogger(ToDoTest.class);
	
	private static final String PERSISTENCE_UNIT_NAME = "JPARelationsPU";
	
	private static final String FIND_ALL_TO_DO = "SELECT o FROM ToDo AS o";
	
	
	private EntityManager em;
	
	@Before
	public void initialize(){
		log.info("---- CREANDO UN ENTITY MANAGER PARA: {} ----", PERSISTENCE_UNIT_NAME);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em  = emf.createEntityManager();		
		log.info("---- ENTITY MANAGER CREADO ---- \n \n");		
	}
	
	
	public void insert(){
		log.info("---- SE INSERTAN DATOS EN LA TABLA: TBL_TO_DO  ----");
		
		ToDo itemOne = new ToDo(null, "Hacer presentación para taller JPA", createDate("2017-06-10") , new Date(), false);
		ToDo itemTwo = new ToDo(null, "Seleccionar Menu Lunch And Learn", createDate("2017-06-09") , new Date(), false);
		
		em.getTransaction().begin();
		em.persist(itemOne);
		em.persist(itemTwo);
		em.getTransaction().commit();
		log.info("---- REGISTROS INSERTADOS ---- \n \n");
	}
	
	
	public void printToDoList(){
		
		log.info("---- IMPRIMIENDO LISTA DE COSAS POR HACER ----");
		Query query = em.createQuery(FIND_ALL_TO_DO);
		List<ToDo> toDoList = query.getResultList();
		for (ToDo toDo : toDoList) {
			log.info(toDo.toString());
		}
		
		log.info("---------------------- \n \n");
	}
	
	
	private static Date createDate(String dateStr){
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			log.error("Error al crear una fecha", e);
		}
		return date;
	}

	
	@Test
	public void runTest(){
		insert();
		printToDoList();
	}
	
}

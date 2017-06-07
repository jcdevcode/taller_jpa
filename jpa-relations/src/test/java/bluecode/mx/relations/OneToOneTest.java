package bluecode.mx.relations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneToOneTest {
	
	private static final Logger log = LoggerFactory.getLogger(OneToOneTest.class);
			
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
	
	
	@Test
	public void runTest(){
		
	}

}

package bluecode.mx;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Test unitario base.
 * @author Julio Cesar Bolaños Palacios
 * @since 07/06/2017
 * @version 1.0
 */
public class BaseTest {
	
	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	
	private static final String PERSISTENCE_UNIT_NAME = "JPARelationsPU";	
	
	protected EntityManager em;
	
	private EntityManagerFactory emf;
	
	@Before
	public void initialize(){
		log.info("---- CREANDO UN ENTITY MANAGER PARA: {} ----", PERSISTENCE_UNIT_NAME);
		this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em  = emf.createEntityManager();		
		log.info("---- ENTITY MANAGER CREADO ---- \n \n");		
	}

	@After
	public void finalize(){
		if(em != null && em.isOpen()){
			log.info("---- CERRANDO ENTITY MANAGER ----");
			em.close();
		}
		
		if(emf != null && emf.isOpen()){
			log.info("---- CERRANDO ENTITY MANAGER FACTORY ----");
			this.emf.close();
		}
	}
	
	
	
	/**
	 * Get Date object from String
	 * @param dateStr date in string format: yyyy-MM-dd
	 * @return
	 */
	public Date getDate(String dateStr){
		Date date = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			log.error("Parse error ocurred.", e);
		}
		return date;
		
	}
}

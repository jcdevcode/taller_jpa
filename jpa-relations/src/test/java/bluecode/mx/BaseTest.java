package bluecode.mx;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
	private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	protected static EntityManagerFactory emf;
	protected static EntityManager em;

	protected static void initPersistenceContext() {
		log.info("--- INICIALIZANDO CONTEXTO DE PERSISTENCIA ----");
		emf = Persistence.createEntityManagerFactory("JPARelationsPU");
		em = emf.createEntityManager();
		log.info("----------------------- \n \n \n");
	}

	protected static void closePersistenceContext() {
		
		if (em != null && em.isOpen())
			em.close();
		if (emf != null && emf.isOpen())
			emf.close();
		log.info("---- PERSISTENCE CONTEXT CERRADO----");
	}


}

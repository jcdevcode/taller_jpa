package mx.bluecode.test.sesiones.dos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import mx.bluecode.model.entities.inheritance.Personal;
import mx.bluecode.model.entities.inheritance.PersonalNoTecnico;
import mx.bluecode.model.entities.inheritance.PersonalTecnico;
import mx.bluecode.model.enums.AreaLaboral;

/**
 * Prueba unitaria para ejemplificar la herencia
 * en JPA utilizando la estrategia SINGLE TABLE.
 * @author devcode
 *
 */
public class TestHerencia {
	
	private static final Logger log = LoggerFactory.getLogger(TestHerencia.class);
	
	private static final String PERSISTENCE_UNIT_NAME = "ApplicationPU";
		
	private EntityManager em;
	private EntityManagerFactory emf;
		
	@Before
	public void initialize(){
		log.info("Creando un entity manager para: {} ", PERSISTENCE_UNIT_NAME);
		this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em  = emf.createEntityManager();		
		log.info("Entity Manager creado!!! \n \n");		
	}
	
	/**
	 * Insertar elementos del personal técnico
	 */
	private void insertarPersonalTecnico(){
		log.info("---- INSERTANDO AL EQUIPO TÉCNICO ----");
		PersonalTecnico hugo = new PersonalTecnico("Hugo Herrera", AreaLaboral.DESARROLLO, "FRONT-END", "SENIOR");
		PersonalTecnico diana = new PersonalTecnico("Diana Villanueva", AreaLaboral.DESARROLLO, "BACK-END", "SENIOR");
		PersonalTecnico jorge = new PersonalTecnico("Jorge Osornio", AreaLaboral.INFRAESTRUCTURA, "SYS ADMIN", "SENIOR");
		PersonalTecnico adry = new PersonalTecnico("Adriana Montes", AreaLaboral.QA, "TESTER", "SENIOR");		
		
		em.getTransaction().begin();
		
		em.persist(hugo);
		em.persist(diana);
		em.persist(jorge);
		em.persist(adry);
		
		em.getTransaction().commit();		
		log.info("---- PERSONAL TÉCNICO INSERTADO ---- \n \n");
	}
	
	
	/**
	 * Insertar elementos del personal no técnico
	 */
	private void insertarPersonalNoTecnico(){
		log.info("---- INSERTANDO AL EQUIPO NO TÉCNICO ----");
		PersonalNoTecnico sandra = new PersonalNoTecnico("Sandra", AreaLaboral.RH, true);
		PersonalNoTecnico karina = new PersonalNoTecnico("Karina Vargas", AreaLaboral.RH, true);
		PersonalNoTecnico monica = new PersonalNoTecnico("Monica Abril Sanchez", AreaLaboral.ADMINISTRACION, true);
		PersonalNoTecnico efren = new PersonalNoTecnico("Efren Trinidad", AreaLaboral.DIRECCION, true);
		
		
		em.getTransaction().begin();
		
		em.persist(sandra);
		em.persist(karina);
		em.persist(monica);
		em.persist(efren);
		
		em.getTransaction().commit();		
		log.info("---- PERSONAL NO TÉCNICO INSERTADO ---- \n \n");
	}
	
	@After
	public void endTest(){
		log.info("CERRANDO EntityManager y EntityManagerFactory");
		if(this.em != null)
			this.em.close();
		if(this.emf != null)
			this.emf.close();
	}
	
	@SuppressWarnings("unchecked")
	private void imprimirPersonal(){
		log.info("---- IMPRIMIENDO EL PERSONAL DESDE UN JPQL ----");
		Query q = this.em.createQuery("SELECT p FROM Personal AS p");
		List<Personal> personalEmpresa = q.getResultList();
		for (Personal personal : personalEmpresa) {
			log.info(personal.toString());
		}
		log.info("---- ---- ---- ---- \n \n");
		Assert.assertNotNull(personalEmpresa);
		Assert.assertFalse(personalEmpresa.isEmpty());
	}
	

	
	@Test
	public void testA(){
		insertarPersonalTecnico();
		insertarPersonalNoTecnico();
		imprimirPersonal();
		
	}
}

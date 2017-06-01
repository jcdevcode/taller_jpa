package mx.bluecode.test.sesiones.tres;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.bluecode.model.entities.relations.Direccion;
import mx.bluecode.model.entities.relations.Empleado;

public class OneToOneTest {
	
private static final Logger log = LoggerFactory.getLogger(OneToOneTest.class);
	
	private static final String PERSISTENCE_UNIT_NAME = "ApplicationPU";
		
	private EntityManager em;
		
	@Before
	public void initialize(){
		log.info("Creando un entity manager para: {} ", PERSISTENCE_UNIT_NAME);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.em  = emf.createEntityManager();		
		log.info("Entity Manager creado!!! \n \n");		
	}
	
	
	public void insertarDatos(){
		log.info("---- INSERTANDO UN EMPLEADO CON SU DIRECCIÓN  ----");
		Empleado empleado = new Empleado();
		empleado.setNombreEmpleado("JUAN HERNANDEZ");
		empleado.setCodigoEmpladoUnico("20160113-JUAN-HDZ");
		empleado.setDireccion(new Direccion("Amargura", 563360L, "Lt 18", "Mz. 12"));
		
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();
		
		log.info("---- DATOS INSERTADOS!!!! ------   \n \n");
	}
	
	
	public void imprimir(){
		log.info("----- IMPRIMIENDO DATOS DE LA TABLA ----- ");
		Query query = em.createQuery("SELECT e FROM Empleado AS e");
		@SuppressWarnings("unchecked")
		List<Empleado> empleados = query.getResultList();
		for (Empleado empleado : empleados) {
			log.info(empleado.toString());
		}
	}
	
	@Test
	public void testA(){
		insertarDatos();
		imprimir();
	}

}

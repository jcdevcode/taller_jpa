package bluecode.mx;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bluecode.mx.jpa.model.entities.Direccion;
import bluecode.mx.jpa.model.entities.Empleado;
import bluecode.mx.jpa.model.entities.Telefono;

public class OneToOneTest extends BaseTest{
	private static final Logger log = LoggerFactory.getLogger(OneToOneTest.class);
	
	public void insertaEmpleado(){
		log.info("---- INSERTANDO EMPLEADO ---- ");
		Direccion direccion = new Direccion();		
		direccion.setId(1L);
		direccion.setUbicacion("Tlaco 21, del Valle. CD Mx.");
		direccion.setCodigoPostal(56562);
		
		Empleado juan = new Empleado();
		juan.setId(1L);
		juan.setNombre("Juan Perez");
		juan.setDireccion(direccion);
		
		em.getTransaction().begin();
		
		em.persist(juan);
		
		em.getTransaction().commit();
		
		Assert.assertNotNull(juan.getId());
		Assert.assertNotNull(juan.getDireccion().getId());
		
		log.info("-------- \n \n");
	}
	
	
	public void imprimeDatosEmpleado(){
		log.info("--- BUSCANDO EMPLEADO POR ID .-----");
		Empleado emp = em.find(Empleado.class, 1L);				
		log.info("{}", emp);
		
		log.info("-------- \n \n");
	}
	
	
	
	public void eliminaEmpleado(){
		log.info("--- ELIMINANDO EMPLEADO POR ID ----");
		em.getTransaction().begin();
		Empleado emp = em.find(Empleado.class, 1L);
		em.remove(emp);
		em.getTransaction().commit();
		log.info("-------- \n \n");
	}

	@Test
	public void runTest(){
		insertaEmpleado();
		imprimeDatosEmpleado();
		eliminaEmpleado();
		imprimeDatosEmpleado();	
	
	}
	
	
}

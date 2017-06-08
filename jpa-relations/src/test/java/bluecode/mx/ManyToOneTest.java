package bluecode.mx;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bluecode.mx.jpa.model.entities.Direccion;
import bluecode.mx.jpa.model.entities.Empleado;
import bluecode.mx.jpa.model.entities.Telefono;

public class ManyToOneTest extends BaseTest{
	private static final Logger log = LoggerFactory.getLogger(ManyToOneTest.class);
	
	public void insertaEmpleado(){
		log.info("---- INSERTANDO EMPLEADO ---- ");
		Direccion direccion = new Direccion();		
		direccion.setId(1L);
		direccion.setUbicacion("Tlaco 21, del Valle. CD Mx.");
		direccion.setCodigoPostal(56562);
		
		List<Telefono> telefonos = new ArrayList<>();
		telefonos.add(new Telefono(1L, "5560846842"));
		telefonos.add(new Telefono(2L, "58532792"));
		telefonos.add(new Telefono(3L, "5589562455"));
		
		Empleado juan = new Empleado();
		juan.setId(1L);
		juan.setNombre("Juan Perez");
		juan.setDireccion(direccion);
		juan.setTelefonos(telefonos);
		
		
		em.getTransaction().begin();
		
		em.persist(juan);
		
		em.getTransaction().commit();
		
		Assert.assertNotNull(juan.getId());
		Assert.assertNotNull(juan.getDireccion().getId());
		
		log.info("-------- \n \n");
	}
	
	
	public void imprimirDatosTelefono(){
		log.info("--- BUSCANDO TELEFONO POR ID .-----");
		em.getTransaction().begin();
		Telefono telefono = em.getReference(Telefono.class, 1L);
		
		log.info("{}", telefono);
		log.info("{}", telefono.getEmpleado());
		em.getTransaction().commit();
		
		log.info("-------- \n \n");
	}
	
	
	public void imprimeDatosEmpleado(){
		log.info("--- BUSCANDO EMPLEADO POR ID .-----");
		em.getTransaction().begin();
		Empleado emp = em.find(Empleado.class, 1L);		
		log.info("{}", emp);
		em.getTransaction().commit();
		log.info("-------- \n \n");
	}
	
	@Test
	public void runTest(){
		insertaEmpleado();
		imprimeDatosEmpleado();
		imprimirDatosTelefono();
	}

}

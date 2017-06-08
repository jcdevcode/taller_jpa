package bluecode.mx.relations;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bluecode.mx.BaseTest;
import bluecode.mx.jpa.model.entities.Direccion;
import bluecode.mx.jpa.model.entities.Lector;
import bluecode.mx.jpa.model.enums.TypoGenero;

public class OneToOneTest extends BaseTest{
	
	private static final Logger log = LoggerFactory.getLogger(OneToOneTest.class);
			
	
	/**
	 * Insertar a un lector con su dirección.
	 * Comprueba Cascada PERSIST
	 */
	public void insertar(){
		
		log.info("---- INSERTANDO UN LECTOR CON SU DIRECCIÓN ----");
		Lector juan = new Lector(1L, "Juan Rulfo", getDate("1917-05-16"), TypoGenero.MASCULINO, "AAAA001");
		Direccion direccion = new Direccion(1L, "LA AMARGURA", "Lt. 18", "Mz. 315", 53315L, "Colonia del Valle", "CDMX");
		juan.setDireccion(direccion);
		
		this.em.getTransaction().begin();
		em.persist(juan);
		this.em.getTransaction().commit();
		
		Assert.assertNotNull(juan.getId());
		Assert.assertNotNull(direccion.getIdDireccion());
		
		log.info("---- DATOS INSERTADOS ---- \n \n");
		
	}
	
	
	/**
	 * Imprimir lectores.
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public void imprimirLectores(){
		log.info("---- IMPRIMIENDO LECTORES ----");
		Query queryOne = this.em.createQuery("SELECT o FROM Lector AS o");
		List<Lector> lectores = queryOne.getResultList();		
		Assert.assertNotNull(lectores);		
		
		log.info("Lectores en el sistema: {}", lectores.size());
		for (Lector lector : lectores) {
			log.info(lector.toString());
		}
		
		log.info("----------------- \n \n");
		
		Query queryTwo = this.em.createQuery("SELECT o FROM Direccion AS o");
		List<Direccion> direcciones = queryTwo.getResultList();
		Assert.assertNotNull(direcciones);
		log.info("Direcciones en el sistema: {}", direcciones.size());
		for (Direccion direccion : direcciones) {
			log.info(direccion.toString());
		}
		
		log.info("----------------- \n \n");
	}
	
	
	
	@SuppressWarnings({ "unused", "unchecked" })
	public void imprimirBidireccional(){
		log.info("---- IMPRIMIENDO LECTORES DE FORMA BIDIRECCIONAL ----");
				
		Query queryTwo = this.em.createQuery("SELECT o FROM Direccion AS o");
		List<Direccion> direcciones = queryTwo.getResultList();
		Assert.assertNotNull(direcciones);
		log.info("Direcciones en el sistema: {}", direcciones.size());
		for (Direccion direccion : direcciones) {
			log.info(direccion.toString());
			log.info(direccion.getLector().toString());
		}
		
		log.info("----------------- \n \n");
	}
	
	/**
	 * Eliminar a un lector, en cascada se elimina la dirección 
	 * cuando la relación esta marcada como: CascadeType.REMOVE
	 */
	public void eliminar(){
		log.info("---- ELIMINAR EL REGISTRO INSERTADO ----");
		this.em.getTransaction().begin();
		Lector juan = this.em.find(Lector.class, 1L);
		Assert.assertNotNull(juan);
		this.em.remove(juan);
		this.em.getTransaction().commit();
		log.info("----------------- \n \n");
	}
	
	
	
	@Test
	public void runTestUnidireccional(){
		insertar();
		imprimirLectores();
		eliminar();
		imprimirLectores();
	}
	
	
	@Test
	public void runTestBidireccional(){
		insertar();
		imprimirBidireccional();
		
	}

}

package bluecode.mx;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bluecode.mx.jpa.entities.Empleado;
import bluecode.mx.jpa.entities.Telefono;

public class OneToManyTest extends BaseTest{

	private static final Logger log = LoggerFactory.getLogger(OneToManyTest.class);
	
	public static void crearEmpleado() {
		log.info("---- CREANDO EMPLEADO EN BD ----");
		
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1L);
		empleado.setNombre("Michel Doe");
		
		Telefono movil = new Telefono();
		movil.setIdTelefono(1L);
		movil.setNumeroTelefonico("+52 5560846842");
		movil.setPropietario(empleado);
		
		Telefono oficina = new Telefono();
		oficina.setIdTelefono(2L);
		oficina.setNumeroTelefonico("55 58528712");
		oficina.setPropietario(empleado);
				

		em.getTransaction().begin();
		em.persist(movil);
		em.persist(oficina);
		em.getTransaction().commit();

		em.detach(movil);
		em.detach(oficina);
		

		log.info("\n \n \n");

	}
	
	private static void recuperarEmpleado() {
		log.info("---- RECUPERANDO EMPLEADO ----");
		Empleado empleado = em.find(Empleado.class, 1L);

		log.info("DATOS EMPLEADO: {}", empleado);

		log.info("AHORA SE HACE UN GET A LOS TELEFONOS DEL EMPLEADO.");

		log.info("TELEFONOS DEL EMPLEADO: {}", empleado.getTelefonos());
		
		log.info("\n \n \n");
		
		em.detach(empleado);
	}
	
	private static void recuperarTelefonoMovil() {
		
		log.info("---- RECUPERANDO TELEFONO MOVIL ----");
		
		Telefono movil = em.find(Telefono.class, 1L);

		log.info("DATOS TELÉFONO MÓVIL: {}", movil);

		log.info("AHORA SE HACE UN GET AL PROPIETARIO");

		log.info("DATOS DEL PROPIETARIO: {}", movil.getPropietario());
		
		log.info("\n \n \n");
		
		em.detach(movil);
		
	}
	
	
	
	
	public static void main(String[] args) {
		initPersistenceContext();
		crearEmpleado();
		recuperarEmpleado();
		recuperarTelefonoMovil();
		closePersistenceContext();
	}

	
}

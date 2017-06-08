package bluecode.mx;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bluecode.mx.jpa.dto.EmpleadoDto;
import bluecode.mx.jpa.entities.Direccion;
import bluecode.mx.jpa.entities.Empleado;

public class OneToOneTest extends BaseTest{

	private static final Logger log = LoggerFactory.getLogger(OneToOneTest.class);
	
	public static void crearEmpleado() {
		log.info("---- CREANDO EMPLEADO EN BD ----");

		Direccion direccion = new Direccion();
		direccion.setIdDireccion(1L);
		direccion.setPais("México");
		direccion.setCiudad("CD-MX");

		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1L);
		empleado.setNombre("John Smith");
		empleado.setDireccion(direccion);

		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();

		em.detach(empleado);
		em.detach(direccion);

		log.info("\n \n \n");

	}

	public static void recuperarDireccion() {
		log.info("---- RECUPERANDO DIRECCION PARA PROBAR LA RELACION BIDIRECCIONAL ----");
		Direccion direccion = em.find(Direccion.class, 1L);

		log.info("DATOS DIRECCIÓN: {}", direccion);

		log.info("AHORA SE HACE UN GET AL AMPLEADO ASOCIADO A LA DIRECCION.");

		log.info("DATOS EMPLEADO: {}", direccion.getEmpleado());
		
		log.info("\n \n \n");
		
		em.detach(direccion);
	}

	private static void recuperarEmpleado() {
		log.info("---- RECUPERANDO EMPLEADO ----");
		
		String query = "Select new bluecode.mx.jpa.dto.EmpleadoDto(o.idEmpleado, o.nombre, o.empresa.nombreEmpresa, o.direccion.pais ) FROM Empleado AS o";
		List<EmpleadoDto> empleados = em.createQuery(query, EmpleadoDto.class).getResultList();
		
		for (EmpleadoDto empleadoDto : empleados) {
			log.info("{}", empleadoDto);
		}
	}

	public static void main(String[] args) {
		initPersistenceContext();
		crearEmpleado();
		recuperarEmpleado();
		//recuperarDireccion();
		closePersistenceContext();
	}

}

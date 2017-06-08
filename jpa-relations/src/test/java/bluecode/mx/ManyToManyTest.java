package bluecode.mx;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bluecode.mx.jpa.entities.Direccion;
import bluecode.mx.jpa.entities.Empleado;
import bluecode.mx.jpa.entities.Proyecto;
import bluecode.mx.jpa.entities.Telefono;

public class ManyToManyTest extends BaseTest {
		
	private static final Logger log = LoggerFactory.getLogger(ManyToManyTest.class);
	
	
	public static void crearEmpleado() {
		log.info("---- CREANDO EMPLEADO EN BD ----");
		
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1L);
		empleado.setNombre("Raymundo Reyes");
		
		
		Telefono movil = new Telefono();
		movil.setIdTelefono(1L);
		movil.setNumeroTelefonico("+52 5560846842");
		movil.setPropietario(empleado);
		
		Direccion direccion = new Direccion();
		direccion.setIdDireccion(1L);
		direccion.setPais("México");
		direccion.setCiudad("CD-MX");
		
		List<Telefono> telefonos = new ArrayList<>();
		telefonos.add(movil);
		
		empleado.setTelefonos(telefonos);
		empleado.setDireccion(direccion);
		
		Proyecto proyectoUno = new Proyecto();
		proyectoUno.setIdProyecto(1L);
		proyectoUno.setNombreProyecto("Colonización Marte.");
		
		Proyecto proyectoDos = new Proyecto();
		proyectoDos.setIdProyecto(2L);
		proyectoDos.setNombreProyecto("Vuelo a la Luna");
		
		List<Proyecto> proyectos = new ArrayList<>();
		proyectos.add(proyectoUno);
		proyectos.add(proyectoDos);
		
		empleado.setProyectos(proyectos);
		
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();


		log.info("\n \n \n");
		em.detach(empleado);
	}
	
	
	
	public static void crearEmpleadoAdicional() {
		log.info("---- CREANDO EMPLEADO ADICIONAL EN BD ----");
		
			
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(2L);
		empleado.setNombre("Horacion Ferro");
		
		
		Telefono movil = new Telefono();
		movil.setIdTelefono(3L);
		movil.setNumeroTelefonico("52878952");
		movil.setPropietario(empleado);
		
		Direccion direccion = new Direccion();
		direccion.setIdDireccion(2L);
		direccion.setPais("México");
		direccion.setCiudad("CD-MX");
		
		List<Telefono> telefonos = new ArrayList<>();
		telefonos.add(movil);
		
		empleado.setTelefonos(telefonos);
		empleado.setDireccion(direccion);
			
		
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();


		log.info("\n \n \n");
		em.detach(empleado);
	}
	
	
	
	private static void recuperarEmpleado() {
		log.info("---- RECUPERANDO EMPLEADO ----");
		Empleado empleado = em.find(Empleado.class, 1L);

		log.info("DATOS EMPLEADO: {}", empleado);

		log.info("AHORA SE HACE UN GET A LA DIRECCIÓN ASOCIADA AL EMPLEADO.");

		log.info("DATOS DE LA DIRECCIÓN: {}", empleado.getDireccion());
		
		log.info("AHORA SE HACE UN GET A SUS TELEFONOS");

		log.info("DATOS TELEFONOS: {}", empleado.getTelefonos());

		log.info("AHORA SE HACE UN GET A SUS PROYECTOS");

		log.info("DATOS TELEFONOS: {}", empleado.getProyectos());

		
		log.info("\n \n \n");
		
		em.detach(empleado);
	}
	
	
	public static void registrarEmpleadoAlProyecto(){
		log.info("---- SE REGISTRA UN EMPLEADO ADICIONAL AL PROYECTO ----");
		Proyecto proyecto = em.find(Proyecto.class, 1L);
		
		Empleado empleado = em.find(Empleado.class, 2L);
		
		List<Proyecto> proyectos = empleado.getProyectos();
		if(proyectos == null){
			proyectos = new ArrayList<>();
		}
		
		proyectos.add(proyecto);
		
		empleado.setProyectos(proyectos);
		
		
		em.getTransaction().begin();
		em.merge(empleado);
		em.getTransaction().commit();
		
		log.info("\n \n \n");
		
		em.detach(empleado);
		em.detach(proyecto);
		
	}
	
	
	
	public static void obtenerEmpleadosProyectos(){
		log.info("----- SE OBTIENEN TODOS LOS PROYECTOS Y SE PINTAN SUS EMPLEADOS ASIGNADOS. -----");
		List<Proyecto> proyectos = em.createQuery("SELECT o FROM Proyecto AS o").getResultList();
		for (Proyecto proyecto : proyectos) {
			log.info("-------------------");
			log.info("EL PROYECTO: {} ", proyecto);
			log.info("TIENE LOS SIGUIENTES EMPLEADOS: {}", proyecto.getEmpleados());
		}
		
		log.info("\n \n \n");
	}
	
	private static void pruebaBidireccional() {
		initPersistenceContext();
		crearEmpleado();		
		recuperarEmpleado();		
		crearEmpleadoAdicional();
		registrarEmpleadoAlProyecto();		
		obtenerEmpleadosProyectos();
		closePersistenceContext();		
	}



	private static void pruebaUnidireccional() {
		initPersistenceContext();
		crearEmpleado();		
		recuperarEmpleado();	
		closePersistenceContext();
		
	}
	
	public static void main(String[] args) {
		pruebaUnidireccional();
		pruebaBidireccional();
	}



	
}

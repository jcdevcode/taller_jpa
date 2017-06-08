package bluecode.mx;

import java.util.ArrayList;
import java.util.List;

import bluecode.mx.jpa.entities.Direccion;
import bluecode.mx.jpa.entities.Empleado;
import bluecode.mx.jpa.entities.Empresa;
import bluecode.mx.jpa.entities.Telefono;

public class FetchProblemTest extends BaseTest{

	public static void insertarEmpresa(){
		// SE CREA LA EMPRESA
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(1L);
		empresa.setNombreEmpresa("NASA CORP");
		
		
		// SE CREA LA DIRECCION DEL EMPLEADO
		Direccion direccion = new Direccion();
		direccion.setIdDireccion(1L);
		direccion.setCiudad("TIJUANA.");
		direccion.setPais("MÉXICO");
		
		// SE CREA EL TELEFONO DEL EMPLEADO
		Telefono telefono = new Telefono();
		telefono.setIdTelefono(1L);
		telefono.setNumeroTelefonico("52586522112");
		List<Telefono> telefonos = new ArrayList<>();
		telefonos.add(telefono);
		
		// SE CREA UN EMPLEADO
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1L);
		empleado.setNombre("Juan Camaney");
		empleado.setEmpresa(empresa);
		empleado.setDireccion(direccion);
		empleado.setTelefonos(telefonos);
		
		List<Empleado> empleados = new ArrayList<>();
		empleados.add(empleado);
		empresa.setEmpleados(empleados);
		
		em.getTransaction().begin();
		em.persist(empresa);
		em.getTransaction().commit();
		
		em.detach(empresa);
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		initPersistenceContext();
		insertarEmpresa();
		closePersistenceContext();
	}
}

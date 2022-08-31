import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ar.unlam.edu.pb2.ControlBiometrico;
import ar.unlam.edu.pb2.Empleado;
import ar.unlam.edu.pb2.Ingresos;
import ar.unlam.edu.pb2.Usuario;

public class Test {

	@org.junit.Test
	public void queSeRegistreUnUsuario() {
		ControlBiometrico control = new ControlBiometrico("hola",5000);
		Usuario usuario = new Usuario(2);
		Boolean valorObtenido = control.registrarUsuario(usuario);
		assertNotNull(usuario);
	}
	
	@org.junit.Test
	public void queSeObtengaUnUsuarioPorSuNumeroDeUsuario() {
		Usuario usuario = new Usuario(20);
		ControlBiometrico control = new ControlBiometrico("hola",5000);
		Boolean cosa = control.registrarUsuario(usuario);
		Usuario valorObtenido = control.buscarUsuarioPorNumero(20);
		assertEquals(usuario, valorObtenido);
	}

	@org.junit.Test
	public void queSeObtengaElGerenteDeMayorSueldo() {
		Usuario usuario = new Usuario(20,"adf",Empleado.GERENTE,100);
		Usuario valorEsperado = new Usuario(25,"adfg",Empleado.GERENTE,300);
		Usuario usuario2 = new Usuario(27,"adfjj",Empleado.GERENTE,250);
		Usuario usuario1 = new Usuario(21,"a2",Empleado.GERENTE,200);
		
		ControlBiometrico control = new ControlBiometrico("hola",5000);
	
		control.registrarUsuario(usuario);
		control.registrarUsuario(valorEsperado);
		control.registrarUsuario(usuario1);
		control.registrarUsuario(usuario2);
		
		Usuario valorObtenido = control.obtenerGerenteDeMayorSueldo();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@org.junit.Test
	public void queSeRegistreUnIngreso() {
		ControlBiometrico control = new ControlBiometrico("hola",5000);
		Ingresos ingreso = new Ingresos();
		Boolean valorObtenido = control.validarIngreso(ingreso);
		assertNotNull(valorObtenido);
	}
	

	@org.junit.Test
	public void queSeObtengaTodosLosIngresosDeUnMesXOrdenados() {
		ControlBiometrico control = new ControlBiometrico("hola",5000);
		
		
		Ingresos ingreso1 = new Ingresos(2,4,5);
		Ingresos ingreso2 = new Ingresos(3,6,5);
		Ingresos ingreso3 = new Ingresos(4,8,5);
		Ingresos ingreso4 = new Ingresos(4,8,7);
		Ingresos ingreso5 = new Ingresos(2,8,7);
		Ingresos ingreso6 = new Ingresos(3,8,7);

		
		Ingresos[] valorEsperado = control.obtenerIngresosPorMes(5);
		Ingresos[] valorObtenido = control.obtenerIngresosPorMes(7);
		
		assertArrayEquals(valorEsperado, valorObtenido);
		
	}
}

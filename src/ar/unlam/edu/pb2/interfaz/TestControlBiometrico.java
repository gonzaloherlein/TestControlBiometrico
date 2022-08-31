package ar.unlam.edu.pb2.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Especie;
import ar.unlam.edu.pb2.ControlBiometrico;
import ar.unlam.edu.pb2.Empleado;
import ar.unlam.edu.pb2.Ingresos;
import ar.unlam.edu.pb2.Usuario;

public class TestControlBiometrico {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ControlBiometrico control = new ControlBiometrico("ASHEX", 50000);
		int opcion = 0;

		do {
			opcion = seleccionarOpcion(teclado);
			
			switch (opcion) {
			case 1:
				boolean usuarioRegistrado = registrarUsuario(teclado, control);
				if (usuarioRegistrado) {
					mostrarMensaje("\nUsuario creado correctamene");
				} else {
					mostrarMensaje("\nVuelva a intentarlo");
				}
				break;
			case 2:
				Usuario usuario = buscarUsuarioPorNumero(teclado, control);
				if (usuario != null) {
					mostrarMensaje("\nUsuario encontrado:\n\n" + usuario.toString());
				} else {
					mostrarMensaje("\nNo se encontro un USUARIO para ese NUMERO.");
				}
				break;
			case 3:
				Empleado empleado = ingresarTipoEmpleado(teclado);
				Usuario usuarioEmpleados = control.buscarGerenteDeMayorSueldo(empleado);
				mostrarGerentes(usuarioEmpleados);
				break;
			case 4:
				boolean ingreso = registrarIngreso(teclado, control);
				if (ingreso) {
					mostrarMensaje("\nIngreso creado correctamente!");
				} else {
					mostrarMensaje("\nNo fue posible crear el Ingreso");
				}
				break;
			case 5:
				mostrarMensaje("Ingrese el MES para ver los ingresos:");
				int mes = teclado.nextInt();
				Ingresos[] ingresosPorMes = control.ObtenerIngresosPorMes(mes);
				mostrarIngresos(ingresosPorMes);
				break;
			case 9:
				mostrarMensaje("\nSALIENDO....");
				break;
			}

		} while (opcion != 9);
		
		teclado.close();
	}

	private static void mostrarIngresos(Ingresos[] ingreso) {
		for (int i = 0; i < ingreso.length; i++) {
			if (ingreso[i] != null) {
				mostrarMensaje("\nIngresos: " + ingreso[i].toString());
			}
		}
		
	}

	private static boolean registrarIngreso(Scanner teclado, ControlBiometrico control) {

		mostrarMensaje("Ingrese el numero de usuario: ");
		int numero = teclado.nextInt();

		int dia = ingresarDia(teclado);

		int mes = ingresarMes(teclado);

		Ingresos ingreso = new Ingresos(numero, dia, mes);

		return control.validarIngreso(ingreso);
	}

	private static int ingresarMes(Scanner teclado) {
		int mes = 0;
		do {
			mostrarMensaje("Ingrese el mes: ");
			mes = teclado.nextInt();
		} while (mes < 1 || mes > 12);
		return mes;
	}

	private static int ingresarDia(Scanner teclado) {
		int dia = 0;
		do {
			mostrarMensaje("Ingrese el dia: ");
			dia = teclado.nextInt();
		} while (dia < 1 || dia > 31);
		return dia;
	}

	private static void mostrarGerentes(Usuario usuarioEmpleados) {
		mostrarMensaje("\nGerente de Mayor Sueldo: " + usuarioEmpleados.toString());

	}

	private static Usuario buscarUsuarioPorNumero(Scanner teclado, ControlBiometrico control) {
		int numero = ingresarNumero(teclado);
		return control.buscarUsuarioPorNumero(numero);
	}

	private static int ingresarNumero(Scanner teclado) {
		mostrarMensaje("\nIngrese el Numero de Usuario: ");
		return teclado.nextInt();
	}

	private static boolean registrarUsuario(Scanner teclado, ControlBiometrico control) {
		mostrarMensaje("\nIngrese Numero de Usuario:");
		int numero = teclado.nextInt();
		mostrarMensaje("\nIngrese su Apellido:");
		String apellido = teclado.next();

		mostrarMensaje("\nIngrese su Sueldo:");
		int sueldo = teclado.nextInt();

		Empleado empleado = ingresarTipoEmpleado(teclado);

		Usuario usuario = new Usuario(numero, apellido, empleado, sueldo);

		return control.registrarUsuario(usuario);
	}

	private static Empleado ingresarTipoEmpleado(Scanner teclado) {
		int opcionEmpleado = 0;
		do {

			mostrarMensaje("\nIngrese su tipo de Empleado: ");
			mostrarMensaje("\n1 - Administrativo\n2 - Gerente\n3 - Operario: ");
			opcionEmpleado = teclado.nextInt();

		} while (opcionEmpleado < 1 || opcionEmpleado > 3);

		Empleado especieEmpleado = Empleado.values()[opcionEmpleado - 1];

		return especieEmpleado;
	}

	private static int seleccionarOpcion(Scanner teclado) {
		int opcionSeleccionada = 0;

		mostrarMensaje("\n************************");
		mostrarMensaje("Menu Principal\n");
		mostrarMensaje("1 - Registar un Usuario ");
		mostrarMensaje("2 - Obtener un usuario por su numero de usuario");
		mostrarMensaje("3 - Obtener el usuario gerente de mayor sueldo");
		mostrarMensaje("4 - Registrar el ingreso de un usuario");
		mostrarMensaje("5 - Obtener todos los ingresos de un mes");
		mostrarMensaje("\n9 - Salir");
		mostrarMensaje("\n************************");
		mostrarMensaje("\nIngrese una opcion");

		opcionSeleccionada = teclado.nextInt();

		return opcionSeleccionada;
	}

	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);

	}

}

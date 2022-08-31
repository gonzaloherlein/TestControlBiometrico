package ar.unlam.edu.pb2;

import ar.edu.unlam.dominio.Atencion;

public class ControlBiometrico {
		private String nombreDispositivo;
		private Usuario[] usuarios;
		private Ingresos[] ingreso;
		
		public ControlBiometrico(String nombreDispositivo,Integer CANTIDAD_MAXIMA_USUARIOS) {
			this.nombreDispositivo = nombreDispositivo;
			this.usuarios = new Usuario[50000];
			this.ingreso = new Ingresos[10];
		}
		
		public ControlBiometrico() {
			
		}
		
		public boolean registrarUsuario(Usuario usuario) {
			for (int i = 0; i < this.usuarios.length; i++) {
				if(this.usuarios[i] == null) {
					this.usuarios[i] = usuario;
					return true;
				}
			}
			return false;
		}
		
		public Usuario buscarUsuarioPorNumero(Integer numero) {
			Usuario usuarioEncontrada = null;
			for (int i = 0; i < this.usuarios.length; i++) {
				if (this.usuarios[i] != null && this.usuarios[i].getNumeroUsuario() == numero) {
					usuarioEncontrada = this.usuarios[i];
					break;
				}
			}

			return usuarioEncontrada;
		}
		
		public Usuario obtenerGerenteDeMayorSueldo() {
			Integer sueldo = 0;
			Usuario gerenteConMayorSueldo = null;
			for (int i = 0; i < usuarios.length; i++) {
				if(usuarios[i]!=null && usuarios[i].getSueldo() > sueldo && usuarios[i].getTipoEmpleado().equals(Empleado.GERENTE)) {
					sueldo = usuarios[i].getSueldo();
					gerenteConMayorSueldo = usuarios[i];
				}
			}
			return gerenteConMayorSueldo;
		}
		
		
		public boolean validarIngreso(Ingresos ingreso) {
			for (int i = 0; i < this.ingreso.length; i++) {
				if(this.ingreso[i] == null) {
					this.ingreso[i] = ingreso;
					return true;
				}
			}
			return false;
		}
		
		public Ingresos[] obtenerIngresosPorMes(Integer mes){
			Ingresos[] ingresoPorMes = new Ingresos[this.ingreso.length];
			int indice = 0;
			for (int i = 0; i < this.ingreso.length; i++) {
				if (this.ingreso[i] != null && this.ingreso[i].getMes() == mes) {
					ordenarIngresosPorNumeroDescendente();
					ingresoPorMes[indice++] = this.ingreso[i];
				}
			}

			return ingresoPorMes;
		}
		
		public void ordenarIngresosPorNumeroDescendente() {

			Ingresos auxiliar = null;

			for (int i = 1; i < this.ingreso.length; i++) {

				for (int j = 0; j < this.ingreso.length - 1; j++) {

					if (this.ingreso[j] != null && this.ingreso[j + 1] != null
							&& this.ingreso[j].getNumero() < this.ingreso[j + 1].getNumero()) {

						auxiliar = this.ingreso[j];
						this.ingreso[j] = this.ingreso[j + 1];
						this.ingreso[j + 1] = auxiliar;
					}
				}
			}
		}

		public Ingresos[] getIngreso() {
			return ingreso;
		}

		public void setIngreso(Ingresos[] ingreso) {
			this.ingreso = ingreso;
		}
		
		
		
}

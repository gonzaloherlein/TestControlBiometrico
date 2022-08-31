package ar.unlam.edu.pb2;

public class Usuario {
		private Integer numeroUsuario;
		private String apellido;
		private Empleado tipoEmpleado;
		private Integer sueldo;
		
		
		public Usuario(Integer numeroUsuario,String apellido, Empleado tipoEmpleado, Integer sueldo) {
			this.numeroUsuario = numeroUsuario;
			this.apellido = apellido;
			this.tipoEmpleado = tipoEmpleado;
			this.sueldo = sueldo;
		}

		public Usuario() {
			
		}
		
		public Usuario(Integer numeroUsuario) {
			this.numeroUsuario = numeroUsuario;
		}

		public Integer getNumeroUsuario() {
			return numeroUsuario;
		}


		public void setNumeroUsuario(Integer numeroUsuario) {
			this.numeroUsuario = numeroUsuario;
		}


		public Integer getSueldo() {
			return sueldo;
		}


		public void setSueldo(Integer sueldo) {
			this.sueldo = sueldo;
		}


		public Empleado getTipoEmpleado() {
			return tipoEmpleado;
		}


		public void setTipoEmpleado(Empleado tipoEmpleado) {
			this.tipoEmpleado = tipoEmpleado;
		}
		
		
}

package ar.unlam.edu.pb2;

public class Ingresos {
		private Integer numero;
		private Integer dia;
		private Integer mes;
		
		
		public Ingresos(Integer numero, Integer dia, Integer mes) {
			this.numero = numero;
			this.dia = dia;
			this.mes = mes;
		}
		
		public Ingresos() {
			
		}

		public Integer getNumero() {
			return numero;
		}


		public void setNumero(Integer numero) {
			this.numero = numero;
		}


		public Integer getDia() {
			return dia;
		}


		public void setDia(Integer dia) {
			this.dia = dia;
		}


		public Integer getMes() {
			return mes;
		}


		public void setMes(Integer mes) {
			this.mes = mes;
		}
		
		
}

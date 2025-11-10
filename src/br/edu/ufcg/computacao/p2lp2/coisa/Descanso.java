package br.edu.ufcg.computacao.p2lp2.coisa;

public class Descanso {
	private int horasDescanso;
	private int numeroSemanas;
	
	public Descanso() {
		this.numeroSemanas = 1;
	}
	
	public void defineHorasDescanso(int horasDescanso) {
		this.horasDescanso = horasDescanso;
	}
	
	public void defineNumeroSemanas(int numeroSemanas) {
		this.numeroSemanas = numeroSemanas;
	}
	
	public String getStatusGeral() {
		double descansado = (double)horasDescanso / numeroSemanas;
		
		if (descansado >= 26) {
			return "descansado";
		} else {
			return "cansado";
		}
	}
}

package br.edu.ufcg.computacao.p2lp2.coisa;

public class RegistroTempoOnline {
	
	private int tempoOnline;
	
	private int tempoOnlineEsperado;
	
	private String nomeDisciplina;
	
	public RegistroTempoOnline(String nomeDisciplina) {
		this(nomeDisciplina, 120);
	}
	
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	public void adicionaTempoOnline(int tempo) {
		tempoOnline += tempo;
	}
	
	public boolean atingiuMetaTempoOnline() {
		if(tempoOnline >= tempoOnlineEsperado) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
	}
}

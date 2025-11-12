package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.*;

public class Disciplina {
	private String nomeDisciplina;
	
	private int horas;
	
	private double[] notas;
	
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
	}
	
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	public void cadastraNota(int nota, double valorNota) {
		notas[nota - 1] = valorNota;
	}
	
	private double media() {
		double soma = 0;
		for (int i = 0; i < notas.length; i++){
			soma += notas[i];
		}
		
		return soma / notas.length;
	}
	
	public boolean aprovado() {
		if(media() >= 7) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return nomeDisciplina + " " + horas + " " + media() + " " + Arrays.toString(notas);
	}
	
}

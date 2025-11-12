package br.edu.ufcg.computacao.p2lp2.coisa;

public class Resumo {
	
	private String nome;
	
	private String conteudo;
	
	public Resumo(String nome, String conteudo) {
		this.nome = nome;
		this.conteudo = conteudo;
	}
	
	public String getName() {
		return nome;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public String toString() {
		return getName() + ": " + getConteudo();
	}
}

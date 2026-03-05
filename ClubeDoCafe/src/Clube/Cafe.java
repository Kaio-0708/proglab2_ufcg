package Clube;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Cafe {
	
	protected String nome;
	protected String origem;
	protected int intensidade;
	protected int qntdDegustacao;
	protected List<Opiniao> opinioes;
	
	public Cafe(String nome, String origem, int intensidade) {
		this.nome = nome;
		this.origem = origem;
		this.intensidade = intensidade;
		this.qntdDegustacao = 0;
		this.opinioes = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public int getIntensidade() {
		return intensidade;
	}
	
	public int getQntdDegustacao() {
		return qntdDegustacao;
	}
	
	public double calcularMediaDasNotas() {
		if(opinioes == null) {
			throw new IllegalArgumentException("Opiniao não encontrada!");
		}

		double soma = 0;
		
		for(int i = 0; i < opinioes.size(); i++) {
			soma += opinioes.get(i).getNota();
		}
		
		double media = soma / opinioes.size();
		
		return media;
	}
	
	public abstract double definirQualidade();
	
	public void addOpiniao(Opiniao opiniao) {
		opinioes.add(opiniao);
		this.qntdDegustacao ++;
	}
	
	public boolean verificarDegustacao(Socio socio) {
		for(int i = 0; i < opinioes.size(); i++) {
			Opiniao o = opinioes.get(i);
			
			if(o.getCodigoSocio().equals(socio.getCodigo())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Cafe other = (Cafe) obj;
		return Objects.equals(nome, other.nome);
	}
	
	@Override
	public String toString() {
		return nome + ": " + origem + ", " + intensidade;
	}
}

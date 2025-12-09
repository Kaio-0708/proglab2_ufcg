package filmnow;

import java.util.*;

/**
 * A representação de um filme, com nome, ano de lançamento e locais de exibição.
 * @author Kaio Vitor Santos Queiroz
 */

public class Filme {
	
	private String nome;
	private int ano;
	private String[] locais;
	private boolean HotList;
	
	public Filme(String nome, int ano, String local) {
		if(nome == null || nome.trim().equals("")){
			throw new IllegalArgumentException("Nome não é válido.");
		}
		
		if(local == null || local.trim().equals("")){
			throw new IllegalArgumentException("Local não é válido.");
		}
		
		if(ano <=0 ) {
			throw new IllegalArgumentException("Ano não é válido.");
		}
		
		this.nome = nome;
		this.ano = ano;
		this.locais = new String[5];
		this.locais[0] = local;
		this.HotList =  false;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public String[] getLocais() {
		return this.locais;
	}
	
	public boolean isHotList() {
		return this.HotList;
	}
	
	public void setHotList(boolean valor) {
		this.HotList = valor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return ano == other.ano && Objects.equals(nome, other.nome);
	}
	
	public int quantidadeDeLocais() {
		int contador = 0;
		for (int i = 0; i < this.locais.length; i ++) {
			if (this.locais[i] != null) {
				contador ++;
			}
		} 
		return contador;
	}
	
	public boolean adicionarLocal(String local) {
		if (quantidadeDeLocais() == 5) {
			return false;
		}
		for (int i = 0; i < this.locais.length; i++) {
			if (this.locais[i] != null && this.locais[i].equals(local)) {
				return false;
			}
		}
		this.locais[quantidadeDeLocais()] = local;
		return true;
	}
	
	public boolean removerLocal(String local) {
		if (quantidadeDeLocais() == 1) {
			return false;
		}
		for (int i =0; i < this.locais.length; i ++) {
			if (local.equals(this.locais[i])) {
				this.locais[i] = null;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}

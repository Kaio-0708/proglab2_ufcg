package Clube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Socio {
	
	private String codigo;
	private String nome;
	private boolean status;
	private List<String> favoritos;
	
	public Socio(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.status = true;
		this.favoritos = new ArrayList<>(); 
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void alterarStatus() {
		status = !status;
	}
	
	public void addFavoritos(Cafe cafe, Socio socio) {
		if(!cafe.verificarDegustacao(socio)) {
			throw new IllegalArgumentException("Só pode favoritar após degustar!");
		}
		 
		favoritos.add(cafe.getNome());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	@Override
	public String toString() {
		String resultado = "";
		
		if(status) {
			resultado = nome + ", ativo";
		} else {
			resultado = nome + ", inativo";
		}
		
		return resultado;
	}
}

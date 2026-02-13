package Job;

import java.util.ArrayList;
import java.util.Objects;

public class Pessoa {
	private String nome;
	private String cpf;
	private String link;
	private String[] habilidades;
	
	public Pessoa(String nome, String cpf, String[] habilidades) {
		this(nome, cpf, null, habilidades);
	}
	
	public Pessoa(String nome, String cpf, String link, String[] habilidades) {
		this.nome = nome;
		this.cpf = cpf;
		this.link = link;
		this.habilidades = habilidades;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getLink() {
		return link;
	}
	
	public String[] getHabilidades() {
		return habilidades;
	}
	
	public void mudarLink(String link) {
		this.link = link;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Pessoa pessoa = (Pessoa) obj;
		return(Objects.equals(cpf, pessoa.cpf));
	}
	
	@Override
	public String toString() {
		return "Nome" + this.nome + "\n" + "CPF" + this.cpf +  "\n" + "Link" + this.link + "\n" + "Habilidades" + this.habilidades;
	}
}

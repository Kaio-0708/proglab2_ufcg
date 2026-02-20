package LNG;

import java.util.Objects;

public class Usuario {
	private String email;
	private String nome;
	private String nick;
	private boolean especialista;
	
	public Usuario(String nick, String email, String nome) {
		this.nick = nick;
		this.email = email;
		this.nome = nome;
	}
	
	public String getNick() {
		return nick;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nick);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) 
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nick, other.nick);
	}
	
	@Override
	public String toString() {
		return "Nick " + this.nick + "\n" + "Nome: " + this.nome + "\n" + "E-mail" + this.email;
	}
}
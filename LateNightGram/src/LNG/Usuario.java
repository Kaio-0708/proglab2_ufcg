package LNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
	private String email;
	private String nome;
	private String nick;
	private boolean especialista;
	private List<Post> posts = new ArrayList<>();
	
	public Usuario(String nick, String email, String nome) {
		this.nick = nick;
		this.email = email;
		this.nome = nome;
		this.especialista = false;
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
	
	public boolean isEspecialista() {
	    return especialista;
	}
	
	public void tornarEspecialista() {
	    this.especialista = true;
	}
	
	public void curtirPost(int pos) {
		if (pos < 0 || pos >= posts.size()) {
	        throw new IndexOutOfBoundsException("Posição inválida");
	    }
		
		posts.get(pos).curtir();
	}
	
	public void adicionarPost(String texto, String link) {
		Post post = new Post(texto, link);
		posts.add(0, post);
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
		return "Nick " + this.nick + "\n" + "Nome: " + this.nome + "\n" + "E-mail:" + this.email;
	}
}
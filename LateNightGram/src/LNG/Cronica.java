package LNG;

import java.util.Objects;

public class Cronica {
	private String titulo;
	private String texto;
	private Usuario autor;
	private String tema;
	private int curtida;
	
	public Cronica(Usuario autor, String tema, String titulo, String texto) {
		this.autor = autor;
		this.tema = tema;
		this.titulo = titulo;
		this.texto = texto;
		this.curtida = 0;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	
	public String getTema() {
		return tema;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public int getCurtida() {
		return curtida;
	}
	
	public void curtir() {
		curtida += 1;
		
		if(curtida >= 100) {
			autor.tornarEspecialista();
		}
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Cronica other = (Cronica) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	@Override
	public String toString() {
		return "Autor: " + this.autor + "\n" + "Tema: " + this.tema + "\n" + "Titulo: " + this.titulo + "\n" + "Texto: " + this.texto;
	}
}

package Clube;

public class Opiniao {
	
	private String codigoSocio;
	private String nomeCafe;
	private int nota;
	private String comentario;
	
	public Opiniao(String codigoSocio, String nomeCafe, int nota, String comentario) {
		this.codigoSocio = codigoSocio;
		this.nomeCafe = nomeCafe;
		this.nota = nota;
		this.comentario = comentario;
	}
	
	public String getCodigoSocio() {
		return codigoSocio;
	}
	
	public String getNomeCafe() {
		return nomeCafe;
	}
	
	public int getNota() {
		return nota;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	@Override
	public String toString() {
		return "Cliente: " + codigoSocio + ". Nota: " + nota + ". Comentário: " + comentario;
	}
}

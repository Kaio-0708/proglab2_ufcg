package LNG;

public class Post {
	private String texto;
	private String link;
	private int curtida;
	
	public Post(String texto, String link) {
		this.texto = texto;
		this.link = link;
		this.curtida = 0;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public String getLink() {
		return link;
	}
	
	public int getCurtida() {
		return curtida;
	}
	
	public void curtir() {
		curtida += 1;
	}
	
	@Override
	public String toString() {
		return "Texto: " + this.texto + "\n" + "Link: " + this.link + "\n" + "Curtida: " + this.curtida;
	}
}

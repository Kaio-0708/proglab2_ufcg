package PRW;

public class Clientes {
	private String nome;
	private String email;
	private String pratoPreferido;
	
	public Clientes(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.pratoPreferido = "Prato preferido não definido";
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void escolherPratoPreferido(String pratoPreferido) {
		this.pratoPreferido = pratoPreferido;
	}
	
	@Override
	public String toString() {
		return "Cliente: " + nome + ", " + " Prato preferido: " + pratoPreferido;
	}
}

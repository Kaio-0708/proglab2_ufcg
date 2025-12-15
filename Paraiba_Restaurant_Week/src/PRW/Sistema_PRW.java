package PRW;

public class Sistema_PRW {
	private Restaurante[] restaurantes = new Restaurante[50];
	private Clientes[] clientes = new Clientes[100];
	private int qntRestaurante = 0;
	private int qntClientes = 0;
	
	public void adicionarRestaurante(String nome, String prato) {
		if (qntRestaurante == 50) {
			return;
		}

		restaurantes[qntRestaurante] = new Restaurante(nome, prato);
				qntRestaurante++;
		}
	
	public void adicionarCliente(String nome, String email) {
		if (qntClientes == 100) {
			return;
		}
		
		clientes[qntClientes] = new Clientes(nome, email);
		qntClientes++;
	}
	
	private Clientes buscarCliente(String email) {
		for(int i = 0; i < qntClientes; i++) {
			if (clientes[i].getEmail().equals(email)) {
				return clientes[i];
			}
		}
		throw new IllegalArgumentException("Cliente não existe");
	}
	
	private Restaurante buscarRestaurante(String nome) {
		for (int i = 0; i < qntRestaurante; i++) {
			if (restaurantes[i].getNome().equals(nome)) {
				return restaurantes[i];
			}
		}
		throw new IllegalArgumentException("Restaurante não existe");
	}
	
	public void visitarRestaurante(String emailCliente, String nomeRestaurante) {
		Clientes cliente = buscarCliente(emailCliente);
		Restaurante restaurantes = buscarRestaurante(nomeRestaurante);
		restaurantes.registrarVisita(cliente);
	}
	
	public String[] listarClientesRestaurante(String nomeRestaurante) {
		Restaurante restaurante = buscarRestaurante(nomeRestaurante);
		return restaurante.listarClientes();
	}
	
	public String votarPratoPreferido(String emailCliente, String nomeRestaurante) {
		Clientes cliente = buscarCliente(emailCliente);
		Restaurante restaurante = buscarRestaurante(nomeRestaurante);
		
		return restaurante.votar(cliente);
	}
	
	public String melhorPrato() {
		if (qntRestaurante == 0) {
			throw new IllegalArgumentException("Nenhum restaurante cadastrado");
		}
		
		Restaurante melhor = restaurantes[0];
		
		for (int i = 1; i < qntRestaurante; i++) {
			if (restaurantes[i].getVoto() > melhor.getVoto()) {
				melhor = restaurantes[i];
			}
		}
		
		return "Melhor prato: " + melhor.getPratoEscolhido() + " Restaurante: " + melhor.getNome();
	}
}

package PRW;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Representa um restaurante no sistema PRW.
 * 
 * Um restaurante possui um nome, um prato principal, um valor fixo de menu,
 * clientes que já o visitaram, votos recebidos e um livro de visitas.
 * O nome do restaurante é usado como identificador único.
 */
public class Restaurante {
	private String nome;
	private String prato;
	private double valorMenu = 89.90;
	private HashSet<Cliente> clientes;
	private int votos;
	private List<Visita> livroVisitas;

	/**
	 * Constrói um restaurante com nome e prato principal.
	 * 
	 * O restaurante inicia sem votos, sem clientes registrados
	 * e com o livro de visitas vazio.
	 * 
	 * @param nome  nome do restaurante
	 * @param prato prato principal do restaurante
	 */
	public Restaurante(String nome, String prato) {
		this.nome = nome;
		this.prato = prato;
		this.votos = 0;
		this.clientes = new HashSet<>();
		this.livroVisitas = new ArrayList<>();
	}

	/**
	 * Retorna a lista de visitas associadas ao livro.
	 *
	 * @return uma lista de {@link Visita} contendo todas as visitas registradas
	 */
	public List<Visita> getLivroVisitas() {
    	return livroVisitas;
    }
	
	/**
	 * Retorna o conjunto de clientes que já visitaram o restaurante.
	 * 
	 * @return conjunto de clientes
	 */
	public HashSet<Cliente> getClientes() {
	    return clientes;
	}

	/**
	 * Retorna o nome do restaurante.
	 * 
	 * @return nome do restaurante
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o prato principal do restaurante.
	 * 
	 * @return prato principal
	 */
	public String getPrato() {
		return prato;
	}

	/**
	 * Retorna o valor do menu do restaurante.
	 * 
	 * @return valor do menu
	 */
	public double getValorMenu() {
		return valorMenu;
	}

	/**
	 * Retorna a quantidade de votos recebidos pelo restaurante.
	 * 
	 * @return número de votos
	 */
	public int getVotos() {
		return votos;
	}
	
	private boolean clienteVisitou(Cliente cliente) {
	    for (Visita visita : livroVisitas) {
	        if (visita.getCliente().equals(cliente)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * Registra um voto para o restaurante, desde que o cliente já o tenha visitado.
	 * 
	 * @param cliente cliente que está votando
	 * @return mensagem indicando se o voto foi registrado ou não
	 */
	public String registrarVoto(Cliente cliente) {
		if(clienteVisitou(cliente)) {
			votos ++;
			return "Voto registrado com sucesso!";
		}
		else {
			return "Voto não registrado";
		}
	}

	/**
	 * Lista os clientes que visitaram o restaurante.
	 * 
	 * Caso o prato preferido do cliente seja o mesmo prato do restaurante,
	 * essa informação é destacada na listagem.
	 * 
	 * @return lista de clientes em formato textual
	 */
	public List<String> listarClientes() {
		List<Cliente> listaClientes = new ArrayList<>(clientes);
		List<String> lista = new ArrayList<>();
		
		for(int i = 0; i < listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
					if(this.prato.equals(cliente.getPratoPreferido())) {
						lista.add("Cliente: " + cliente.getNome() + ", Prato preferido da casa");
					} else {
						lista.add("Cliente: " + cliente.getNome());
					}
		}
		return lista;
	}

	/**
	 * Registra uma nova visita ao restaurante.
	 * 
	 * A visita é adicionada ao livro de visitas e o cliente
	 * passa a fazer parte do conjunto de clientes do restaurante.
	 * 
	 * @param visita visita a ser registrada
	 */
	public void registrarVisita(Visita visita) {
		Cliente cliente = visita.getCliente();
		clientes.add(cliente);
		livroVisitas.add(visita);
	}

	/**
	 * Retorna todas as visitas registradas no restaurante.
	 * 
	 * @return lista de visitas
	 */
	public List<Visita> listarLivroVisitas(){
		return new ArrayList<>(livroVisitas);
	}

	/**
	 * Retorna as visitas mais recentes do restaurante.
	 * 
	 * @param numRecentes número de visitas recentes desejadas
	 * @return lista de visitas recentes
	 */
	public List<Visita> listarLivroVisitas(int numRecentes){
		List<Visita> lista = new ArrayList<>();
		
		int total = livroVisitas.size();
		int inicio = total - numRecentes;
		
		if (inicio < 0) {
		        inicio = 0;
		}
				
		for (int i = inicio; i < total; i++ ) {
			lista.add(livroVisitas.get(i));
		}
		
		return lista;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	/**
	 * Compara dois restaurantes com base no nome.
	 * 
	 * @param obj objeto a ser comparado
	 * @return true se os restaurantes possuem o mesmo nome
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		return Objects.equals(nome, other.nome);
	}

	/**
	 * Retorna uma representação textual do restaurante.
	 * 
	 * @return string com nome, prato e quantidade de votos
	 */
	@Override
	public String toString() {
	    return "Restaurante: " + nome +
	           " | Prato: " + prato +
	           " | Votos: " + votos;
	}
}
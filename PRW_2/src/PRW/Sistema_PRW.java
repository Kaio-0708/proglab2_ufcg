package PRW;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Classe responsável por gerenciar o sistema PRW.
 * 
 * Controla o cadastro de clientes e restaurantes, o registro de visitas,
 * votos em pratos preferidos e consultas sobre visitas e preferências.
 */
public class Sistema_PRW {
	
   private HashMap<String, Restaurante> restaurantes;
   private HashMap<String, Cliente> clientes;

   /**
	 * Constrói o sistema PRW inicializando as estruturas
	 * de armazenamento de clientes e restaurantes.
	 */	
   public Sistema_PRW() {
	   this.clientes = new HashMap<>();
	   this.restaurantes = new HashMap<>();
   }

	/**
	 * Adiciona um restaurante ao sistema.
	 * 
	 * @param nome  nome do restaurante
	 * @param prato prato principal do restaurante
	 * @return {@code true} se o restaurante for adicionado com sucesso,
	 *         {@code false} se já existir ou o limite for atingido
	 * @throws IllegalArgumentException se o nome estiver vazio
	 */
    public boolean adicionarRestaurante(String nome, String prato) {
    	if ("".equals(nome.trim())) {
    		throw new IllegalArgumentException("Nome vazio");
    	}
    	
    	Restaurante restaurante = new Restaurante(nome, prato);
    	if(this.restaurantes.containsKey(nome) || this.restaurantes.size() == 50) {
    		return false;
    	}
    	this.restaurantes.put(nome, restaurante);
    	return true;
    }

   /**
	 * Adiciona um cliente ao sistema.
	 * 
	 * @param nome  nome do cliente
	 * @param email email do cliente
	 * @return {@code true} se o cliente for adicionado com sucesso,
	 *         {@code false} se já existir ou o limite for atingido
	 * @throws IllegalArgumentException se o email estiver vazio
	 */	
   public boolean adicionarCliente(String nome, String email) {
	   if ("".equals(email.trim())) {
			throw new IllegalArgumentException("Email vazio");
	   }
	   
	   Cliente cliente = new Cliente(nome, email);
	   if(this.clientes.containsKey(email) || this.clientes.size() == 50) {
		   return false;
	   }
	   this.clientes.put(email, cliente);
	   return true;
   }

   /**
	 * Registra uma visita de um cliente a um restaurante, sem comentário.
	 * 
	 * @param emailCliente    email do cliente
	 * @param nomeRestaurante nome do restaurante
	 * @throws IllegalArgumentException se o cliente ou restaurante não existir
	 */
   public void visitarRestaurante(String emailCliente, String nomeRestaurante) {
	   Restaurante restaurante = this.restaurantes.get(nomeRestaurante);
	   Cliente cliente = this.clientes.get(emailCliente);
	   
	   if (restaurante == null || cliente == null) {
		   throw new IllegalArgumentException("Restaurante ou cliente não encontrado!");
	    }
	   	   
	   LocalDate data = LocalDate.now();
	   Visita visita = new Visita(data, cliente, restaurante);
	   restaurante.registrarVisita(visita);
   }

   /**
	 * Registra uma visita de um cliente a um restaurante com comentário.
	 * 
	 * @param emailCliente    email do cliente
	 * @param nomeRestaurante nome do restaurante
	 * @param comentario      comentário sobre a visita
	 * @throws IllegalArgumentException se o cliente ou restaurante não existir
	 */	
   public void visitarRestaurante(String emailCliente, String nomeRestaurante, String comentario) {
	   Restaurante restaurante = this.restaurantes.get(nomeRestaurante);
	   Cliente cliente = this.clientes.get(emailCliente);
	   
	   if (restaurante == null || cliente == null) {
		   throw new IllegalArgumentException("Restaurante ou cliente não encontrado!");
	    }
	   
	   LocalDate data = LocalDate.now();
	   Visita visita = new Visita(data, cliente, restaurante, comentario);
	   restaurante.registrarVisita(visita);
   }

	/**
	 * Retorna o gasto total realizado por um cliente.
	 * 
	 * @param emailCliente email do cliente
	 * @return valor total gasto pelo cliente
	 * @throws IllegalArgumentException se o cliente não existir
	 */
    public double obtemGastoCliente(String emailCliente) {
    	Cliente cliente = this.clientes.get(emailCliente);
    	
    	if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
    	
    	return cliente.getGastoRealizado();
    }

	/**
	 * Lista os nomes dos clientes que visitaram um restaurante.
	 * 
	 * @param nomeRestaurante nome do restaurante
	 * @return array de nomes dos clientes
	 * @throws IllegalArgumentException se o restaurante não existir
	 */
    public String[] listarClientesRestaurante(String nomeRestaurante) {
    	Restaurante restaurante = this.restaurantes.get(nomeRestaurante);
    	
    	if(restaurante == null) {
    		throw new IllegalArgumentException("Restaunte não encontrador");
    	}
    	
    	HashSet<Cliente> clientesSet = restaurante.getClientes();
    	Cliente[] clientesArray = clientesSet.toArray(new Cliente[0]);
    	String [] lista = new String[clientesSet.size()];
    	
    	for(int i = 0; i < clientesArray.length; i++) {
    		lista[i] = clientesArray[i].getNome();
    	}
    	
    	return lista;
    }

	/**
	 * Registra o voto de um cliente no prato preferido de um restaurante.
	 * Caso o cliente ainda não tenha visitado o restaurante,
	 * a visita é registrada automaticamente.
	 * 
	 * @param emailCliente    email do cliente
	 * @param nomeRestaurante nome do restaurante
	 * @return mensagem indicando o resultado do voto
	 * @throws IllegalArgumentException se o cliente ou restaurante não existir
	 */
    public String votarPratoPreferido(String emailCliente, String nomeRestaurante) {
    	Restaurante restaurante = this.restaurantes.get(nomeRestaurante);
    	Cliente cliente = this.clientes.get(emailCliente);
    	
    	if (restaurante == null || cliente == null) {
 		   throw new IllegalArgumentException("Restaurante ou cliente não encontrado!");
 	    }
    	
    	if(!restaurante.getClientes().contains(cliente)) {
    		Visita visita = new Visita(LocalDate.now(), cliente, restaurante);
    		restaurante.registrarVisita(visita);
    	}
    	
    	return restaurante.registrarVoto(cliente);
    }

	/**
	 * Retorna o melhor prato com base na quantidade de votos.
	 * 
	 * @return descrição do melhor prato e restaurante
	 * @throws IllegalArgumentException se não houver votos registrados
	 */
    public String melhorPrato(){
    	String melhorPrato = "";
    	String melhorRestaurante = "";
    	int votos = 0;
    	
    	List<Restaurante> lista = new ArrayList<>(this.restaurantes.values());
    	
    	for(int i = 0; i < lista.size(); i++) {
    		Restaurante valor = lista.get(i);
    		if(valor.getVotos() >= votos) {
    			votos = valor.getVotos();
    			melhorPrato = valor.getPrato();
    			melhorRestaurante = valor.getNome();
    		}
    	}
    	
    	if (votos == 0) {
   		   throw new IllegalArgumentException("Restaurante com 0 votos");
   	    }
    	
    	return "Melhor prato: " + melhorPrato + " Restaurante: " + melhorRestaurante;
    }

	/**
	 * Lista todas as visitas registradas de um restaurante.
	 * 
	 * @param nomeRestaurante nome do restaurante
	 * @return array de visitas em formato texto
	 * @throws IllegalArgumentException se o restaurante não existir
	 */
    public String[] listarLivroVisitas(String nomeRestaurante) {
    	Restaurante restaurante = this.restaurantes.get(nomeRestaurante);
    	
    	if (restaurante == null) {
            throw new IllegalArgumentException("Restaurante não encontrado!");
        }
    	
    	List<Visita> visitas = restaurante.listarLivroVisitas();
    	String[] lista = new String[visitas.size()];
    	
    	for(int i = 0; i < visitas.size(); i++) {
    		lista[i] = visitas.get(i).toString();
    	}
    	
    	return lista;
   }

	/**
	 * Lista as visitas mais recentes de um restaurante.
	 * 
	 * @param nomeRestaurante nome do restaurante
	 * @param num_recentes    número de visitas recentes desejadas
	 * @return array de visitas recentes em formato texto
	 * @throws IllegalArgumentException se o restaurante não existir ou
	 *                                  se o número solicitado for inválido
	 */
    public String[] listarLivroVisitas(String nomeRestaurante, int num_recentes) {
    	Restaurante restaurante = this.restaurantes.get(nomeRestaurante);
    	
    	if (restaurante == null) {
            throw new IllegalArgumentException("Restaurante não encontrado!");
        }
    	
		int total = restaurante.listarLivroVisitas().size();   	
    	if (num_recentes > total) {
            throw new IllegalArgumentException("num_recentes não pode ser mais que o total de visitas");
        }
    	
    	List<Visita> visitas = restaurante.listarLivroVisitas(num_recentes);
    	String[] lista = new String[visitas.size()];
    	
    	for(int i = 0; i < visitas.size(); i++) {
    		lista[i] = visitas.get(i).toString();
    	}
    	
    	return lista;
    	
    }
    
    /**
     * Retorna a lista de restaurantes cadastrados no sistema.
     * 
     * A lista retornada é uma cópia da coleção interna, evitando
     * a modificação direta dos dados do sistema.
     * 
     * @return lista de restaurantes cadastrados
     */
    public List<Restaurante> getRestaurantes() {
    	return new ArrayList<>(restaurantes.values());
    }

    /**
     * Retorna a lista de clientes cadastrados no sistema.
     * 
     * A lista retornada é uma cópia da coleção interna, evitando
     * a modificação direta dos dados do sistema.
     * 
     * @return lista de clientes cadastrados
     */
    public List<Cliente> getClientes() {
    	return new ArrayList<>(clientes.values());
    }

    /**
     * Gera o relatório geral do sistema.
     * 
     * @return uma string contendo o relatório geral formatado
     */
    public String gerarRelatorioGeral() {
    	return new RelatorioGeral(this).gerar();
    }

    /**
     * Gera o relatório financeiro do sistema.
     * 
     * @return uma string contendo o relatório financeiro formatado
     */
    public String gerarRelatorioFinanceiro() {
    	return new RelatorioFinanceiro(this).gerar();
    }

    /**
     * Gera o relatório de engajamento do sistema.
     * 
     * @return uma string contendo o relatório de engajamento formatado
     */
    public String gerarRelatorioEngajamento() {
    	return new RelatorioEngajamento(this).gerar();
    }
}

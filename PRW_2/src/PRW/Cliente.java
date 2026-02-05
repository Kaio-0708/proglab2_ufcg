package PRW;

import java.util.Objects;
/**
 * Representa um cliente do sistema PRW.
 * 
 * Cada cliente possui nome, email, um prato preferido e o total de gastos
 * realizados no sistema. O email é usado como identificador único do cliente.
 */
public class Cliente {
	private String nome;
	private String email;
	private String pratoPreferido;
	private double gastoRealizado;

	/**
	 * Constrói um novo cliente com nome e email informados.
	 * 
	 * O prato preferido é inicializado como "Prato preferido não definido"
	 * e o gasto realizado inicia em zero.
	 * 
	 * @param nome  nome do cliente
	 * @param email email do cliente (identificador único)
	 */
	public Cliente(String nome, String email) {
		this.email = email;
		this.nome = nome;
		this.pratoPreferido = "Prato preferido não definido";
		this.gastoRealizado = 0.0;
	}

	/**
	 * Retorna o nome do cliente.
	 * 
	 * @return nome do cliente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o email do cliente.
	 * 
	 * @return email do cliente
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retorna o total de gastos realizados pelo cliente.
	 * 
	 * @return valor total gasto
	 */
	public double getGastoRealizado() {
		return gastoRealizado;
	}

	/**
	 * Retorna o prato preferido do cliente.
	 * 
	 * @return prato preferido
	 */
	public String getPratoPreferido() {
		return pratoPreferido;
	}

	/**
	 * Define o prato preferido do cliente.
	 * 
	 * @param pratoPreferido nome do prato preferido
	 */
	public void escolherPratoPreferido(String pratoPreferido) {
		this.pratoPreferido= pratoPreferido; 
	}

	/**
	 * Registra um novo gasto para o cliente, somando ao valor total já gasto.
	 * 
	 * @param valor valor do gasto a ser registrado
	 */
	public void registrarGasto(double valor) {
		this.gastoRealizado += valor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	/**
	 * Compara dois clientes com base no email.
	 * 
	 * @param obj objeto a ser comparado
	 * @return true se os clientes possuem o mesmo email, false caso contrário
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email);
	}

	/**
	 * Retorna uma representação textual do cliente.
	 * 
	 * @return string com nome do cliente e prato preferido
	 */
	@Override
	public String toString() {
		return "Cliente: " + this.nome + ", Prato Preferido: " + this.pratoPreferido;
	}
	
}
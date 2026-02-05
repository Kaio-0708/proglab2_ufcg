package PRW;

import java.time.LocalDate;

/**
 * Representa uma visita realizada por um cliente a um restaurante.
 * 
 * Uma visita contém a data em que ocorreu, o cliente que realizou a visita,
 * o restaurante visitado e, opcionalmente, um comentário sobre a experiência.
 */
public class Visita {
	private LocalDate data;
	private String comentario;
	private Cliente cliente;
	private Restaurante restaurante;

	/**
	 * Constrói uma visita sem comentário.
	 * 
	 * @param data        data da visita
	 * @param cliente     cliente que realizou a visita
	 * @param restaurante restaurante visitado
	 */
	public Visita(LocalDate data, Cliente cliente, Restaurante restaurante) {
		this.data = data;
		this.cliente = cliente;
		this.restaurante = restaurante;
	}

	/**
	 * Constrói uma visita com comentário.
	 * 
	 * @param data        data da visita
	 * @param cliente     cliente que realizou a visita
	 * @param restaurante restaurante visitado
	 * @param comentario  comentário sobre a visita
	 */
	public Visita(LocalDate data, Cliente cliente, Restaurante restaurante, String comentario) {
		this.data = data;
		this.cliente = cliente;
		this.restaurante = restaurante;
		this.comentario = comentario;
	}

	/**
	 * Retorna a data da visita.
	 * 
	 * @return data da visita
	 */
	public LocalDate getData() {
		return data;
	}

	/**
	 * Retorna o comentário da visita.
	 * 
	 * @return comentário da visita ou {@code null} se não houver
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Retorna o cliente que realizou a visita.
	 * 
	 * @return cliente da visita
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Retorna o restaurante visitado.
	 * 
	 * @return restaurante da visita
	 */
	public Restaurante getRestaurante() {
		return restaurante;
	}

	/**
	 * Retorna uma representação textual da visita,
	 * incluindo data, nome do cliente e comentário.
	 * 
	 * @return string representando a visita
	 */
	@Override
	public String toString() {
		return "Data: " + data + ", Cliente: " + cliente.getNome() + ", Comentário: " + comentario;
	}
}
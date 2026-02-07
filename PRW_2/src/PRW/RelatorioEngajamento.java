package PRW;

import java.util.HashMap;
import java.util.List;

/**
 * Representa um relatório de engajamento do sistema PRW.
 * 
 * O relatório de engajamento apresenta a quantidade de visitas
 * realizadas por cada cliente em cada restaurante, permitindo
 * analisar o nível de participação dos clientes no sistema.
 */
public class RelatorioEngajamento {

	/**
	 * Sistema principal que fornece os dados necessários
	 * para a geração do relatório de engajamento.
	 */
	private Sistema_PRW sistema;

	/**
	 * Constrói um relatório de engajamento a partir do sistema informado.
	 * 
	 * @param sistema sistema PRW que contém os dados de restaurantes,
	 *                clientes e visitas
	 */
	public RelatorioEngajamento(Sistema_PRW sistema) {
		this.sistema = sistema;
	}

	/**
	 * Gera o relatório de engajamento do sistema.
	 * 
	 * Para cada restaurante, o relatório identifica quantas visitas
	 * cada cliente realizou, exibindo o nome do cliente, o nome do
	 * restaurante e o total de visitas associadas.
	 * 
	 * @return uma string contendo o relatório de engajamento formatado
	 */
	public String gerar() {
		String resultado = "";

		List<Restaurante> restaurantes = sistema.getRestaurantes();

		/**
		 * Percorre todos os restaurantes do sistema
		 */
		for (int i = 0; i < restaurantes.size(); i++) {
			Restaurante restaurante = restaurantes.get(i);

			HashMap<Cliente, Integer> visitasPorCliente = new HashMap<>();
			List<Visita> visitas = restaurante.listarLivroVisitas();

			/**
			 * Conta o número de visitas de cada cliente no restaurante
			 */
			for (int j = 0; j < visitas.size(); j++) {
				Cliente cliente = visitas.get(j).getCliente();

				if (!visitasPorCliente.containsKey(cliente)) {
					visitasPorCliente.put(cliente, 1);
				} else {
					int qtd = visitasPorCliente.get(cliente);
					visitasPorCliente.put(cliente, qtd + 1);
				}
			}

			Cliente[] clientes = visitasPorCliente.keySet().toArray(new Cliente[0]);

			/**
			 * Monta o resultado do relatório para cada cliente
			 */
			for (int k = 0; k < clientes.length; k++) {
				Cliente c = clientes[k];

				resultado += "Cliente: " + c.getNome()
						  + " | Restaurante: " + restaurante.getNome()
						  + " | Visitas: " + visitasPorCliente.get(c) 
						  + "\n";
			}
		}

		return resultado;
	}
}
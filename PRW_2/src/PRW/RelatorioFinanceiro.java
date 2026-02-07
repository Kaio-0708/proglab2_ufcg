package PRW;

/**
 * Representa um relatório financeiro do sistema PRW.
 * 
 * O relatório financeiro reúne informações relacionadas à
 * receita gerada pelo evento, considerando o número de visitas
 * realizadas nos restaurantes e os gastos efetuados pelos clientes.
 */
public class RelatorioFinanceiro {

	/**
	 * Sistema principal que fornece os dados necessários
	 * para a geração do relatório financeiro.
	 */
	private Sistema_PRW sistema;

	/**
	 * Constrói um relatório financeiro a partir do sistema informado.
	 * 
	 * @param sistema sistema PRW que contém os dados de restaurantes e clientes
	 */
	public RelatorioFinanceiro(Sistema_PRW sistema) {
		this.sistema = sistema;
	}

	/**
	 * Gera o relatório financeiro do sistema.
	 * 
	 * O relatório apresenta:
	 * <ul>
	 *   <li>Receita total do evento</li>
	 *   <li>Média de receita por restaurante</li>
	 *   <li>Média de gastos por cliente</li>
	 * </ul>
	 * 
	 * @return uma string contendo o relatório financeiro formatado
	 */
	public String gerar() {
		int totalVisitas = 0;
		double totalGastoClientes = 0;

		/**
		 *  Soma o total de visitas realizadas em todos os restaurantes
		 */
		for (int i = 0; i < sistema.getRestaurantes().size(); i++) {
			Restaurante r = sistema.getRestaurantes().get(i);
			totalVisitas += r.getLivroVisitas().size();
		}

		/**
		 * Soma o total gasto por todos os clientes
		 */
		for (int i = 0; i < sistema.getClientes().size(); i++) {
			Cliente c = sistema.getClientes().get(i);
			totalGastoClientes += c.getGastoRealizado();
		}

		double receitaTotal = totalVisitas * 89.90;
		double mediaReceitaRestaurante = 0;
		double mediaGastoCliente = 0;

		/**
		 * Calcula a média de receita por restaurante
		 */
		if (sistema.getRestaurantes().size() > 0) {
			mediaReceitaRestaurante = receitaTotal / (double) sistema.getRestaurantes().size();
		}

		/**
		 * Calcula a média de gastos por cliente
		 */
		if (sistema.getClientes().size() > 0) {
			mediaGastoCliente = totalGastoClientes / (double) sistema.getClientes().size();
		}
        
		/**
		 * Retorna o relatório formatado
		 */
		return "Relatório Financeiro\n"
				+ "Receita total do evento: R$ " + receitaTotal + "\n"
				+ "Média de receita por restaurante: R$ " + mediaReceitaRestaurante + "\n"
				+ "Média de gastos por cliente: R$ " + mediaGastoCliente;
	}
}
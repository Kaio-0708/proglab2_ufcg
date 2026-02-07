package PRW;

/**
 * Representa um relatório geral do sistema PRW.
 * 
 * O relatório reúne informações consolidadas sobre os restaurantes
 * e clientes participantes do sistema, incluindo médias de visitas,
 * quantidade de participantes e o restaurante mais visitado.
 */
public class RelatorioGeral {

	/**
	 * Sistema principal que fornece os dados necessários
	 * para a geração do relatório.
	 */
	private Sistema_PRW sistema;

	/**
	 * Constrói um relatório geral a partir do sistema informado.
	 * 
	 * @param sistema sistema PRW que contém restaurantes e clientes
	 */
	public RelatorioGeral(Sistema_PRW sistema) {
		this.sistema = sistema;
	}

	/**
	 * Gera o relatório geral do sistema.
	 * 
	 * O relatório inclui:
	 * <ul>
	 *   <li>Quantidade de restaurantes participantes</li>
	 *   <li>Quantidade de clientes participantes</li>
	 *   <li>Média de visitantes por restaurante</li>
	 *   <li>Média de visitas por restaurante</li>
	 *   <li>Nome do restaurante mais visitado</li>
	 * </ul>
	 * 
	 * @return uma string contendo o relatório geral formatado
	 */
	public String gerar() {
		int qntRestauranteParticipante = sistema.getRestaurantes().size();
		int qntClienteParticipante = sistema.getClientes().size();
		int somaVisitante = 0;
		int somaVisita = 0;
		int maiorNumVisitas = 0;
		Restaurante maisVisitado = null;

		/**
		 * Percorre a lista de restaurantes para calcular
		 * o total de visitantes, visitas e identificar
		 * o restaurante mais visitado.
		 */
		for (int i = 0; i < sistema.getRestaurantes().size(); i++) {
			Restaurante r = sistema.getRestaurantes().get(i);

			somaVisitante += r.getClientes().size();
			somaVisita += r.getLivroVisitas().size();

			if (r.getLivroVisitas().size() > maiorNumVisitas) {
				maiorNumVisitas = r.getLivroVisitas().size();
				maisVisitado = r;
			}
		}

		double mediaVisitantes = 0;
		double mediaVisitas = 0;

		/**
		 * Calcula as médias somente se houver
		 * restaurantes participantes no sistema.
		 */
		if (qntRestauranteParticipante > 0) {
			mediaVisitantes = somaVisitante / (double) qntRestauranteParticipante;
			mediaVisitas = somaVisita / (double) qntRestauranteParticipante;
		}

		String nomeMaisVisitado = "Nenhum";
		if (maisVisitado != null) {
			nomeMaisVisitado = maisVisitado.getNome();
		}
        
		/**
		 * Retorna o relatório formatado
		 */
		return "Relatório Geral\n"
				+ "Restaurantes participantes: " + qntRestauranteParticipante + "\n"
				+ "Clientes participantes: " + qntClienteParticipante + "\n"
				+ "Média de visitantes por restaurante: " + mediaVisitantes + "\n"
				+ "Média de visitas por restaurante: " + mediaVisitas + "\n"
				+ "Restaurante mais visitado: " + nomeMaisVisitado;
	}
}
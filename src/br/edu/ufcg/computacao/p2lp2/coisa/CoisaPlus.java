package br.edu.ufcg.computacao.p2lp2.coisa;

public class CoisaPlus {
	
	public static void main(String[] args) {
		RegistroResumos registro = new RegistroResumos(5);
		
		registro.adiciona("Python", "Uma linguaguem de alto nível.");
		registro.adiciona("Tipos", "Tipos de variáveis incluem int, double e String.");
		registro.adiciona("Treze", "Mais que um time!");
		registro.adiciona("Construtores", "Construtores inicializam objetos com valores padrões.");
		
		String [] resultados = registro.busca("UM");
		
		System.out.println("Temas encontrados para a busca 'UM': ");
		for (int i =0; i <resultados.length; i++) {
			String tema = resultados[i];
			System.out.println("- " + tema);
		}
	}
}

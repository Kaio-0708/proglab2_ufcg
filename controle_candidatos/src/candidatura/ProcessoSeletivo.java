package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {
	public static void main(String [] args) {
		System.out.println("Processo Seletivo");
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		for(String candidato: candidatos) {
			entrandoContato(candidato);
		}
	}
	
	public static void entrandoContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando)
				tentativasRealizadas ++;
			else
				System.out.println("CONTATO REALIZADO COM SUCESSO");
		} while(continuarTentando && tentativasRealizadas < 3);
		    if(atendeu)
		    	System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas);
		    else
		    	System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NÚMERO MÁXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADAS ");		    	
	}
	
	public static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	public static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		System.out.println("imprimindo a lista de cadidatos informando o indice do elemento");
		
		for(int indice = 0; indice < candidatos.length; indice ++) {
			System.out.println("O candidato de n " + (indice+1) + " é o " + candidatos[indice]);
		}
		
		System.out.println("Forma abrevida de interação for each");
		
		for(String candidato: candidatos) {
			System.out.println("O candidato selecionado foi " + candidato);
		}
		
	}
	
	public static void selecaoCandidato () {
	    String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
	    
	    int candidatosSelecionados = 0;
	    int candidatoAtual = 0;
	    double salarioBase = 2000.0;
	    while(candidatosSelecionados < 5 & candidatoAtual < candidatos.length) {
	    	String candidato = candidatos[candidatoAtual];
	    	double salarioPretendido = valorPretendido();
	    	
	    	System.out.println("O candidato " + candidato + " Solicitou este valor de salario" + salarioPretendido);
	    	if(salarioBase >= salarioPretendido) {
	    		System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
	    		candidatosSelecionados ++;
	    	}
	    	candidatoAtual ++;
	    }
	}
	
	public static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	public static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido){
			System.out.println("LIGAR PARA O CANDIDATO");
		} else if(salarioBase == salarioPretendido)
			System.out.println("LIGAR PARA O CANDIDATO COM A CONTRAPROPOSTA");
	    else {
			System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATO");
		}
	}
}

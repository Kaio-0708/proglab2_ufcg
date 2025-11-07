package robeta;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String MENU = "---\n" +
		                    "1 - exibe bateria;\n" +
				            "2 - troca bateria;\n" +
		                    "3 - exibe robo;\n" +
				            "4 - falar;\n" +
		                    "5 - falar aleatorio;\n" +
				            "6 - sair\n" ;
		
		final int EXIBIR_BATERIA = 1;
		final int TROCAR_BATERIA = 2;
		final int EXIBIR_ROBO = 3;
		final int FALAR = 4;
		final int FALAR_ALEATORIO = 5;
		final int SAIR = 6;
		
		int op;
		RoBeta robo = new RoBeta(30, new String[] {"feijão", "arroz", "futebol"});
		
		do{
			System.out.println(MENU);
		    op = sc.nextInt();
		    switch(op) {
		    case EXIBIR_BATERIA:
		    	exibirBateria(robo);
		    	break;
		    case TROCAR_BATERIA:
		    	trocarBateria(robo, sc);
		    	break;
		    case EXIBIR_ROBO:
		    	exibirRobo(robo);
		    	break;
		    case FALAR:
		    	falar(robo, sc);
		    	break;
		    case FALAR_ALEATORIO:
		    	falarAleatorio(robo);
		    	break;
		    case SAIR:
		    	System.out.println("Saindo");
		    default:
		    	System.out.println("Opção inválida.");
		    }
		} while(op!=SAIR);
	}
		private static void trocarBateria(RoBeta robo, Scanner sc) {
			System.out.println("Qual o novo valor da bateria?");
			robo.setBateria(sc.nextInt());
		}
		
		private static void falar(RoBeta robo, Scanner sc) {
			System.out.println("Qual a ordem da palavra?");
			System.out.println("Falando...");
			System.out.println(robo.falar(sc.nextInt()));
		}
		
		private static void falarAleatorio(RoBeta robo) {
			System.out.println("Falando...");
			System.out.println(robo.falar());
			
		}

		private static void exibirRobo(RoBeta robo) {
			System.out.println(robo.exibeRobo());
			
		}

		private static void exibirBateria(RoBeta robo) {
			System.out.println("Bateria atual: " + robo.getBateria());	
		}
}

package jogo_bicho;
import java.util.*;

public class jogo {
    public static String[] bichos = {"Avestruz", "Águia","Burro","Borboleta","Cachorro","Cabra", "Carneiro","Camelo", "Cobra", "Coelho","Cavalo", "Elefante", "Galo", "Gato","Jacaré", "Leão", "Macaco","Porco", "Pavão","Peru","Touro","Tigre","Urso","Veado","Vaca"};
    public static final int TAMANHO = 5;
    
    public static void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
    	int [] cartela = new int[TAMANHO];
    	fazAposta(cartela, sc);
    	System.out.println();
    	Arrays.sort(cartela);
    	imprimeAposta(cartela);
    	System.out.println();
    	int numeroSorteado = sorteiaBicho();
    	String resultado = comparaAposta(cartela, numeroSorteado);
    	System.out.println(numeroSorteado);
    	System.out.println(resultado);
    	sc.close();
    }
    
    public static String pegaBicho(int numero) {
    	if(numero > 0 && numero <= 25){
    		return bichos[numero - 1];
    	} else {
    		return "Número inválido";
    	}
    }
    
    public static void fazAposta(int [] cartela, Scanner sc) {
    	int i = 0;
    	while (i < TAMANHO) {
    	    System.out.println();
    	    int numero = sc.nextInt();
    	    if(numero >= 1 && numero <= 25) {
    	    	cartela[i] = numero;
    	    	i ++;}
    	    }   	
    }
      
    public static void imprimeAposta(int [] cartela) {
    	for (int j = 0; j < cartela.length; j++) {
    		System.out.println(cartela[j] + " " + pegaBicho(cartela[j]));
    		
    	}
    }
    
    public static int sorteiaBicho() {
    	Random rd = new Random();
    	return rd.nextInt(25) + 1;
    }
    
    public static String comparaAposta( int [] cartela, int numeroSorteado) {
    	for (int sorte = 0; sorte < cartela.length; sorte ++) {
    		if(cartela[sorte] == numeroSorteado) {
    			return "Parabéns, você ganhou!";
    		}    		
    	}
    	return "Infelizemnte, você não ganhou!";
    }
}

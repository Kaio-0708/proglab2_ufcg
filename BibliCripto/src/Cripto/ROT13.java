package Cripto;

public class ROT13 implements Criptografia{
	@Override
	public String criptografar(String texto) {
		
		String resultado = "";
		
		for(int i = 0; i < texto.length(); i++) {
			char letra = texto.charAt(i);
			
			if(letra >= 'a' && letra <= 'z') {
				letra = (char) (letra + 13);
				
				if(letra > 'z') {
					letra = (char) (letra - 26);
				}
			}
			resultado = resultado + letra;
		}
		
		return resultado;
	}
}
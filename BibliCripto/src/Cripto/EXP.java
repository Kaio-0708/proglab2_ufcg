package Cripto;

public class EXP implements Criptografia{
	@Override
	public String criptografar(String texto) {
		String resultado = "";
		
		for(int i = 0; i < texto.length(); i++) {
			char letra = texto.charAt(i);
			resultado = resultado + letra + letra;
		}
		return resultado;
	}
}

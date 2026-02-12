package Cripto;

public class L33T implements Criptografia{
	@Override
	public String criptografar(String texto) {
		String resultado = "";
		
		for(int i = 0; i < texto.length(); i++) {
			char letra = texto.charAt(i);
			
			if(letra == 'a') {
				resultado += "4";
			}else if(letra == 'm') {
				resultado += "|\\/|";
			}else if(letra == 't') {
				resultado += "+";
			}else if(letra == 'e') {
				resultado += "3";
			}else if(letra == 'u') {
				resultado += "|_|";
			}else if(letra == 's') {
				resultado += "5";
			}else {
				resultado += letra;
			}
	}
		return resultado;
	}
}

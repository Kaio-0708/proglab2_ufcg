package Cripto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BibliotecaCriptoTeste {

	private BibliotecaCripto biblioteca;
	
	@BeforeEach
	void setUp() {
		biblioteca = new BibliotecaCripto();
	}
	
	@Test 
	void deveCriptografar() {
		String resultado = biblioteca.criptografar("abc");
		
		assertEquals("nop", resultado);
	}
	
	
	@Test
	void deveMudarParaEXP() {
		biblioteca.configurarAlgoritmo("EXP");
		
		String resultado = biblioteca.criptografar("abc");
		
		assertEquals("aabbcc", resultado);
	}
	
	@Test
	void deveMudarParaL33T() {
		biblioteca.configurarAlgoritmo("L33T");
		
		String resultado = biblioteca.criptografar("matheus");
		
		assertEquals("|\\/|4+h3|_|5", resultado);
	}
	
	@Test
	void deveMudarParaROT13() {
		biblioteca.configurarAlgoritmo("ROT13");
		
		String resultado = biblioteca.criptografar("aj");
		
		assertEquals("nw", resultado);
		
	}
}

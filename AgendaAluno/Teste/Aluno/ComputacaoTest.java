package Aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputacaoTest {

	private Computacao computacao;
	
	@BeforeEach
	void setUp() {
		computacao = new Computacao("Robotica", "robotica com IA", "0000", 10);
	}
    
	@Test
	void calcularPontuacao() {
		int resultado = computacao.calcularPontuacao();
		
		assertEquals(2, resultado);
	}
	
	@Test
	void naoCalcularPontuacao() {
		int resultado = computacao.calcularPontuacao();
		
		assertNotEquals(3, resultado);
	}
}

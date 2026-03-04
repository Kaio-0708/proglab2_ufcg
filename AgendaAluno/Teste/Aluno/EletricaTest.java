package Aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EletricaTest {

	private Eletrica eletrica;
	
    @BeforeEach
    void setUp() {
    	eletrica = new Eletrica("Robotica", "robotica com IA", "0000", 10, 20, true);
    }
    
    @Test
    void calcularPontuacaoComCertificado() {
    	int resultado = eletrica.calcularPontuacao();
    	
    	assertEquals(30, resultado);
    }
    
    @Test
    void naoCalcularPontuacaoComCertificado() {
    	int resultado = eletrica.calcularPontuacao();
    	
    	assertNotEquals(20, resultado);
    }
    
    @Test
    void calcularPontuacaoSemCertificado() {
    	eletrica = new Eletrica("Robotica", "robotica com IA", "0000", 10, 20, false);
    	
    	int resultado = eletrica.calcularPontuacao();
    	
    	assertEquals(20, resultado);
    }
}

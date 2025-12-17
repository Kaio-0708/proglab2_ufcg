package RB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdemDeServicoTest {

	private OrdemDeServico os;
	
	@BeforeEach
	void prepararMudarStatus() {
		os = new OrdemDeServico("Kaio Vitor", "111111111", "calca");
	}
	
	@Test
	void alterarStatusAndamento() {
		os.mudarStatus("Em andamento");
		assertEquals("Em andamento", os.getStatus());
	}
	
	@Test
	void alterarStatusConcluido() {
		os.mudarStatus("Concluida");
		assertEquals("Concluida", os.getStatus());
	}
	
	@Test
	void alterarStatusNaoIniciada() {
		os.mudarStatus("Não iniciada");
		assertEquals("Não iniciada", os.getStatus());
	}

}

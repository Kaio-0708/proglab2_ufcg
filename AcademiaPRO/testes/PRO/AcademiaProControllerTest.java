package PRO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AcademiaProControllerTest {

	private AcademiaProController academia;
	
	@BeforeEach
	void setUp() {
		academia = new AcademiaProController();
	}
	
	@Test
	void listarAlunoEmOrdemDecrescente() {
		academia.cadastrarAluno("josé", "00000000000");
		academia.cadastrarAluno("mario", "11111111111");
		
		int treino1 = academia.cadastrarTreinoCardio("jose", 2, 5);
		int treino2 = academia.cadastrarTreinoFuncional("jose", 2, 5, 10);
		
		academia.inscreverAlunoEmTreino("11111111111", treino2);
		academia.inscreverAlunoEmTreino("00000000000", treino1);
		
		String[] resultado = academia.listarAlunos();
		
		assertEquals("josé", resultado[0]);
		assertEquals("mario", resultado[1]);
	}
}

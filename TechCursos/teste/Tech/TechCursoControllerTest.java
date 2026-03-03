package Tech;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TechCursoControllerTest {

	private TechCursoController tech;
	
	@BeforeEach
	void setUp() {
		tech = new TechCursoController();
	}
	
	@Test
	void develistaremOrdemCrescente() {
		tech.cadastrarAluno("kaio", "01");
		tech.cadastrarAluno("mariana", "02");
		
		int id1 = tech.cadastrarCursoLivre("Java", 10, 10);
		int id2 = tech.cadastrarBootcamp("Python", 10, 10);
		
		tech.matricularAluno("01", id1);
		tech.matricularAluno("02", id2);
		
		String[] resultado = tech.listarAlunos();
		
		assertEquals("01", resultado[0]);
		assertEquals("02", resultado[1]);
	}
	
	@Test
	void listaremOrdemCrescenteEmTodosCursos() {
		tech.cadastrarAluno("kaio", "01");
		tech.cadastrarAluno("mariana", "02");
		tech.cadastrarAluno("manu", "03");
		tech.cadastrarAluno("juci", "04");
		
		int id1 = tech.cadastrarCursoLivre("Java", 10, 10);
		int id2 = tech.cadastrarBootcamp("Python", 10, 10);
		int id3 = tech.cadastrarCursoProfissionalizante("JS", 11, 10);
		int id4 = tech.cadastrarCursoProfissionalizante("TS", 15, 10);
		
		tech.matricularAluno("01", id1);
		tech.matricularAluno("02", id2);
		tech.matricularAluno("03", id3);
		tech.matricularAluno("04", id4);
		
		String[] resultado = tech.listarAlunos();
		
		assertEquals("01", resultado[0]);
		assertEquals("03", resultado[1]);
		assertEquals("04", resultado[2]);
		assertEquals("02", resultado[3]);
	}
	
	@Test
	void listarEmOrdemCrescenteExcetoCursoLivre() {
		tech.cadastrarAluno("kaio", "01");
		tech.cadastrarAluno("mariana", "02");
		tech.cadastrarAluno("manu", "03");
		tech.cadastrarAluno("juci", "04");
		
		int id1 = tech.cadastrarBootcamp("Java", 20, 10);
		int id2 = tech.cadastrarBootcamp("Python", 10, 10);
		int id3 = tech.cadastrarCursoProfissionalizante("JS", 11, 10);
		int id4 = tech.cadastrarCursoProfissionalizante("TS", 15, 10);
		
		tech.matricularAluno("01", id1);
		tech.matricularAluno("02", id2);
		tech.matricularAluno("03", id3);
		tech.matricularAluno("04", id4);
		
		String[] resultado = tech.listarAlunos();
		
		assertEquals("03", resultado[0]);
		assertEquals("04", resultado[1]);
		assertEquals("02", resultado[2]);
		assertEquals("01", resultado[3]);
	}
	
	@Test
	void validarDesempatePorNomeQuandoPontosIguais() {
		tech.cadastrarAluno("kaio", "01");
		tech.cadastrarAluno("mariana", "02");
		
		int id1 = tech.cadastrarCursoLivre("Java", 10, 10);
		int id2 = tech.cadastrarCursoLivre("Python", 10, 10);
		
		tech.matricularAluno("01", id1);
		tech.matricularAluno("02", id2);
		
		String[] resultado = tech.listarAlunos();
		
		assertEquals("01", resultado[0]);
		assertEquals("02", resultado[1]);
	}
	
	@Test
	void naoDeveValidarEmOrdemCrescente() {
		tech.cadastrarAluno("kaio", "01");
		tech.cadastrarAluno("mariana", "02");
		
		int id1 = tech.cadastrarCursoLivre("Java", 10, 10);
		int id2 = tech.cadastrarBootcamp("Python", 10, 10);
		
		tech.matricularAluno("01", id1);
		tech.matricularAluno("02", id2);
		
		String[] resultado = tech.listarAlunos();
		
		assertNotEquals("02", resultado[0]);
		assertNotEquals("01", resultado[1]);
	}
}

package Aluno;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleAlunoControllerTest {

	private ControleAlunoController aluno;
	
	@BeforeEach
	void setUp() {
		aluno = new ControleAlunoController();
	}
	
	@Test
	void listarEstudantesDescrecente() {
		aluno.cadastrarEstudante("Kaio", "kaio@gmail.com");
		aluno.cadastrarEstudante("Vitor", "vitor@gmail.com");
		aluno.cadastrarEstudante("Santos", "santos@gmail.com");
		aluno.cadastrarEstudante("Queiroz", "queiroz@gmail.com");
		
		int id1 = aluno.cadastrarComputacao("ic", "Introdução a Computação", "20/02/2000", 10);
		int id2 = aluno.cadastrarInformatica("if", "Introdução a Informática", "20/02/2000", 10, 20);
		int id3 = aluno.cadastrarEletrica("if", "Introdução a Informática", "20/02/2000", 10, 30, true);
		int id4 = aluno.cadastrarEletrica("if", "Introdução a Informática", "20/02/2000", 10, 25, false);
		
		aluno.inscreverEstudanteEmTurma("vitor@gmail.com", id4);
		aluno.inscreverEstudanteEmTurma("kaio@gmail.com", id3);
		aluno.inscreverEstudanteEmTurma("santos@gmail.com", id2);
		aluno.inscreverEstudanteEmTurma("queiroz@gmail.com", id1);
		
		String[] resultado = aluno.listarEstudantes();
		
		assertEquals("Kaio", resultado[0]);
		assertEquals("Vitor", resultado[1]);
		assertEquals("Santos", resultado[2]);
		assertEquals("Queiroz", resultado[3]);
	}
	
	@Test
	void listarEstudanteCrescente() {
		aluno.cadastrarEstudante("Kaio", "kaio@gmail.com");
		aluno.cadastrarEstudante("Vitor", "vitor@gmail.com");
		aluno.cadastrarEstudante("Santos", "santos@gmail.com");
		aluno.cadastrarEstudante("Queiroz", "queiroz@gmail.com");
		
		int id1 = aluno.cadastrarComputacao("ic", "Introdução a Computação", "20/02/2000", 10);
		int id2 = aluno.cadastrarInformatica("if", "Introdução a Informática", "20/02/2000", 10, 20);
		int id3 = aluno.cadastrarEletrica("if", "Introdução a Informática", "20/02/2000", 10, 30, true);
		int id4 = aluno.cadastrarEletrica("if", "Introdução a Informática", "20/02/2000", 10, 25, false);
		
		aluno.inscreverEstudanteEmTurma("vitor@gmail.com", id4);
		aluno.inscreverEstudanteEmTurma("kaio@gmail.com", id3);
		aluno.inscreverEstudanteEmTurma("santos@gmail.com", id2);
		aluno.inscreverEstudanteEmTurma("queiroz@gmail.com", id1);
		
		String[] resultado = aluno.listarEstudanteOrdemCrescente();
		
		assertEquals("Kaio", resultado[3]);
		assertEquals("Vitor", resultado[2]);
		assertEquals("Santos", resultado[1]);
		assertEquals("Queiroz", resultado[0]);
	}
	
	@Test
	void listarEstudanteNome() {
		aluno.cadastrarEstudante("Kaio", "kaio@gmail.com");
		aluno.cadastrarEstudante("Vitor", "vitor@gmail.com");
		aluno.cadastrarEstudante("Santos", "santos@gmail.com");
		aluno.cadastrarEstudante("Queiroz", "queiroz@gmail.com");
		
		String[] resultado = aluno.listarEstudanteNome();
		
		assertEquals("Kaio", resultado[0]);
		assertEquals("Vitor", resultado[3]);
		assertEquals("Santos", resultado[2]);
		assertEquals("Queiroz", resultado[1]);
	}
	
	@Test
	void listarEstudanteEmail() {
		aluno.cadastrarEstudante("Kaio", "kaio@gmail.com");
		aluno.cadastrarEstudante("Vitor", "vitor@gmail.com");
		aluno.cadastrarEstudante("Santos", "santos@gmail.com");
		aluno.cadastrarEstudante("Queiroz", "queiroz@gmail.com");
		
		String[] resultado = aluno.listarEstudanteEmail();
		
		assertEquals("kaio@gmail.com", resultado[0]);
		assertEquals("vitor@gmail.com", resultado[3]);
		assertEquals("santos@gmail.com", resultado[2]);
		assertEquals("queiroz@gmail.com", resultado[1]);
	}
}

package Agenda;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaFacilControllerTest {

	private AgendaFacilController agenda;
	
	@BeforeEach
	void setUp() {
		agenda = new AgendaFacilController();
	}
	
	@Test
	void listarEstudantesEmOrdemDecrescente() {
		agenda.cadastrarEstudante("Kaio", "kaio@gmail.com");
		agenda.cadastrarEstudante("Vitor", "vitor@gmail.com");
		
		int id1 = agenda.cadastrarPalestra("Java", "Básico", "20/01/2001", 10);
		int id2 = agenda.cadastrarOficinaAprendizagem("Java", "Básico", "20/01/2001", 10, 10, false);	
		
		agenda.inscreverParticipanteEmEvento("kaio@gmail.com", id1);
		agenda.inscreverParticipanteEmEvento("vitor@gmail.com", id2);
		
		String[] resultado = agenda.listarEstudantes();
		
		assertEquals("Kaio", resultado[1]);
		assertEquals("Vitor", resultado[0]);	
	}
	
	@Test
	void listarMultiplosEstudantesEmOrdemDecrescente() {
		agenda.cadastrarEstudante("Kaio", "kaio@gmail.com");
		agenda.cadastrarEstudante("Pedro", "pedro@gmail.com");
		agenda.cadastrarEstudante("Antonio", "antonio@gmail.com");
		agenda.cadastrarEstudante("Davi", "davi@gmail.com");
		agenda.cadastrarEstudante("Carlos", "carlos@gmail.com");
		
		
		int id1 = agenda.cadastrarPalestra("Java", "Básico", "20/01/2001", 10);
		int id2 = agenda.cadastrarOficinaAprendizagem("Java", "Básico", "20/01/2001", 10, 10, false);
		int id3 = agenda.cadastrarOficinaAprendizagem("Java", "Básico", "20/01/2001", 10, 20, false);
		int id4 = agenda.cadastrarOficinaAprendizagem("Java", "Básico", "20/01/2001", 10, 30, false);
		int id5 = agenda.cadastrarOficinaAprendizagem("Java", "Básico", "20/01/2001", 10, 40, false);
		
		agenda.inscreverParticipanteEmEvento("kaio@gmail.com", id5);
		agenda.inscreverParticipanteEmEvento("pedro@gmail.com", id4);
		agenda.inscreverParticipanteEmEvento("antonio@gmail.com", id3);
		agenda.inscreverParticipanteEmEvento("davi@gmail.com", id2);
		agenda.inscreverParticipanteEmEvento("carlos@gmail.com", id1);
		
		String[] resultado = agenda.listarEstudantes();
		
		assertEquals("Kaio", resultado[0]);
		assertEquals("Pedro", resultado[1]);
		assertEquals("Antonio", resultado[2]);
		assertEquals("Davi", resultado[3]);
		assertEquals("Carlos", resultado[4]);
	}
	
	@Test
	void listarApenasUmEstudante() {
	    agenda.cadastrarEstudante("Kaio", "kaio@gmail.com");

	    String[] resultado = agenda.listarEstudantes();

	    assertEquals(1, resultado.length);
	    assertEquals("Kaio", resultado[0]);
	}
	
	@Test
	void listarEstudantesSemEstudantes() {
	    String[] resultado = agenda.listarEstudantes();
	    assertEquals(0, resultado.length);
	}
}

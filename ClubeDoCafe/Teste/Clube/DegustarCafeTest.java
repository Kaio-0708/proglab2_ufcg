package Clube;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DegustarCafeTest {

	private ClubeDoCafeController clube;
	
	@BeforeEach
	void setUp(){
		clube = new ClubeDoCafeController();
	}
	
	@Test
	void verificarDegustarCafe() {
		clube.cadastrarSocio("socio1", "kaio");
		clube.cadastrarCafeTradicional("autora", "Campina", 10, 10);
		
		boolean resultado = clube.degustar("socio1", "autora", 5, "muito bom");
		
		assertTrue(resultado);
	}
	
	@Test
	void naoVerificarDegustarCafe() {
		clube.cadastrarSocio("socio1", "kaio");
		clube.cadastrarCafeTradicional("autora", "Campina", 10, 10);
		
		assertThrows(IllegalArgumentException.class, () -> {
	        clube.degustar("socio2", "autora", 5, "muito bom");
	    });
	}
	
	@Test
	void verificarStatusInativoDegustarCafe() {
		clube.cadastrarSocio("socio1", "kaio");
		clube.cadastrarCafeTradicional("autora", "Campina", 10, 10);
		
		clube.mudarStatusSocio("socio1");
		
		boolean resultado = clube.degustar("socio1", "autora", 5, "muito bom");
		
		assertFalse(resultado);
		
	}	
}

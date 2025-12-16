package PRW;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Sistema_PRWTest {

	private Sistema_PRW prw;
	
	@BeforeEach
	void preparaVotar() {
		prw = new Sistema_PRW();
		prw.adicionarCliente("Kaio Vitor", "kaio@gmail.com");
		prw.adicionarRestaurante("Kaliotto", "macarrão");
	}
	
	@Test
	void naoDeveRegistrarVotoQuandoClienteNaoVisitouRestaurante() {
		String resultado = prw.votarPratoPreferido("kaio@gmail.com", "Kaliotto");
		
		assertEquals("Voto não registrado", resultado);
	}
	
	@Test
	void deveRegistrarVotoQuandoClienteVisitouRestaurante() {
		prw.visitarRestaurante("kaio@gmail.com", "Kaliotto");
		
        String resultado = prw.votarPratoPreferido("kaio@gmail.com", "Kaliotto");
		
		assertEquals("Voto registrado com sucesso!", resultado);
	}
	
	@Test
	void lancarExcecaoQuandoClienteNaoExiste() {
		assertThrows(IllegalArgumentException.class, () -> {
			prw.votarPratoPreferido("inexistente@email.com",
                    "Tio João");
		});
	}
	
	@Test
	void lancarExcecaoQuandoRestauranteNaoExiste() {
		assertThrows(IllegalArgumentException.class, () -> {
			prw.votarPratoPreferido("alex@email.com",
            "Restaurante Fantasma");
		
		});
	}
}

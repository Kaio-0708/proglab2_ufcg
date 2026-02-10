package PRW;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaPRWTeste {

	private Sistema_PRW sistema;
	
	@BeforeEach
	void setUp() {
		sistema = new Sistema_PRW();
	}
	
	@Test
    void deveGerarRelatorioGeralMínimo() {
    	sistema.adicionarCliente("José", "jose@gmail.com");
    	sistema.adicionarRestaurante("Galiotte", "Risotto");
    	sistema.visitarRestaurante("jose@gmail.com", "Galiotte");
    	
    	String relatorio = sistema.gerarRelatorioGeral();
    	
    	assertTrue(relatorio.contains("Restaurantes participantes: 1"));
    	assertTrue(relatorio.contains("Clientes participantes: 1"));
    	assertTrue(relatorio.contains("Restaurante mais visitado: Galiotte"));
    }
    
    @Test
    void deveGerarRelatorioGeral() {
    	sistema.adicionarCliente("José", "jose@gmail.com");
    	sistema.adicionarCliente("Jonatas", "jonatas@gmail.com");
    	sistema.adicionarCliente("Jo", "jo@gmail.com");
    	
    	sistema.adicionarRestaurante("Galiotte", "Risotto");
    	sistema.adicionarRestaurante("Coffee", "Coxinha");
    	
    	sistema.visitarRestaurante("jose@gmail.com", "Galiotte");
    	sistema.visitarRestaurante("jonatas@gmail.com", "Galiotte");
    	sistema.visitarRestaurante("jo@gmail.com", "Coffee");
    	
    	String relatorio = sistema.gerarRelatorioGeral();
    	
    	assertTrue(relatorio.contains("Restaurantes participantes: 2"));
    	assertTrue(relatorio.contains("Clientes participantes: 3"));
    	assertTrue(relatorio.contains("Média de visitantes por restaurante: 1.5"));
    	assertTrue(relatorio.contains("Média de visitas por restaurante: 1.5"));
    	assertTrue(relatorio.contains("Restaurante mais visitado: Galiotte"));
    }
    
    @Test
    void deveIndicarAusenciaDeDadosNoRelatorioGeral() {

        String relatorio = sistema.gerarRelatorioGeral();

        assertTrue(relatorio.contains("Restaurantes participantes: 0"));
        assertTrue(relatorio.contains("Clientes participantes: 0"));
        assertTrue(relatorio.contains("Média de visitantes por restaurante: 0.0"));
        assertTrue(relatorio.contains("Média de visitas por restaurante: 0.0"));
        assertTrue(relatorio.contains("Restaurante mais visitado: Nenhum"));
    }
    
    @Test
    void devegerarRelatorioFinanceiroSemDados() {

        String relatorio = sistema.gerarRelatorioFinanceiro();

        assertTrue(relatorio.contains("Receita total do evento: R$ 0.0"));
        assertTrue(relatorio.contains("Média de receita por restaurante: R$ 0.0"));
        assertTrue(relatorio.contains("Média de gastos por cliente: R$ 0.0"));
    }
    
    @Test
    void deveGerarRelatorioFinanceiroMinimo() {
    	sistema.adicionarCliente("José", "jose@gmail.com");
    	sistema.adicionarRestaurante("Galiotte", "Risotto");
    	sistema.visitarRestaurante("jose@gmail.com", "Galiotte");
    	
    	String relatorio = sistema.gerarRelatorioFinanceiro();
    	
    	assertTrue(relatorio.contains("Receita total do evento: R$ 89.9"));
    	assertTrue(relatorio.contains("Média de receita por restaurante: R$ 89.9"));
    }
    
    @Test
    void deveGerarRelatorioFinanceiro() {
    	sistema.adicionarCliente("José", "jose@gmail.com");
    	sistema.adicionarCliente("Jonatas", "jonatas@gmail.com");
    	sistema.adicionarCliente("Jo", "jo@gmail.com");
    	
    	sistema.adicionarRestaurante("Galiotte", "Risotto");
    	sistema.adicionarRestaurante("Coffee", "Coxinha");
    	
    	sistema.visitarRestaurante("jose@gmail.com", "Galiotte");
    	sistema.visitarRestaurante("jonatas@gmail.com", "Galiotte");
    	sistema.visitarRestaurante("jo@gmail.com", "Coffee");
    	
    	String relatorio = sistema.gerarRelatorioFinanceiro();
    	
    	assertTrue(relatorio.contains("Receita total do evento: R$ 269.7"));
    	assertTrue(relatorio.contains("Média de receita por restaurante: R$ 134.85"));
    	assertTrue(relatorio.contains("Média de gastos por cliente: R$ 89.9"));
    }
    
    @Test
    void deveGerarRelatorioEngajamentoSemDados() {
    	
    	String relatorio = sistema.gerarRelatorioEngajamento();
    	
    	assertEquals("", relatorio);
    }
    
    @Test
    void deveGerarRelatorioEngajamentoBasico() {
    	sistema.adicionarCliente("José", "jose@gmail.com");
    	sistema.adicionarRestaurante("Galiotte", "Risotto");
    	sistema.visitarRestaurante("jose@gmail.com", "Galiotte");
    	
    	String relatorio = sistema.gerarRelatorioEngajamento();
    	
    	assertTrue(relatorio.contains("Cliente: José"));
    	assertTrue(relatorio.contains("Restaurante: Galiotte"));
    	assertTrue(relatorio.contains("Visitas: 1"));  	
    }
    
    @Test
    void deveGerarRelatorioEngajamento() {
    	sistema.adicionarCliente("José", "jose@gmail.com");
    	sistema.adicionarCliente("Jonatas", "jonatas@gmail.com");
    	sistema.adicionarCliente("Jo", "jo@gmail.com");
    	
    	sistema.adicionarRestaurante("Galiotte", "Risotto");
    	sistema.adicionarRestaurante("Coffee", "Coxinha");
    	
    	sistema.visitarRestaurante("jose@gmail.com", "Galiotte");
    	sistema.visitarRestaurante("jonatas@gmail.com", "Galiotte");
    	sistema.visitarRestaurante("jo@gmail.com", "Coffee");
    	
    	String relatorio = sistema.gerarRelatorioEngajamento();
    	
        assertTrue(relatorio.contains("Cliente: José | Restaurante: Galiotte | Visitas: 1"));
        assertTrue(relatorio.contains("Cliente: Jonatas | Restaurante: Galiotte | Visitas: 1"));
        assertTrue(relatorio.contains("Cliente: Jo | Restaurante: Coffee | Visitas: 1"));
    }
	
}

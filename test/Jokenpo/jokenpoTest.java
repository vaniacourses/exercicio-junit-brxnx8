package Jokenpo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Classe para teste do jokenpo")
public class jokenpoTest {
	
	private Jokenpo jokenpo;
	
	@BeforeEach
	public void inicializa() {
		jokenpo = new Jokenpo();
	}
	
	@DisplayName("Testa se o retorna -1 para valores fora do permitido")
	@Test
	public void testRetornaMenosUm() {
		int resultado = jokenpo.jogar(4, 0);		
		Assertions.assertEquals(-1, resultado);		
	}
	
	@Test
	public void testVencedorJogadorUm() {
		int resultado1 = jokenpo.jogar(1, 2);
		int resultado2= jokenpo.jogar(2, 3);
		int resultado3 = jokenpo.jogar(3, 1);
		assertTrue(resultado1 == 1 && resultado2 == 1 && resultado3 == 1);
	}
	
	@Test
	public void testVencedorJogadorDois() {
		int resultado1 = jokenpo.jogar(2, 1);
		int resultado2= jokenpo.jogar(3, 2);
		int resultado3 = jokenpo.jogar(1, 3);
		assertTrue(resultado1 == 2 && resultado2 == 2 && resultado3 == 2);	
	}
	
	@Test
	public void testEmpate() {
		int resultado1 = jokenpo.jogar(1, 1);
		int resultado2= jokenpo.jogar(2, 2);
		int resultado3 = jokenpo.jogar(3, 3);
		assertTrue(resultado1 == 0 && resultado2 == 0 && resultado3 == 0);
	}


}

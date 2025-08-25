package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
    public void testSubtracao() {
        assertEquals(3, calc.subtracao(5, 2));
        assertEquals(-3, calc.subtracao(2, 5));
        assertEquals(0, calc.subtracao(5, 5));
    }

    @Test
    public void testMultiplicacao() {
        assertEquals(12, calc.multiplicacao(3, 4));
        assertEquals(0, calc.multiplicacao(5, 0));
        assertEquals(10, calc.multiplicacao(10, 1));
        assertEquals(-6, calc.multiplicacao(-2, 3));
    }

	@Test
    public void testDivisao() {
        assertEquals(1, calc.divisao(5, 5));
        assertEquals(5, calc.divisao(10, 2));
        assertEquals(1, calc.divisao(10, 10));
    }


}

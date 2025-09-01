package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculadoraTestGPT {

    // Testando a soma
    @Test
    public void testSoma() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.soma(2, 3), "A soma de 2 e 3 deve ser 5");
        assertEquals(0, calc.soma(0, 0), "A soma de 0 e 0 deve ser 0");
        assertEquals(-1, calc.soma(-2, 1), "A soma de -2 e 1 deve ser -1");
        assertEquals(-5, calc.soma(-2, -3), "A soma de -2 e -3 deve ser -5");
    }

    // Testando a subtração
    @Test
    public void testSubtracao() {
        Calculadora calc = new Calculadora();
        assertEquals(1, calc.subtracao(3, 2), "A subtração de 3 e 2 deve ser 1");
        assertEquals(0, calc.subtracao(0, 0), "A subtração de 0 e 0 deve ser 0");
        assertEquals(-3, calc.subtracao(-2, 1), "A subtração de -2 e 1 deve ser -3");
        assertEquals(1, calc.subtracao(-2, -3), "A subtração de -2 e -3 deve ser 1");
    }

    // Testando a multiplicação
    @Test
    public void testMultiplicacao() {
        Calculadora calc = new Calculadora();
        assertEquals(6, calc.multiplicacao(2, 3), "A multiplicação de 2 e 3 deve ser 6");
        assertEquals(0, calc.multiplicacao(0, 3), "A multiplicação de 0 e 3 deve ser 0");
        assertEquals(-6, calc.multiplicacao(-2, 3), "A multiplicação de -2 e 3 deve ser -6");
        assertEquals(6, calc.multiplicacao(-2, -3), "A multiplicação de -2 e -3 deve ser 6");
    }

    // Testando a divisão
    @Test
    public void testDivisao() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.divisao(6, 3), "A divisão de 6 por 3 deve ser 2");
        assertEquals(-2, calc.divisao(-6, 3), "A divisão de -6 por 3 deve ser -2");
        assertEquals(2, calc.divisao(6, -3), "A divisão de 6 por -3 deve ser -2");
        assertThrows(ArithmeticException.class, () -> calc.divisao(1, 0), "Divisão por zero deve lançar ArithmeticException");
    }

    // Testando a somatória
    @Test
    public void testSomatoria() {
        Calculadora calc = new Calculadora();
        assertEquals(15, calc.somatoria(5), "A somatória de 5 é 15");
        assertEquals(0, calc.somatoria(0), "A somatória de 0 é 0");
        assertEquals(10, calc.somatoria(4), "A somatória de 4 é 10");
        assertEquals(1, calc.somatoria(1), "A somatória de 1 é 1");
    }

    // Testando o método de verificar se o número é positivo
    @Test
    public void testEhPositivo() {
        Calculadora calc = new Calculadora();
        assertTrue(calc.ehPositivo(5), "5 deve ser positivo");
        assertTrue(calc.ehPositivo(0), "0 deve ser considerado positivo");
        assertFalse(calc.ehPositivo(-3), "-3 não deve ser positivo");
    }

    // Testando a comparação entre dois números
    @Test
    public void testCompara() {
        Calculadora calc = new Calculadora();
        assertEquals(0, calc.compara(3, 3), "3 é igual a 3");
        assertEquals(1, calc.compara(5, 3), "5 é maior que 3");
        assertEquals(-1, calc.compara(2, 4), "2 é menor que 4");
    }
}

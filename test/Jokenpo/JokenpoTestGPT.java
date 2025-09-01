package Jokenpo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JokenpoTestGPT {

    // Testando a jogada entre os dois jogadores
    @Test
    public void testJogarEmpate() {
        Jokenpo jokenpo = new Jokenpo();
        // Testando empate entre as escolhas
        assertEquals(0, jokenpo.jogar(1, 1), "Deve ser empate, pois ambos escolheram papel");
        assertEquals(0, jokenpo.jogar(2, 2), "Deve ser empate, pois ambos escolheram pedra");
        assertEquals(0, jokenpo.jogar(3, 3), "Deve ser empate, pois ambos escolheram tesoura");
    }

    // Testando vitória do jogador 1
    @Test
    public void testVitoriaJogador1() {
        Jokenpo jokenpo = new Jokenpo();
        // Jogador 1 escolhe papel (1) e jogador 2 escolhe pedra (2)
        assertEquals(1, jokenpo.jogar(1, 2), "Jogador 1 deve vencer, pois papel vence pedra");
        // Jogador 1 escolhe pedra (2) e jogador 2 escolhe tesoura (3)
        assertEquals(1, jokenpo.jogar(2, 3), "Jogador 1 deve vencer, pois pedra vence tesoura");
        // Jogador 1 escolhe tesoura (3) e jogador 2 escolhe papel (1)
        assertEquals(1, jokenpo.jogar(3, 1), "Jogador 1 deve vencer, pois tesoura vence papel");
    }

    // Testando vitória do jogador 2
    @Test
    public void testVitoriaJogador2() {
        Jokenpo jokenpo = new Jokenpo();
        // Jogador 1 escolhe pedra (2) e jogador 2 escolhe papel (1)
        assertEquals(2, jokenpo.jogar(2, 1), "Jogador 2 deve vencer, pois papel vence pedra");
        // Jogador 1 escolhe tesoura (3) e jogador 2 escolhe pedra (2)
        assertEquals(2, jokenpo.jogar(3, 2), "Jogador 2 deve vencer, pois pedra vence tesoura");
        // Jogador 1 escolhe papel (1) e jogador 2 escolhe tesoura (3)
        assertEquals(2, jokenpo.jogar(1, 3), "Jogador 2 deve vencer, pois tesoura vence papel");
    }

    // Testando entradas inválidas
    @Test
    public void testEntradasInvalidas() {
        Jokenpo jokenpo = new Jokenpo();
        // Entradas fora do intervalo válido (1 a 3)
        assertEquals(-1, jokenpo.jogar(0, 1), "Deve retornar -1 para escolha inválida do jogador 1");
        assertEquals(-1, jokenpo.jogar(1, 0), "Deve retornar -1 para escolha inválida do jogador 2");
        assertEquals(-1, jokenpo.jogar(4, 1), "Deve retornar -1 para escolha inválida do jogador 1");
        assertEquals(-1, jokenpo.jogar(1, 4), "Deve retornar -1 para escolha inválida do jogador 2");
    }

    // Testando casos de empate com entradas válidas
    @Test
    public void testEmpateComEscolhaValida() {
        Jokenpo jokenpo = new Jokenpo();
        // Verificando empates válidos entre as escolhas
        assertEquals(0, jokenpo.jogar(1, 1), "Deve ser empate, ambos escolheram papel");
        assertEquals(0, jokenpo.jogar(2, 2), "Deve ser empate, ambos escolheram pedra");
        assertEquals(0, jokenpo.jogar(3, 3), "Deve ser empate, ambos escolheram tesoura");
    }
}

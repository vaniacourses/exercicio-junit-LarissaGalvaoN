package gpt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import GPT.GPT;

public class GPTTest {

    private GPT gpt = new GPT();
    
    @BeforeEach
    public void inicializa() {
        gpt = new GPT();
    }

    @Test
    @DisplayName("Empate quando ambos escolhem papel")
    void testaEmpatePapel() {
        assertEquals(0, gpt.jogar(1, 1));
    }

    @Test
    @DisplayName("Empate quando ambos escolhem pedra")
    void testaEmpatePedra() {
        assertEquals(0, gpt.jogar(2, 2));
    }

    @Test
    @DisplayName("Empate quando ambos escolhem tesoura")
    void testaEmpateTesoura() {
        assertEquals(0, gpt.jogar(3, 3));
    }

    @Test
    @DisplayName("Jogador 1 vence (papel cobre pedra)")
    void testaJogador1VencePapelPedra() {
        assertEquals(1, gpt.jogar(1, 2));
    }

    @Test
    @DisplayName("Jogador 1 vence (pedra quebra tesoura)")
    void testaJogador1VencePedraTesoura() {
        assertEquals(1, gpt.jogar(2, 3));
    }

    @Test
    @DisplayName("Jogador 1 vence (tesoura corta papel)")
    void testaJogador1VenceTesouraPapel() {
        assertEquals(1, gpt.jogar(3, 1));
    }

    @Test
    @DisplayName("Jogador 2 vence (papel cobre pedra)")
    void testaJogador2VencePapelPedra() {
        assertEquals(2, gpt.jogar(2, 1));
    }

    @Test
    @DisplayName("Jogador 2 vence (pedra quebra tesoura)")
    void testaJogador2VencePedraTesoura() {
        assertEquals(2, gpt.jogar(3, 2));
    }

    @Test
    @DisplayName("Jogador 2 vence (tesoura corta papel)")
    void testaJogador2VenceTesouraPapel() {
        assertEquals(2, gpt.jogar(1, 3));
    }

    @Test
    @DisplayName("Retorna -1 para jogada inválida do jogador 1")
    void testaJogadaInvalidaJogador1() {
        assertEquals(-1, gpt.jogar(0, 2));
        assertEquals(-1, gpt.jogar(4, 2));
    }

    @Test
    @DisplayName("Retorna -1 para jogada inválida do jogador 2")
    void testaJogadaInvalidaJogador2() {
        assertEquals(-1, gpt.jogar(2, 0));
        assertEquals(-1, gpt.jogar(3, 5));
    }
}

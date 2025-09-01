package jokenpo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jokenpo.Jokenpo;


public class JokenpoTest {
    private Jokenpo jokenpo;
    @BeforeEach
    public void inicializa() {
        jokenpo = new Jokenpo();
    }

    @DisplayName("Testa se jogador 1 ganha com papel > pedra")
    @Test
    public void testJogador1VenceComPapel() {
        int jogador1 = 1; 
        int jogador2 = 2; 
        int resultadoEsperado = 1;

        int resultado = jokenpo.jogar(jogador1, jogador2);

        Assertions.assertEquals(resultadoEsperado, resultado);
    }




    @DisplayName("Testa se jogador 2 ganha pedra > tesoura")
    @Test
    public void testJogador2VenceComPedra() {
        int jogador1 = 3; 
        int jogador2 = 2; 
        int resultadoEsperado = 2;

        int resultado = jokenpo.jogar(jogador1, jogador2);

        Assertions.assertEquals(resultadoEsperado, resultado);
    }

     @DisplayName("Testa se jogador 1 ganha tesoura > papel")
    @Test
    public void testJogador1VenceComTesoura() {
        int jogador1 = 3; 
        int jogador2 = 1; 
        int resultadoEsperado = 1;

        int resultado = jokenpo.jogar(jogador1, jogador2);

        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @DisplayName("Teste de Empate")
    @Test
    public void testEmpateComPapel() {
        int jogador1 = 1;
        int jogador2 = 1;
        int resultadoEsperado = 0;

        int resultado = jokenpo.jogar(jogador1, jogador2);

        Assertions.assertEquals(resultadoEsperado, resultado);
    }
   
    //testes de falha
    @DisplayName("Jogador 1 com opção inválida (maior que 3)")
    @Test
    public void testOpcaoInvalidaJogador1Maior() {
        int jogador1 = 4;
        int jogador2 = 1;
        int resultadoEsperado = -1;

        int resultado = jokenpo.jogar(jogador1, jogador2);

        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @DisplayName("Jogador 2 com opção inválida (menor que 1)")
    @Test
    public void testOpcaoInvalidaJogador2Menor() {
        int jogador1 = 1;
        int jogador2 = 0;
        int resultadoEsperado = -1;

        int resultado = jokenpo.jogar(jogador1, jogador2);

        Assertions.assertEquals(resultadoEsperado, resultado);
    }

    @DisplayName("Ambos os jogadores com opção inválida")
    @Test
    public void testOpcaoInvalidaAmbos() {
        int jogador1 = 1;
        int jogador2 = 0;
        int resultadoEsperado = -1;

        int resultado = jokenpo.jogar(jogador1, jogador2);

        Assertions.assertEquals(resultadoEsperado, resultado);
    }
}


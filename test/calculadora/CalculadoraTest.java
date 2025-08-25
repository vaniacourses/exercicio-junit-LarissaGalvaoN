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
	
	@DisplayName("Testa a soma de dois n�meros")
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

	@DisplayName("Testa a subtração de dois números positivos")
	@Test
	public void testSubtracaoDoisNumerosPositivos() {
		int subtracao = calc.subtracao(15, 5);		
		Assertions.assertEquals(10, subtracao);		
	}
	@DisplayName("Testa a subtração de dois números negativos")
	@Test
	public void testSubtracaoDoisNumerosNegativos() {
		int subtracao = calc.subtracao(15, -5);		
		Assertions.assertEquals(20, subtracao);		
	}
	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testSubMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(4, 5);		
		Assertions.assertEquals(20, multiplicacao);		
	}
	@DisplayName("Testa a multiplicação por zero")
	@Test
	public void testSubMultiplicacaoporZero() {
		int multiplicacao = calc.multiplicacao(0, 5);		
		Assertions.assertEquals(0, multiplicacao);		
	}


	@DisplayName("Testa o somatório de um número")
	@Test
	public void testSomatorio() {
		int somatorio = calc.somatoria(5);		
		Assertions.assertEquals(15, somatorio);		
	}

	@DisplayName("Testa se é positivo com um número positivo")
	@Test
	public void testPositivoComNumeroPositivo() {
		boolean positivo = calc.ehPositivo(5);		
		Assertions.assertEquals(true, positivo);		
	}

	@DisplayName("Testa se é positivo com um número negativo")
	@Test
	public void testPositivoComNumeroNegativo() {
		boolean negativo = calc.ehPositivo(-67);		
		Assertions.assertEquals(false, negativo);		
	}
	
}

package carrinho;

import carrinho.Carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;


@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {
	private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
    }

    @DisplayName("Testa se o carrinho inicia vazio")
    @Test
    public void testaCarrinhoIniciaVazio() {
        double vazio = carrinho.getValorTotal();
        assertEquals(0.0, vazio);
    }

   
    @DisplayName("Testa se adiciona item ao carrinho")
    @Test
    public void testaAdicionaItem() {
        Produto arroz = new Produto("Arroz", 5.0);
        carrinho.addItem(arroz);
        int qtde = carrinho.getQtdeItems();
        assertEquals(1, qtde);
    }

    @DisplayName("Testa o valor total com vários itens")
    @Test
    public void testaValorTotal() {
        Produto arroz = new Produto("Arroz", 5.0);
        Produto feijao = new Produto("Feijão", 8.0);
        carrinho.addItem(arroz);
        carrinho.addItem(feijao);
        assertEquals(13.0, carrinho.getValorTotal());
    }

    @DisplayName("Testa remover item existente")
    @Test
    public void testaRemoveItemExistente() throws ProdutoNaoEncontradoException {
        Produto arroz = new Produto("Arroz", 5.0);
        carrinho.addItem(arroz);
        carrinho.removeItem(arroz);
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @DisplayName("Testa remover item inexistente lança exceção")
    @Test
    public void testaRemoveItemInexistente() {
        Produto arroz = new Produto("Arroz", 5.0);
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(arroz);
        });
    }

    @DisplayName("Testa esvaziar o carrinho")
    @Test
    public void testaEsvaziaCarrinho() {
        Produto arroz = new Produto("Arroz", 5.0);
        Produto feijao = new Produto("Feijão", 8.0);
        carrinho.addItem(arroz);
        carrinho.addItem(feijao);
        assertEquals(2, carrinho.getQtdeItems());

        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

}

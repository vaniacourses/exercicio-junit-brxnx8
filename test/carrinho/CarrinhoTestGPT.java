package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTestGPT {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;
    private Produto produto3;

    // Configuração antes de cada teste
    @BeforeEach
    public void setUp() {
        carrinho = new Carrinho();
        produto1 = new Produto("Produto 1", 10.0);
        produto2 = new Produto("Produto 2", 20.0);
        produto3 = new Produto("Produto 3", 30.0);
    }

    // Testando o valor total do carrinho
    @Test
    public void testGetValorTotal() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.addItem(produto3);

        // O valor total deve ser 10 + 20 + 30 = 60
        assertEquals(60.0, carrinho.getValorTotal(), "O valor total do carrinho está incorreto.");
    }

    // Testando a quantidade de itens no carrinho
    @Test
    public void testGetQtdeItems() {
        assertEquals(0, carrinho.getQtdeItems(), "O carrinho deve estar vazio inicialmente.");

        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems(), "O carrinho deve ter 2 itens.");
    }

    // Testando a adição de um item ao carrinho
    @Test
    public void testAddItem() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertTrue(carrinho.getQtdeItems() > 0, "Itens não foram adicionados corretamente ao carrinho.");
    }

    // Testando a remoção de um item do carrinho
    @Test
    public void testRemoveItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems(), "O carrinho deve ter 2 itens antes da remoção.");

        carrinho.removeItem(produto1);

        assertEquals(1, carrinho.getQtdeItems(), "O carrinho deve ter 1 item após a remoção.");

        // Testando a remoção de um item que não está no carrinho
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produto3), 
                     "Deveria lançar ProdutoNaoEncontradoException ao tentar remover um item não existente.");
    }

    // Testando o esvaziamento do carrinho
    @Test
    public void testEsvazia() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems(), "O carrinho deve ter 2 itens antes de esvaziar.");

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems(), "O carrinho deve estar vazio após esvaziar.");
    }

    // Testando a remoção de um item não encontrado
    @Test
    public void testRemoveItemNaoEncontrado() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);

        assertEquals(2, carrinho.getQtdeItems(), "O carrinho deve ter 2 itens.");

        // Tentando remover um item inexistente
        Produto produtoNaoExistente = new Produto("Produto 3", 30.0);
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produtoNaoExistente), 
                     "Deveria lançar ProdutoNaoEncontradoException quando o item não for encontrado.");
    }
}

package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do Carrinho de Compras")
public class CarrinhoTest {
	
	private Carrinho carrinho;
	private Produto produto1;
	private Produto produto2;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		produto1 = new Produto("Livro", 50.0);
		produto2 = new Produto("Caneta", 5.0);
	}
	
	@DisplayName("Testa a adicao de um item")
	@Test
	public void testAdicionarItem() {
		carrinho.addItem(produto1);
		assertEquals(1, carrinho.getQtdeItems());
		assertEquals(50.0, carrinho.getValorTotal());
	}
	
	@DisplayName("Testa a remocao de um item existente")
	@Test
	public void testRemoverItemExistente() throws ProdutoNaoEncontradoException {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		carrinho.removeItem(produto1);
		assertEquals(1, carrinho.getQtdeItems());
		assertEquals(5.0, carrinho.getValorTotal());
	}
	
	@DisplayName("Testa a remocao de um item que nao existe")
	@Test
	public void testRemoverItemNaoExistente() {
		carrinho.addItem(produto1);
		
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> carrinho.removeItem(produto2));
	}
	
	@DisplayName("Testa o calculo do valor total com varios itens")
	@Test
	public void testValorTotalComVariosItens() {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		carrinho.addItem(new Produto("Mouse", 25.0));
		
		assertEquals(80.0, carrinho.getValorTotal());
	}
	
	@DisplayName("Testa a contagem de itens")
	@Test
	public void testContagemDeItens() {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		
		assertTrue(carrinho.getQtdeItems() == 2);
	}
	
	@DisplayName("Testa o esvaziamento do carrinho")
	@Test
	public void testEsvaziarCarrinho() {
		carrinho.addItem(produto1);
		carrinho.addItem(produto2);
		carrinho.esvazia();
		
		assertEquals(0, carrinho.getQtdeItems());
		assertEquals(0.0, carrinho.getValorTotal());
	}
}

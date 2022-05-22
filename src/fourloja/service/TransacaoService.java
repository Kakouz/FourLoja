package fourloja.service;

import fourloja.data.TransacaoDataBase;
import fourloja.model.*;

public class TransacaoService {
	TransacaoDataBase transacaoDB = new TransacaoDataBase();
	ProdutoService produtoS = new ProdutoService();
	
	public String comprar(Transacao transacao) {
		String retornarCompra = "";
		Double valorAPagar = 0.0;
				
		for (Produto item : transacao.getProdutos()) {
			item.setPreco(produtoS.retornarPreco(item));
			valorAPagar += item.getPreco() * item.getQuantidade();
			produtoS.retirarProduto(item);
		}
		
		transacao.setValorPagamento(valorAPagar);
		
		if(!(transacao.getValorPagamento() > 0)) {
			retornarCompra = "ERRO, produtos não existem ou quantidades não são compativeis";
		} else {
			retornarCompra = transacaoDB.criarTransacaoNoBancoDeDados(transacao);
		}

		return retornarCompra;
	}

	public String retonarHistoricoNoBancoDeDados() {
		String retornarHistorico = "";
		
		retornarHistorico = transacaoDB.conferirHistoricoDeVendas();
				
		return retornarHistorico;
	}

}

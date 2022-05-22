package fourloja.service;

import fourloja.data.ProdutoDataBase;
import fourloja.model.Produto;

public class ProdutoService {
	ProdutoDataBase produtoDB = new ProdutoDataBase();

	public String cadastrarProduto(Produto produto) {
		String resultadoCadastro = "Erro, produto já cadastrado no sistema.";

		if (!produtoDB.checarDuplicidade(produto)) {
			resultadoCadastro = produtoDB.criarProdutoNoBancoDeDados(produto);
		}

		return resultadoCadastro;
	}

	public String conferirEstoque() {
		String resultadoEstoque = "";
		resultadoEstoque = produtoDB.conferirEstoque();

		return resultadoEstoque;
	}

	public String atualizarProduto(Produto produto) {
		String resultadoAtualizacao = "";
		if (produtoDB.checarDuplicidade(produto)) {
			resultadoAtualizacao = produtoDB.atualizarProduto(produto);
		}

		return resultadoAtualizacao;
	}

	public String retirarProduto(Produto produto) {
		String resultadoSaida = "";
		if (produtoDB.checarDuplicidade(produto)) {
			resultadoSaida = produtoDB.retirarProduto(produto);
		}
		return resultadoSaida;
	}
	
	public Double retornarPreco (Produto produto) {
		Double retornar = 0.0;
			retornar = produtoDB.retornarPreco(produto);
		
		return retornar;
	}
}

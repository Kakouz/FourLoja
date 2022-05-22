package fourloja.data;

import java.util.ArrayList;
import fourloja.model.Produto;

public class ProdutoDataBase {
	
	public static ArrayList<Produto> BANCO_DE_DADOS = new ArrayList<Produto>();

	public String criarProdutoNoBancoDeDados(Produto produto) {
		String retornar = "Erro, não consegui inserir no banco de dados o produto " + produto;

		BANCO_DE_DADOS.add(produto);
		for (Produto item : BANCO_DE_DADOS) {
			if (item.equals(produto)) {
				return "Item adicionado com sucesso \n" + produto.toString();
			}
		}

		return retornar;
	}

	public boolean checarDuplicidade(Produto produto) {
		for (Produto item : BANCO_DE_DADOS) {
			if (item.getNome().toUpperCase().equals(produto.getNome().toUpperCase())) {
				return true;
			}
		}

		return false;
	}

	public String conferirEstoque() {
		String resultadoEstoque = "";
		for (Produto produto : BANCO_DE_DADOS) {
			resultadoEstoque += produto;
		}
		return resultadoEstoque;
	}

	public String atualizarProduto(Produto produto) {
		String retornoAtualizacao = "";

		for (Produto item : BANCO_DE_DADOS) {
			if (item.getNome().toUpperCase().equals(produto.getNome().toUpperCase())) {
				item.setQuantidade(item.getQuantidade() + produto.getQuantidade());
				retornoAtualizacao = "O item " + item.getNome() + " foi atualizado. Quantidade nova: "
						+ item.getQuantidade();
			}
		}

		return retornoAtualizacao;
	}

	public String retirarProduto(Produto produto) {
		String resultadoSaida = "";

		for (Produto item : BANCO_DE_DADOS) {
			if (item.getNome().toUpperCase().equals(produto.getNome().toUpperCase())) {
				if (item.getQuantidade() - produto.getQuantidade() >= 0) {
					item.setQuantidade(item.getQuantidade() - produto.getQuantidade());
					resultadoSaida = "O item " + item.getNome() + " foi atualizado. Quantidade nova: "
							+ item.getQuantidade();
				} else {
					resultadoSaida = "Atenção, você tentou diminuir mais do que tem no estoque, operação CANCELADA";
				}
			}
		}
		return resultadoSaida;
	}
	public Double retornarPreco (Produto produto) {
		Double retornar = 0.0;
				for (Produto item : BANCO_DE_DADOS) {
					if (item.getNome().toUpperCase().equals(produto.getNome().toUpperCase())) {
						retornar = item.getPreco();
					}
				}
		
		return retornar;
	}
}

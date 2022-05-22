package fourloja.controller;

import fourloja.model.Produto;
import fourloja.service.ProdutoService;

public class ProdutoController {
	ProdutoService produtoS = new ProdutoService();

	public String cadastrarProduto(String nomeProduto, String quantidadeProduto, String precoProduto) {
		String resultadoCadastro = "";
		Integer quantidadeInteiro = 0;
		Double precoDouble = 0.0;

		try {
			quantidadeInteiro = Integer.parseInt(quantidadeProduto);
			precoDouble = Double.parseDouble(precoProduto);

		} catch (Exception e) {
			resultadoCadastro = "Erro, você passou uma quantidade invalida";
		}

		Produto produto = new Produto(nomeProduto, quantidadeInteiro, precoDouble);

		if (produto.getNome() == null || produto.getQuantidade().equals(0) || produto.getPreco().equals(0.0)) {
			resultadoCadastro = "Erro, nome invalido, quantidade igual a 0 ou preço igual a 0.0";
		} else {
			resultadoCadastro = produtoS.cadastrarProduto(produto);
		}

		return resultadoCadastro;
	}

	public String conferirEstoque() {
		String resultadoEstoque = "";
		resultadoEstoque = produtoS.conferirEstoque();
		if (resultadoEstoque.equals("")) {
			resultadoEstoque = "O estoque encontra-se vazio";
		}
		return resultadoEstoque;
	}

	public String atualizarEstoque(String nomeProduto, String quantidadeProduto) {
		String resultadoAtualizacao = "";
		Integer quantidadeInteiro = 0;
		try {
			quantidadeInteiro = Integer.parseInt(quantidadeProduto);

		} catch (Exception e) {
			resultadoAtualizacao = "Erro, você passou uma quantidade invalida";
		}

		Produto produto = new Produto(nomeProduto, quantidadeInteiro);

		if (produto.getNome() == null || produto.getQuantidade().equals(0)) {
			resultadoAtualizacao = "Erro, nome inválido ou quantidade igual à zero";
		} else {
			resultadoAtualizacao = produtoS.atualizarProduto(produto);
		}

		if (resultadoAtualizacao.equals("")) {
			resultadoAtualizacao = "Não consegui atualizar, item não cadastrado";
		}

		return resultadoAtualizacao;
	}

	public String retirarEstoque(String nomeProduto, String quantidadeProduto) {
		String resultadoSaida = "";
		Integer quantidadeInteiro = 0;

		try {
			quantidadeInteiro = Integer.parseInt(quantidadeProduto);

		} catch (Exception e) {
			resultadoSaida = "Erro, você passou uma quantidade invalida";
		}

		Produto produto = new Produto(nomeProduto, quantidadeInteiro);

		if (produto.getNome() == null || produto.getQuantidade().equals(0)) {
			resultadoSaida = "Erro, nome inválido ou quantidade igual à zero";
		} else {
			resultadoSaida = produtoS.retirarProduto(produto);
		}

		if (resultadoSaida.equals("")) {
			resultadoSaida = "Não encontrei nenhum item para retirar";
		}
		return resultadoSaida;
	}

	public void popularEstoque() {
		cadastrarProduto("Camisa", "15", "14.75");
		cadastrarProduto("Bermuda", "10", "10.0");
		cadastrarProduto("Tenis", "4", "89.90");
		cadastrarProduto("Calcinha", "8", "5.00");
		cadastrarProduto("Cueca", "20", "10.00");
	}

}

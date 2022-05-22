package fourloja.controller;
import java.util.ArrayList;

import fourloja.model.*;
import fourloja.service.TransacaoService;

public class TransacaoController {
	TransacaoService transacaoS = new TransacaoService();
	public String compraEmDinheiro(ArrayList<String> nomeProdutos, ArrayList<String> quantidadeProdutos, String cpf, String metodoPagamento) {
		String retornoCompra = "Erro, Ocorreu um erro, compra CANCELADA";
		Integer quantidadeInteiro = 0;
		String cpfCliente = "0";
		String dadosPagamento = "Dinheiro";
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for(int i = 0; i < nomeProdutos.size(); i++) {
			try {
				quantidadeInteiro = Integer.parseInt(quantidadeProdutos.get(i));
			} catch (Exception e) {
				break;
			}
			Produto produtoNovo = new Produto(nomeProdutos.get(i), quantidadeInteiro);
			produtos.add(produtoNovo);
		}
		
		if(cpf.length() == 11) {
			cpfCliente = cpf;
		}
		
		String metodoPagamentoAtualizado = transformarMetodoPagamento(metodoPagamento);
		
		if(cpf.length() == 1) {
			Transacao transacao = new Transacao(metodoPagamentoAtualizado, dadosPagamento, cpfCliente, produtos);
			retornoCompra = transacaoS.comprar(transacao);
		} else {
			Transacao transacao = new Transacao(metodoPagamentoAtualizado, dadosPagamento, produtos);
			retornoCompra = transacaoS.comprar(transacao);
		}
		
		return retornoCompra;
	}

	public String compraComCartao(ArrayList<String> nomeProdutos, ArrayList<String> quantidadeProdutos, String cpf,
			String metodoPagamento, String cartao) {
		String retornoCompra = "Erro, Ocorreu um erro, compra CANCELADA";
		Integer quantidadeInteiro = 0;
		String cpfCliente = "0";
		String dadosPagamento = cartao;
				
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for(int i = 0; i < nomeProdutos.size(); i++) {
			try {
				quantidadeInteiro = Integer.parseInt(quantidadeProdutos.get(i));
			} catch (Exception e) {
				break;
			}
			Produto produtoNovo = new Produto(nomeProdutos.get(i), quantidadeInteiro);
			produtos.add(produtoNovo);
		}
		
		if(cpf.length() == 11) {
			cpfCliente = cpf;
		}
		
		String metodoPagamentoAtualizado = transformarMetodoPagamento(metodoPagamento);
		
		if(cpf.length() == 1) {
			Transacao transacao = new Transacao(metodoPagamentoAtualizado, dadosPagamento, cpfCliente, produtos);
			retornoCompra = transacaoS.comprar(transacao);
		} else {
			Transacao transacao = new Transacao(metodoPagamentoAtualizado, dadosPagamento, produtos);
			retornoCompra = transacaoS.comprar(transacao);
		}
		
		return retornoCompra;
	}

	public String compraViaPix(ArrayList<String> nomeProdutos, ArrayList<String> quantidadeProdutos, String cpf,
			String metodoPagamento, String chavePix) {
		String retornoCompra = "Erro, Ocorreu um erro, compra CANCELADA";
		Integer quantidadeInteiro = 0;
		String cpfCliente = "0";
		String dadosPagamento = chavePix;
				
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		for(int i = 0; i < nomeProdutos.size(); i++) {
			try {
				quantidadeInteiro = Integer.parseInt(quantidadeProdutos.get(i));
			} catch (Exception e) {
				break;
			}
			Produto produtoNovo = new Produto(nomeProdutos.get(i), quantidadeInteiro);
			produtos.add(produtoNovo);
		}
		
		if(cpf.length() == 11) {
			cpfCliente = cpf;
		}
		
		String metodoPagamentoAtualizado = transformarMetodoPagamento(metodoPagamento);
		
		if(cpf.length() == 11) {
			Transacao transacao = new Transacao(metodoPagamentoAtualizado, dadosPagamento, cpfCliente, produtos);
			retornoCompra = transacaoS.comprar(transacao);
		} else {
			Transacao transacao = new Transacao(metodoPagamentoAtualizado, dadosPagamento, produtos);
			retornoCompra = transacaoS.comprar(transacao);
		}
		
		return retornoCompra;
	}
	
	private String transformarMetodoPagamento(String metodoPagamento) {
		String metodoAtualizado = "";
		if(metodoPagamento.equals("2")) {
			metodoAtualizado = "CARTAODEBITO";
		} else if (metodoPagamento.equals("3")) {
			metodoAtualizado = "CARTAOCREDITO";
		} else if (metodoPagamento.equals("4")) {
			metodoAtualizado = "PIX";
		} else {
			metodoAtualizado = "DINHEIRO";
		}
		
		return metodoAtualizado;
	}
	
	public String historicoDoDia() {
		String retornoHistorico = "";
		
		retornoHistorico = transacaoS.retonarHistoricoNoBancoDeDados();
		if(retornoHistorico.equals("")) {
			return "HISTÓRICO VAZIO, AINDA NÃO TIVEMOS VENDAS";
		} else {
			
		}
		
		return retornoHistorico;
	}

}

package fourloja.communication;

import java.util.ArrayList;
import java.util.Scanner;

import fourloja.controller.*;

public class MenuPrincipal {
	Scanner sc = new Scanner(System.in);
	String opcao = "0";
	ProdutoController produtoC = new ProdutoController();
	TransacaoController transacaoC = new TransacaoController();

	public void inicializarSistema() {
		menuInicial();

		while (true) {
			switch (opcao) {
			case "0": { // Opção de saida do sistema!
				System.exit(0);
				break;
			}
			case "1": {
				cadastrarProduto();
				break;
			}
			case "2": {
				conferirEstoque();
				break;
			}
			case "3": {
				aumentarEstoque();
				break;
			}
			case "4": {
				diminuirEstoque();
				break;
			}
			case "5": {
				venderProdutos();
				break;
			}
			case "6": {
				historicoDoDia();
				break;
			}
			case "9": {
				popularBancoDeDados();
				break;
			}

			default:
				System.out.println("Opção Invalida! Tente novamente");
				menuInicial();
				break;
			}
		}
	}



	public void menuInicial() {
		System.out.println("Bem vindo ao menu da loja!");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Cadastrar um produto novo");
		System.out.println("2 - Conferir Estoque");
		System.out.println("3 - Entrada de Mercadoria (Aumentar quantidades)");
		System.out.println("4 - Saida de mercadoria (Diminuir quantidades)");
		System.out.println("5 - Comprar mercadorias");
		System.out.println("6 - Apresentar histórico do dia");
		System.out.println("9 - Popular Banco de Dados");
		System.out.println("0 - Sair do sistema");
		opcao = sc.nextLine();
	}

	public void cadastrarProduto() {
		System.out.println("Digite o nome");
		String nomeProduto = sc.nextLine();
		System.out.println("Digite a quantidade");
		String quantidadeProduto = sc.nextLine();
		System.out.println("Digite o preço do produto");
		String precoProduto = sc.nextLine();
		String resultadoCadastro = produtoC.cadastrarProduto(nomeProduto, quantidadeProduto, precoProduto);
		System.out.println(resultadoCadastro);
		menuInicial();
	}

	public void conferirEstoque() {
		String resultadoEstoque = produtoC.conferirEstoque();
		System.out.println(resultadoEstoque);
		menuInicial();
	}

	public void aumentarEstoque() {
		System.out.println("Digite o nome do item que deseja AUMENTAR a quantidade");
		String nomeProduto = sc.nextLine();
		System.out.println("Digite a quantidade que ENTRARÁ");
		String quantidadeProduto = sc.nextLine();
		String resultadoAtualizacao = produtoC.atualizarEstoque(nomeProduto, quantidadeProduto);
		System.out.println(resultadoAtualizacao);
		menuInicial();
	}

	public void diminuirEstoque() {
		System.out.println("Digite o nome do item que deseja DIMINUIR a quantidade");
		String nomeProduto = sc.nextLine();
		System.out.println("Digite a quantidade que SAIRÁ");
		String quantidadeProduto = sc.nextLine();
		String resultadoSaida = produtoC.retirarEstoque(nomeProduto, quantidadeProduto);
		System.out.println(resultadoSaida);
		menuInicial();
	}

	public void venderProdutos() {
		String controlador = "1";
		String resultadoCompra = "";
		ArrayList<String> nomeProdutos = new ArrayList<String>();
		ArrayList<String> quantidadeProdutos = new ArrayList<String>();
		
		while (controlador.equals("1")) {
			System.out.println("Digite o nome do produto");
			String nomeProduto = sc.nextLine();

			System.out.println("Digite a quantidade a comprar");
			String quantidadeProduto = sc.nextLine();

			nomeProdutos.add(nomeProduto);
			quantidadeProdutos.add(quantidadeProduto);
			
			System.out.println("Digite 1 para comprar mais produtos");
			System.out.println("Digite outro valor para continuar a compra");
			controlador = sc.nextLine();
		}
		System.out.println("Digite o CPF - caso não queira informar digite 0");
		String cpf = sc.nextLine();
		String metodoPagamento = informarMetodoPagamento();

		if (metodoPagamento.equals("1")) {
			resultadoCompra = transacaoC.compraEmDinheiro(nomeProdutos, quantidadeProdutos, cpf, metodoPagamento);
		} else if (metodoPagamento.equals("2") || metodoPagamento.equals("3")) {
			String cartao = retornarInfoCartao();
			if(!cartao.equals("")) {
				resultadoCompra = transacaoC.compraComCartao(nomeProdutos, quantidadeProdutos, cpf, metodoPagamento, cartao);
			} else {
				System.out.println("Cartão Invalido, COMPRA RECUSADA");
			}
		} else if (metodoPagamento.equals("4")) {
			String chavePix = retonarInfoPix();
			if(!chavePix.equals("")) {
				resultadoCompra = transacaoC.compraViaPix(nomeProdutos, quantidadeProdutos, cpf, metodoPagamento, chavePix);
			} else {
				System.out.println("Chave Pix Invalida, COMPRA RECUSADA");
			}
		} else {
			System.out.println("Metodo Pagamento Invalido, COMPRA RECUSADA");
		}
		System.out.println(resultadoCompra);
		menuInicial();
	}

	private String retonarInfoPix() {
		String chavePix = "";
		System.out.println("Informe a Chave Pix");
		chavePix += "ChavePix: " + sc.nextLine() + "\n";
		System.out.println("Digite o nome do Titular da Chave Pix");
		chavePix += "Nome Titular: " + sc.nextLine();
		return chavePix;
	}

	private String retornarInfoCartao() {
		String cartao = "";
		System.out.println("Digite o Numero do Cartão");
		cartao += "Numero: " + sc.nextLine() + "\n";
		System.out.println("Digite o Vencimento do Cartão");
		cartao += "Vencimento: " + sc.nextLine() + "\n";
		System.out.println("Digite o Codigo Verificador (CVV)");
		cartao += "CVV: " + sc.nextLine() + "\n";
		System.out.println("Digite o nome do Titular do Cartão");
		cartao += "Nome Titular: " + sc.nextLine();
		return cartao;
	}

	private String informarMetodoPagamento() {
		System.out.println("Informe o método de pagamento:");
		System.out.println("1 - Dinheiro");
		System.out.println("2 - Cartão de Débito");
		System.out.println("3 - Cartão de Crédito");
		System.out.println("4 - Pix");
		String retornar = sc.nextLine();
		return retornar;
	}
	
	private void historicoDoDia() {
		System.out.println("----------------- HISTÓRICO -----------------");
		String resultadoHistorico = transacaoC.historicoDoDia();
		System.out.println(resultadoHistorico);
		menuInicial();
	}

	public void popularBancoDeDados() {
		System.out.println("Populando banco de dados...");
		produtoC.popularEstoque();
		menuInicial();
	}
}

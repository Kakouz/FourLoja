package fourloja.model;

import java.util.ArrayList;

import fourloja.enums.MetodoPagamento;

public class Transacao {
	private MetodoPagamento metodoPagamento;
	private String dadosPagamento;
	private Double valorPagamento;
	private String cpf;
	private ArrayList<Produto> produtos;

	public Transacao(String metodoPagamento, String dadosPagamento, String cpf, ArrayList<Produto> produtos) {
		this.metodoPagamento = MetodoPagamento.valueOf(metodoPagamento);
		this.dadosPagamento = dadosPagamento;
		this.valorPagamento = 0.0;
		this.cpf = cpf;
		this.produtos = produtos;
	}

	public Transacao(String metodoPagamento, String dadosPagamento, ArrayList<Produto> produtos) {
		this.metodoPagamento = MetodoPagamento.valueOf(metodoPagamento);
		this.dadosPagamento = dadosPagamento;
		this.valorPagamento = 0.0;
		this.cpf = "CPF NÃO INFORMADO";
		this.produtos = produtos;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getDadosPagamento() {
		return dadosPagamento;
	}

	public void setDadosPagamento(String dadosPagamento) {
		this.dadosPagamento = dadosPagamento;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "\nTransação CPF cliente: " + cpf 
				+"\nMetódo Pagamento: " + metodoPagamento
				+"\nDados do pagamento: " + dadosPagamento
				+"\nValor do Pagamento: " + valorPagamento
				+"\nProdutos: " + produtos;
	}

	
}

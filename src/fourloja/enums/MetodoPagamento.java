package fourloja.enums;

public enum MetodoPagamento {
	DINHEIRO("Dinheiro à vista"),
	CARTAODEBITO("Cartão de Débito"),
	CARTAOCREDITO("Cartão de Crédito"),
	PIX("Pix");
	
	private String descricao;
	
	MetodoPagamento(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	
}

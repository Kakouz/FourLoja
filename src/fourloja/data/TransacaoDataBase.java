package fourloja.data;

import java.util.ArrayList;

import fourloja.model.Transacao;

public class TransacaoDataBase {
	public static ArrayList<Transacao> BANCO_DE_DADOS = new ArrayList<Transacao>();
	
	public String criarTransacaoNoBancoDeDados(Transacao transacao) {
		String retornar = "Erro, não consegui inserir a transação no banco de dados. " + transacao;
		BANCO_DE_DADOS.add(transacao);

		for (Transacao item : BANCO_DE_DADOS) {
			if (item.equals(transacao)) {
				return "Transação efetuada com sucesso \n" + transacao.toString();
			}
		}

		return retornar;
	}
	
	public String conferirHistoricoDeVendas() {
		String historicoDeVendas = "";
		for (Transacao transacao : BANCO_DE_DADOS) {
			historicoDeVendas += transacao + "\n";
		}
		return historicoDeVendas;
	}
}

package mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.Mensagem;

@ManagedBean
@ViewScoped
public class IndexMBean {

	private String teste = "Liguei com a tela !!!";

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public void clickBotao() {
		Mensagem.Make("Teste growl");
	}

	// tudo tem que ter getter and setter

}

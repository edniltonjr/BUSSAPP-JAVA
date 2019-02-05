package mbeans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.Viagem;
import entities.ViagemConteudo;
import uDao.ViagemDao;
import util.Mensagem;

@ManagedBean
@ViewScoped
public class ContentViagemList {

	private List<ViagemConteudo> viagemConteudos;
	private ViagemDao viagemDao;

	private Viagem viagem;
	private ViagemConteudo conteudo;

	public ContentViagemList() {
		viagemConteudos = new ArrayList<>();
		viagemDao = new ViagemDao();
	}

	@ManagedProperty(value = "#{viagemList}")
	private ViagemList viagemList;

	@PostConstruct
	public void findAll() {
		try {
			viagem = viagemList.getViagem();

			if (viagem.getId_viagem() == null) {

				FacesContext.getCurrentInstance().getExternalContext().redirect("/viagem/viagemList.xhtml");
				return;
			}

			viagemConteudos = viagemDao.findAllViagem(viagem);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	public List<ViagemConteudo> getViagemConteudos() {
		return viagemConteudos;
	}

	public void setViagemConteudos(List<ViagemConteudo> viagemConteudos) {
		this.viagemConteudos = viagemConteudos;
	}

	public void setViagemList(ViagemList viagemList) {
		this.viagemList = viagemList;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public ViagemConteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(ViagemConteudo conteudo) {
		this.conteudo = conteudo;
	}

}

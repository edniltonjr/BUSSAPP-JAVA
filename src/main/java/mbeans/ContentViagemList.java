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

import entities.Funcionario;
import entities.Viagem;
import entities.ViagemConteudo;
import uDao.FuncionarioDao;
import uDao.ViagemDao;
import util.Mensagem;

@ManagedBean
@ViewScoped
public class ContentViagemList {

	private List<ViagemConteudo> viagemConteudos;
	private List<Funcionario> funcionarios;
	private Funcionario funcionario; // funcionario selecionado

	private ViagemDao viagemDao;
	private FuncionarioDao funcionarioDao;
	private Viagem viagem; // viagem trazida da outra tela
	private ViagemConteudo conteudo;

	public ContentViagemList() {
		viagemConteudos = new ArrayList<>();
		viagemDao = new ViagemDao();
		funcionarios = new ArrayList<>();
		funcionarioDao = new FuncionarioDao();
		funcionario = new Funcionario();
	}

	@ManagedProperty(value = "#{viagemList}")
	private ViagemList viagemList;

	@PostConstruct
	public void findAll() {
		try {
			viagem = viagemList.getViagem();

			if (viagem.getId_viagem() == null) {

				FacesContext.getCurrentInstance().getExternalContext().redirect("viagemList.xhtml");
				return;
			}

			viagemConteudos = viagemDao.findAllViagem(viagem);
			funcionarios = funcionarioDao.findAll(viagem.getId_viagem());
			conteudo = new ViagemConteudo();
			funcionario = new Funcionario();
			viagemList.findAll();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	public void inserirFuncionario() {
		ViagemConteudo viagemConteudo = new ViagemConteudo();
		viagemConteudo.setFuncionario(funcionario);
		viagemConteudo.setViagem(viagem);
		try {
			if (viagemDao.insertPeopleViagem(viagemConteudo)) {
				Mensagem.Make("Funcionario inserido com sucesso na viagem !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
		findAll();
	}

	public void deletarFuncionario() {
		try {
			if (viagemDao.deletePeopleViagem(conteudo)) {
				Mensagem.Make("Funcionario deletado com sucesso na viagem !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
		findAll();
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}

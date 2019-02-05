package mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Motorista;
import entities.Veiculo;
import entities.Viagem;
import uDao.MotoristaDao;
import uDao.VeiculoDao;
import uDao.ViagemDao;
import util.Mensagem;

@ManagedBean(name = "viagemList", eager = true)
@SessionScoped
public class ViagemList {

	private List<Viagem> viagens;
	private List<Motorista> motoristas;
	private List<Veiculo> veiculos;

	private ViagemDao viagemDao;
	private MotoristaDao motoristaDao;
	private VeiculoDao veiculoDao;

	private Viagem viagem;

	public ViagemList() {
		veiculoDao = new VeiculoDao();
		motoristaDao = new MotoristaDao();
		viagemDao = new ViagemDao();
		viagens = new ArrayList<>();
		motoristas = new ArrayList<>();
		veiculos = new ArrayList<>();
		viagem = new Viagem();
		findAll();
	}

	private void findAll() {
		try {
			viagens = viagemDao.findAll();
			motoristas = motoristaDao.findAll();
			veiculos = veiculoDao.findAll();
			viagem = new Viagem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void inserirViagem() {
		try {
			if (viagemDao.insertOne(viagem)) {
				Mensagem.Make("Viagem inserida com sucesso !");
				findAll();
				viagem = new Viagem();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	private void updateViagem() {
		try {
			if (viagemDao.updateOne(viagem)) {
				Mensagem.Make("Viagem atualizada com sucesso !");
				findAll();
				viagem = new Viagem();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	public void updateOrInsert() {
		if (viagem.getId_viagem() == null) {
			inserirViagem();
		} else {
			updateViagem();
		}
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public String selectViagem() {
		if (viagem != null) {
			return "contentViagemList?faces-redirect=true";
		}

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		Mensagem.Make("Selecione uma viagem !");

		return "/";
	}

}

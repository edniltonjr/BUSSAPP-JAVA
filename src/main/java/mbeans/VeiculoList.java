package mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Motorista;
import entities.Veiculo;
import uDao.VeiculoDao;
import util.Mensagem;



@ManagedBean
@ViewScoped

public class VeiculoList {
	
	private VeiculoDao veiculoDao; 
	private List<Veiculo> veiculos;
	private Veiculo veiculo;
	
	
	public VeiculoList() {
		veiculoDao = new VeiculoDao();
		veiculo = new Veiculo();
		veiculos = new ArrayList<>();
		findAll();
	}
	
	public void insertVeiculo() {
		try {
			if (veiculoDao.insertOne(veiculo)) {
				Mensagem.Make("Veiculo inserido com sucesso !");
				findAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
		
	}
	
	public void updateMotorista() {
		try {
			if (veiculoDao.updateOne(veiculo)) {
				Mensagem.Make("Motorista atualizado com sucesso !");
				findAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}


	private void findAll() {
		try {
			veiculos = veiculoDao.findAll();
			veiculo = new Veiculo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}
	

	public VeiculoDao getVeiculoDao() {
		return veiculoDao;
	}

	public void setVeiculoDao(VeiculoDao veiculoDao) {
		this.veiculoDao = veiculoDao;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	

}

package mbeans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Motorista;
import entities.Veiculo;
import uDao.MotoristaDao;
import uDao.VeiculoDao;

@ManagedBean
@ViewScoped
public class IndexMBean {

	private Motorista motorista = new Motorista();
	private Veiculo veiculo = new Veiculo();
	private MotoristaDao motoristaDao = new MotoristaDao();
	private VeiculoDao veiculoDao = new VeiculoDao();

	public IndexMBean() {
		try {
			motorista = motoristaDao.buscaMotorista(1);
			veiculo = veiculoDao.buscaVeiculo(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}

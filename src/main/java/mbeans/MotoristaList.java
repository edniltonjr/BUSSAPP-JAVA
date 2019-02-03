package mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Motorista;
import uDao.MotoristaDao;
import util.Mensagem;

@ManagedBean
@ViewScoped
public class MotoristaList {
	private MotoristaDao motoristaDao;

	private List<Motorista> motoristas;

	public MotoristaList() {
		motoristaDao = new MotoristaDao();
		motoristas = new ArrayList<>();
		findAll();
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	private void findAll() {
		try {
			motoristas = motoristaDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}

	}

}

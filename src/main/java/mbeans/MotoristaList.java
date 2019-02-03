package mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.ClasseGenerica;
import entities.Motorista;
import uDao.MotoristaDao;
import uDao.MotoristaDao.CnhDao;
import util.Mensagem;

@ManagedBean
@ViewScoped
public class MotoristaList {
	private MotoristaDao motoristaDao;
	private CnhDao cnhDao;

	private List<Motorista> motoristas;
	private Motorista motorista;
	private List<ClasseGenerica> cnhs;

	public MotoristaList() {
		motoristaDao = new MotoristaDao();
		cnhDao = motoristaDao.new CnhDao();
		cnhs = new ArrayList<>();
		motorista = new Motorista();
		motoristas = new ArrayList<>();
		findAll();
	}

	public void insertMotorista() {
		try {
			if (motoristaDao.insertOne(motorista)) {
				Mensagem.Make("Motorista inserido com sucesso !");
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
			if (motoristaDao.updateOne(motorista)) {
				Mensagem.Make("Motorista atualizado com sucesso !");
				findAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	public void findAll() {
		try {
			motoristas = motoristaDao.findAll();
			cnhs = cnhDao.findAll();
			motorista = new Motorista();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}

	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public List<ClasseGenerica> getCnhs() {
		return cnhs;
	}

	public void setCnhs(List<ClasseGenerica> cnhs) {
		this.cnhs = cnhs;
	}

	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

}

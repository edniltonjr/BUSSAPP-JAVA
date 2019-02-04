package mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.ClasseGenerica;
import uDao.FuncionarioDao;
import uDao.FuncionarioDao.CargoDao;
import util.Mensagem;

@ManagedBean
@ViewScoped
public class CargoList {

	private List<ClasseGenerica> cargos;
	private CargoDao cargoDao;

	private ClasseGenerica cargo;

	public CargoList() {
		cargo = new ClasseGenerica();
		cargoDao = new FuncionarioDao().new CargoDao();
		cargos = new ArrayList<>();
		findAll();
	}

	public void findAll() {
		try {
			cargos = cargoDao.findAll();
			cargo = new ClasseGenerica();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	private void inserirCargo() {
		try {
			if (cargoDao.insertOne(cargo)) {
				Mensagem.Make("Cargo inserido com sucesso !");
				findAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	private void updateCargo() {
		try {
			if (cargoDao.updateOne(cargo)) {
				Mensagem.Make("Cargo atualizado com sucesso !");
				findAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	public List<ClasseGenerica> getCargos() {
		return cargos;
	}

	public void setCargos(List<ClasseGenerica> cargos) {
		this.cargos = cargos;
	}

	public ClasseGenerica getCargo() {
		return cargo;
	}

	public void setCargo(ClasseGenerica cargo) {
		this.cargo = cargo;
	}

	public void updateOrInsert() {
		if (cargo.getId() == null) {
			inserirCargo();
		} else {
			updateCargo();
		}
	}

}

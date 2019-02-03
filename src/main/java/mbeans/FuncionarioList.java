package mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.ClasseGenerica;
import entities.Funcionario;
import uDao.FuncionarioDao;
import uDao.FuncionarioDao.CargoDao;
import uDao.FuncionarioDao.FilialDao;
import util.Mensagem;

@ManagedBean // relação com a tela
@ViewScoped
public class FuncionarioList {

	private List<Funcionario> funcionarios;

	private FuncionarioDao funcionarioDao;
	private CargoDao cargoDao;
	private FilialDao filialDao;
	private Funcionario funcionario;

	private List<ClasseGenerica> filiais;
	private List<ClasseGenerica> cargos;

	public FuncionarioList() {
		funcionarios = new ArrayList<>();
		funcionarioDao = new FuncionarioDao();
		cargoDao = funcionarioDao.new CargoDao();
		filialDao = funcionarioDao.new FilialDao();
		funcionario = new Funcionario();
		cargos = new ArrayList<>();
		filiais = new ArrayList<>();
		findAll();
	}

	public void findAll() {
		try {
			funcionarios = funcionarioDao.findAll();
			cargos = cargoDao.findAll();
			filiais = filialDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	public void inserirFuncionario() {
		try {
			if (funcionarioDao.insertOne(funcionario)) {
				findAll();
				Mensagem.Make("Funcionario inserido com sucesso !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
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

	public List<ClasseGenerica> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<ClasseGenerica> filiais) {
		this.filiais = filiais;
	}

	public List<ClasseGenerica> getCargos() {
		return cargos;
	}

	public void setCargos(List<ClasseGenerica> cargos) {
		this.cargos = cargos;
	}

}

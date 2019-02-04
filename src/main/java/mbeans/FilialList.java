package mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.ClasseGenerica;
import uDao.FuncionarioDao;
import uDao.FuncionarioDao.FilialDao;
import util.Mensagem;

@ManagedBean
@ViewScoped

public class FilialList {

	private List<ClasseGenerica> filiais;
	private FilialDao filialDao;

	private ClasseGenerica filial;

	public FilialList() {
		filial = new ClasseGenerica();
		filialDao = new FuncionarioDao().new FilialDao();
		filiais = new ArrayList<>();
		findAll();
	}

	public void findAll() {
		try {
			filiais = filialDao.findAll();
			filial = new ClasseGenerica();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	private void inserirFilial() {
		try {
			if (filialDao.insertOne(filial)) {
				Mensagem.Make("Filial inserida com sucesso !");
				findAll();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	private void updateFilial() {
		try {
			if (filialDao.updateOne(filial)) {
				Mensagem.Make("Filial atualizada com sucesso !");
				findAll();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.Make(e.toString());
		}
	}

	public List<ClasseGenerica> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<ClasseGenerica> filiais) {
		this.filiais = filiais;
	}

	public ClasseGenerica getFilial() {
		return filial;
	}

	public void setFilial(ClasseGenerica filial) {
		this.filial = filial;
	}

	public void updateOrInsert() {
		if (filial.getId() == null) {
			inserirFilial();
		} else {
			updateFilial();
		}
	}

}

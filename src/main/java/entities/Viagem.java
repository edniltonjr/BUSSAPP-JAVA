package entities;

import java.util.Calendar;

public class Viagem {

	private Integer id_viagem;
	private Integer id_motorista;
	private Integer id_veiculo;
	private TIPO_VIAGEM tipo_viagem;
	private Calendar data_viagem;

	public Integer getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(Integer id_viagem) {
		this.id_viagem = id_viagem;
	}

	public Integer getId_motorista() {
		return id_motorista;
	}

	public void setId_motorista(Integer id_motorista) {
		this.id_motorista = id_motorista;
	}

	public Integer getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Integer id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public String getTipo_viagem() {
		String tipo = "";

		switch (this.tipo_viagem) {
		case IDA:
			tipo = "IDA";
			break;
		case VTA:
			tipo = "VTA";
			break;
		}

		return tipo;
	}

	public void setTipo_viagem(TIPO_VIAGEM tipo_viagem) {
		this.tipo_viagem = tipo_viagem;
	}

	public Calendar getData_viagem() {
		return data_viagem;
	}

	public void setData_viagem(Calendar data_viagem) {
		this.data_viagem = data_viagem;
	}

	enum TIPO_VIAGEM {
		IDA, VTA
	}

}

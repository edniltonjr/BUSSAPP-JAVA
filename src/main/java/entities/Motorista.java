package entities;

public class Motorista {

	private Integer id_motorista;
	private String nome;
	private String cpf;
	private String rg;
	private Integer id_tipo_cnh;

	public Integer getId_motorista() {
		return id_motorista;
	}

	public void setId_motorista(Integer id_motorista) {
		this.id_motorista = id_motorista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Integer getId_tipo_cnh() {
		return id_tipo_cnh;
	}

	public void setId_tipo_cnh(Integer id_tipo_cnh) {
		this.id_tipo_cnh = id_tipo_cnh;
	}

}
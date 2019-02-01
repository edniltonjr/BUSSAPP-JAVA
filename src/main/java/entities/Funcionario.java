package entities;

public class Funcionario {
	private Integer id_funcionario;
	private String nome;
	private String cpf;
	private Integer id_cargo;
	private Integer id_filial;

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
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

	public Integer getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;

	}

	public Integer getId_filial() {
		return id_filial;
	}

	public void setId_filial(Integer id_filial) {
		this.id_filial = id_filial;
	}

}

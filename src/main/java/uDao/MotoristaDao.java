package uDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.BaseDao;
import entities.Motorista;

public class MotoristaDao extends BaseDao {

	public MotoristaDao() {
		super();
	}

	public Motorista findOne(Integer id_motorista) throws SQLException {
		String sql = "SELECT * FROM motoristas AS m " + "INNER JOIN tipos_cnh AS ti ON ti.id_tipo_cnh = m.id_tipo_cnh "
				+ "WHERE m.id_motorista = ?;"; // String a ser executada

		PreparedStatement ps = getConnection().prepareStatement(sql); // Preparar a string pra ligar os parametros

		ps.setInt(1, id_motorista); // Escolher qual index de parametro, e depois qual o parametro em si

		ResultSet rs = ps.executeQuery(); // Executar e receber o resultado da string query

		Motorista m = null; // declarar o corpo como null, a fim de se testar se houve resultados

		if (rs.next()) {
			m = new Motorista(); // se houve, dar um corpo, a fim de se evitar null pointer exception
			m.setId_motorista(rs.getInt("id_motorista")); // preencher todos os atributos utilizando getter and setter
			m.setNome(rs.getString("nome"));
			m.setCpf(rs.getString("cpf"));
			m.setRg(rs.getString("rg"));
			m.getTipo_cnh().setNome(rs.getString("ti.nome")); // se for informado a coluna incorreta ou inexistente,
																// ocorrerá
			m.getTipo_cnh().setId(rs.getInt("id_tipo_cnh")); // uma exceção
		}

		return m;
	}
}

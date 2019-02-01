package uDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Motorista;

public class MotoristaDao extends BaseDao {

	private Connection con;

	public MotoristaDao() {
		super();
		con = getConnection();
	}

	public Motorista buscaMotorista(Integer id_motorista) throws SQLException {
		String sql = "SELECT * FROM motorista WHERE id_motorista = ?"; // String a ser executada

		PreparedStatement ps = con.prepareStatement(sql); // Preparar a string pra ligar os parametros

		ps.setInt(1, id_motorista); // Escolher qual index de parametro, e depois qual o parametro em si

		ResultSet rs = ps.executeQuery(); // Executar e receber o resultado da string query

		Motorista m = null; // declarar o corpo como null, a fim de se testar se houve resultados

		if (rs.next()) {
			m = new Motorista(); // se houve, dar um corpo, a fim de se evitar null pointer exception
			m.setId_motorista(rs.getInt("id_motorista")); // preencher todos os atributos utilizando getter and setter
			m.setNome(rs.getString("nome"));
			m.setCpf(rs.getString("cpf"));
			m.setRg(rs.getString("rg"));
			m.setId_tipo_cnh(rs.getInt("id_tipo_cnh")); // se for informado a coluna incorreta ou inexistente, ocorrerá
														// uma exceção
		}

		return m;
	}
}

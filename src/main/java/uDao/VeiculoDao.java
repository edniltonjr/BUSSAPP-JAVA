package uDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.BaseDao;
import entities.Veiculo;

public class VeiculoDao extends BaseDao {

	public VeiculoDao() {
		super();
	}

	public Veiculo buscaVeiculo(Integer id_veiculo) throws SQLException {

		String sql = "SELECT * FROM veiculos WHERE id_veiculo = ?;";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, id_veiculo);

		ResultSet rs = ps.executeQuery();

		Veiculo v = null;

		if (rs.next()) {

			v = new Veiculo();
			v.setId_veiculo(rs.getInt("id_veiculo"));
			v.setModelo(rs.getString("modelo"));
			v.setPlaca(rs.getString("placa"));
		}

		return v;

	}

}

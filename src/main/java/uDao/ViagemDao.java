package uDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import JDBC.BaseDao;
import entities.Viagem;

public class ViagemDao extends BaseDao {

	public ViagemDao() {
		super();
	}

	public Boolean insertOne(Viagem v) throws SQLException {
		String sql = "INSERT INTO viagens(id_motorista, id_veiculo, tipo_viagem, data_viagem) VALUE (?, ?, ?, ?);";

		PreparedStatement ps = getConnection().prepareStatement(sql);

		ps.setInt(1, v.getMotorista().getId());
		ps.setInt(2, v.getVeiculo().getId());
		ps.setString(3, v.getTipo_viagem());
		errorCalendar(v.getData_viagem());
		Timestamp timestamp = new Timestamp(v.getData_viagem().getTimeInMillis());
		ps.setTimestamp(4, timestamp);

		return ps.executeUpdate() > 0;
	}

	public Boolean updateOne(Viagem v) throws SQLException {
		String sql = "UPDATE viagens SET id_motorista = ?, id_veiculo = ?, tipo_viagem = ?, data_viagem = ? WHERE id_viagem = ?;";

		PreparedStatement ps = getConnection().prepareStatement(sql);

		ps.setInt(1, v.getMotorista().getId());
		ps.setInt(2, v.getVeiculo().getId());
		ps.setString(3, v.getTipo_viagem());
		errorCalendar(v.getData_viagem());
		Timestamp timestamp = new Timestamp(v.getData_viagem().getTimeInMillis());
		ps.setTimestamp(4, timestamp);
		ps.setInt(5, v.getId_viagem());

		return ps.executeUpdate() > 0;
	}

	public List<Viagem> findAll() throws SQLException {
		String sql = "SELECT * FROM viagens AS v " + "INNER JOIN motoristas AS m ON m.id_motorista = v.id_motorista "
				+ "INNER JOIN veiculos AS ve ON ve.id_veiculo = v.id_veiculo ORDER BY v.id_viagem;";

		PreparedStatement ps = getConnection().prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Viagem> viagens = new ArrayList<>();

		while (rs.next()) {
			Viagem v = new Viagem();

			v.setId_viagem(rs.getInt("id_viagem"));
			v.getMotorista().setNome(rs.getString("m.nome"));
			v.getMotorista().setId(rs.getInt("id_motorista"));
			v.getVeiculo().setNome(rs.getString("ve.modelo"));
			v.getVeiculo().setId(rs.getInt("id_veiculo"));
			v.setTipo_viagem(rs.getString("tipo_viagem"));

			Timestamp t = rs.getTimestamp("data_viagem");
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(t.getTime());
			v.setData_viagem(c);

			viagens.add(v);
		}

		return viagens;
	}

	private void errorCalendar(Calendar c) {
		c.set(Calendar.HOUR, c.get(Calendar.HOUR) - 2);
	}

}

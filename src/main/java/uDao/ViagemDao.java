package uDao;

import java.sql.Connection;

import JDBC.BaseDao;

public class ViagemDao extends BaseDao {

	private Connection con;

	public ViagemDao() {
		super();
		con = getConnection();
	}
}

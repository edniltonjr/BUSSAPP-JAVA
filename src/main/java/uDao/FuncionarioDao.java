package uDao;

import java.sql.Connection;

import JDBC.BaseDao;

public class FuncionarioDao extends BaseDao {

	private Connection con;

	public FuncionarioDao() {
		super();
		con = getConnection();
	}
}

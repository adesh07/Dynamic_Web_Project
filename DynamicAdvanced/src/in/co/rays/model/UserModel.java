package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;

public class UserModel {

	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JdbcDataSource.getConnection();
		conn.getAutoCommit();
		PreparedStatement stmt = conn.prepareStatement("select max(id) from user");
		ResultSet rSet = stmt.executeQuery();
		while (rSet.next()) {
			pk = rSet.getInt(1);
		}
		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?)");

		stmt.setInt(1, nextPk());
		stmt.setString(2, bean.getFirstName());
		stmt.setString(3, bean.getLastName());
		stmt.setString(4, bean.getloginId());
		stmt.setString(5, bean.getPassword());
		stmt.setString(6, bean.getAddress());

		int i = stmt.executeUpdate();
		System.out.println("Data Inserted : " + i);
		conn.close();
	}

	public UserBean Update(UserBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"Update user set first_name = ?, last_name = ?, loginId = ?, password = ?, address = ? where id = ?");
		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getloginId());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getAddress());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("Data Updated : " + i);
		return bean;
	}

	public void delete(int id) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from user where id = ?");
		stmt.setInt(1, id);
		int i = stmt.executeUpdate();
		conn.close();
		System.out.println("Data Deleted : " + i);
	}

	public List search() throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from user");
		ResultSet rSet = stmt.executeQuery();

		ArrayList list = new ArrayList();

		UserBean bean = null;

		while (rSet.next()) {
			bean = new UserBean();

			bean.setId(rSet.getInt(1));
			bean.setFirstName(rSet.getString(2));
			bean.setLastName(rSet.getString(3));
			bean.setloginId(rSet.getString(4));
			bean.setPassword(rSet.getString(5));
			bean.setAddress(rSet.getString(6));

			list.add(bean);
		}
		return list;
	}

	public List dynamicSearch(UserBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		StringBuffer sbff = new StringBuffer("select * from user where 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sbff.append(" and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sbff.append(" and first_name like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sbff.append(" and last_name like '" + bean.getLastName() + "%'");
			}
		}
		PreparedStatement ps = conn.prepareStatement(sbff.toString());
		ResultSet rSet = ps.executeQuery();
		ArrayList list = new ArrayList();
		bean = null;

		while (rSet.next()) {

			bean = new UserBean();
			bean.setId(rSet.getInt(1));
			bean.setFirstName(rSet.getString(2));
			bean.setLastName(rSet.getString(3));
			bean.setloginId(rSet.getString(4));
			bean.setPassword(rSet.getString(5));
			bean.setAddress(rSet.getString(6));

			list.add(bean);
		}
		return list;
	}

	public UserBean authenticate(String loginId, String password) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where loginId = ? and password = ?");
		ps.setString(1, loginId);
		ps.setString(2, password);
		ResultSet rSet = ps.executeQuery();
		UserBean bean = null;
		while (rSet.next()) {
			bean = new UserBean();
			bean.setId(rSet.getInt(1));
			bean.setFirstName(rSet.getString(2));
			bean.setLastName(rSet.getString(3));
			bean.setloginId(rSet.getString(4));
			bean.setPassword(rSet.getString(5));
			bean.setAddress(rSet.getString(6));
		}
		return bean;
	}

	public UserBean findByPk(int id) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setloginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
		}
		return bean;
	}
}

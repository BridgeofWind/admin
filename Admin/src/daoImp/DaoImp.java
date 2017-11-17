package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import util.GetConnection;
import dao.Dao;
import entity.Admin;

public class DaoImp implements Dao {
	private Connection con;

	@Override
	public int addDao(Admin admin) throws Exception {
		String sql="INSERT INTO admin(userName,PASSWORD) VALUES(?,?)";		
		con=GetConnection.getCon();
		QueryRunner qr=new QueryRunner();
		int i=qr.update(con, sql, admin.getUserName(),admin.getPassword());	
		con.close();
		return i;
	}

	@Override
	public Admin findIdDao(String userName) throws Exception {
		String sql="SELECT userName FROM admin WHERE userName=?";
		con=GetConnection.getCon();
		QueryRunner qr=new QueryRunner();
		Admin admin=qr.query(con, sql, new BeanHandler<Admin>(Admin.class), userName);	
		con.close();
		return admin;
	}

	@Override
	public Boolean findAllDao(Admin admin) throws Exception {		
		String sql="SELECT * FROM admin WHERE userName=? AND PASSWORD=?";
		con=GetConnection.getCon();
		QueryRunner qr=new QueryRunner();
		admin=qr.query(con, sql, new BeanHandler<Admin>(Admin.class), admin.getUserName(),admin.getPassword());
		con.close();
		if(admin!=null){
			return true;
		}else{
			return false;
		}		
	}
}

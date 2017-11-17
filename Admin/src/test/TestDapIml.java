package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import util.GetConnection;
import entity.Admin;

public class TestDapIml {
	private Connection con;
	private PreparedStatement ps;
	Admin admin=new Admin();
	@Test
	public void addDaoTest() throws Exception {
		admin.setUserName("jack");
		admin.setPassword("jack");
		String sql="INSERT INTO admin(userName,PASSWORD) VALUES(?,?)";		
		con=GetConnection.getCon();
		QueryRunner qr=new QueryRunner();
		int i=qr.update(con, sql, admin.getUserName(),admin.getPassword());	
		System.out.println(i);
	}
	
	public static void main(String args[]) throws Exception {
		String userName="jack";
		String sql="SELECT userName FROM admin WHERE userName=?";
		
		Connection con=GetConnection.getCon();
		
		QueryRunner qr=new QueryRunner();
		Admin admin=qr.query(con, sql, new BeanHandler<Admin>(Admin.class), userName);
		System.out.println(admin.getUserName());		
	}		
}

package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import dao.Dao;


public class GetConnection {	
	private static String name;
	private static String password;
	private static String jdbcDriver;
	private static String url;
	public static Connection getCon() throws Exception{			
			//��ȡdb.properties�ļ�������
			Properties pro=new Properties();
			InputStream in=Dao.class.getResourceAsStream("/db.properties");			
			pro.load(in);
			name=pro.getProperty("name");			
			password=pro.getProperty("password");
			url=pro.getProperty("url");
			jdbcDriver=pro.getProperty("jdbcDriver");
			//��������ע��
			Class.forName(jdbcDriver);
			//��ȡ����
			Connection con=DriverManager.getConnection(url, name, password);
			return con;
	}
}

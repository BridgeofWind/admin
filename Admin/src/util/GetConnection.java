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
			//获取db.properties文件的内容
			Properties pro=new Properties();
			InputStream in=Dao.class.getResourceAsStream("/db.properties");			
			pro.load(in);
			name=pro.getProperty("name");			
			password=pro.getProperty("password");
			url=pro.getProperty("url");
			jdbcDriver=pro.getProperty("jdbcDriver");
			//驱动程序注册
			Class.forName(jdbcDriver);
			//获取连接
			Connection con=DriverManager.getConnection(url, name, password);
			return con;
	}
}

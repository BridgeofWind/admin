package service;

import dao.Dao;
import daoImp.DaoImp;
import entity.Admin;

public class LoginService {
	
	public Boolean Login(Admin admin) throws Exception{
		Dao dao=new DaoImp();
		Boolean flag=dao.findAllDao(admin);
		return flag;
	}
}

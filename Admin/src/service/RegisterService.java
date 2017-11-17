package service;

import dao.Dao;
import daoImp.DaoImp;
import entity.Admin;

public class RegisterService {
	public Boolean Register(Admin admin) throws Exception{
		Dao dao=new DaoImp();		
		Admin adm=dao.findIdDao(admin.getUserName());			
		if(adm==null){
			dao.addDao(admin);
			return true;			
		}else{
			return false;
		}
	}
}

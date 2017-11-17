package dao;

import entity.Admin;

public interface Dao {
	public int addDao(Admin admin)throws Exception;
	public Admin findIdDao(String userName)throws Exception;
	public Boolean findAllDao(Admin admin)throws Exception;
}

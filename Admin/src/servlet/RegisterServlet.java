package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import service.RegisterService;
import dao.Dao;
import daoImp.DaoImp;
import entity.Admin;

public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		Admin admin=new Admin();		
		try {
			BeanUtils.copyProperty(admin, "userName", request.getParameter("userName"));
			BeanUtils.copyProperty(admin, "password", request.getParameter("password"));			
			RegisterService re=new RegisterService();			
			Boolean flag=re.Register(admin);
			if(flag==true){
				request.setAttribute("success", admin.getUserName());
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}else{
				request.setAttribute("erro", "用户名已经存在，请重新输入！");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}

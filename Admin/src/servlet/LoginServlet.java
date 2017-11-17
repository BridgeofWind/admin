package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.LoginService;
import entity.Admin;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Admin admin=new Admin();
		LoginService loginSer=new LoginService();
		try {
			BeanUtils.copyProperty(admin, "userName", request.getParameter("userName"));
			BeanUtils.copyProperty(admin, "password", request.getParameter("password"));
			Boolean flag=loginSer.Login(admin);
			if(flag==true){
				request.setAttribute("success", admin.getUserName());
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}else{
				request.setAttribute("erro","用户名或密码错误，请重新输入！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (IllegalAccessException e) {
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

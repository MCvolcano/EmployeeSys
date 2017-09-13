package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao_bak;
import com.entity.Employee;
import com.service.IEmployeeService;
import com.service.impl.EmployService;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private EmployeeDao dao = new EmployeeDao();
    private IEmployeeService empService = new EmployService();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//name, sex, age, qq, phone, email
		//String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String qq = request.getParameter("qq");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		Employee e = new Employee();
		//e.setId(Integer.parseInt(id));
		e.setName(name);
		e.setAge(Integer.parseInt(age));
		e.setSex(sex);
		e.setEmail(email);
		e.setPhone(phone);
		e.setQq(qq);
		
		//从service中执行添加操作
		try {
			empService.addEmp(e);
			response.sendRedirect(request.getContextPath() + "/ListServlet");

		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
		/*//判断是否存在相同名称的数据
		Employee employee = dao.findByName(name);
		if(employee == null) {
			dao.addEmployee(e);//执行添加操作
			
			response.sendRedirect(request.getContextPath() + "/ListServlet");
			
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

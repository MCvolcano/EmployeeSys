package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Employee;
import com.service.IEmployeeService;
import com.service.impl.EmployService;

/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private EmployeeDao dao = new EmployeeDao();
	private IEmployeeService empService = new EmployService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");

		try {
			Employee employee = empService.findEmyById(Integer.parseInt(id));

			if (employee != null) {
				request.setAttribute("emp", employee);
				request.getRequestDispatcher("/update.jsp").forward(request, response);
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Employee;
import com.service.IEmployeeService;
import com.service.impl.EmployService;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private EmployeeDao dao = new EmployeeDao();
	private IEmployeeService empService = new EmployService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee> list = empService.findAllEmps();
			
			
			//分页数据
			 String p = req.getParameter("page");
	        int page;
	        try {
	            //当前页数
	            page = Integer.valueOf(p);
	        } catch (NumberFormatException e) {
	            page = 1;
	        }
	        //用户总数
	        int totalUsers = list.size();
	        //每页用户数
	        int usersPerPage = 10;
	        //总页数
	        int totalPages = totalUsers % usersPerPage == 0 ? totalUsers / usersPerPage : totalUsers / usersPerPage + 1;
	        //本页起始用户序号
	        int beginIndex = (page - 1) * usersPerPage;
	        //本页末尾用户序号的下一个
	        int endIndex = beginIndex + usersPerPage;
	        if (endIndex > totalUsers)
	            endIndex = totalUsers;
	        req.setAttribute("totalUsers", totalUsers);
	        req.setAttribute("usersPerPage", usersPerPage);
	        req.setAttribute("totalPages", totalPages);
	        req.setAttribute("beginIndex", beginIndex);
	        req.setAttribute("endIndex", endIndex);
	        req.setAttribute("page", page);
		
			
			//保存数据
			req.setAttribute("list", list);
			req.getRequestDispatcher("/list.jsp").forward(req, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

/*Complaint Servlet*/
package com;

import com.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemsAPI
 */
@WebServlet("/EmployeeAPI")
public class EmployeeAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Employee employeeObj = new Employee();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String output = employeeObj.insertemployee(request.getParameter("empID"), request.getParameter("fname"),
				request.getParameter("gender"), request.getParameter("nic"), request.getParameter("number"),
				request.getParameter("email"), request.getParameter("password"), request.getParameter("address"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = employeeObj.updateemployee(paras.get("hidItemIDSave").toString(), paras.get("empID").toString(),
				paras.get("fname").toString(), paras.get("gender").toString(), paras.get("nic").toString(),
				paras.get("number").toString(), paras.get("email").toString(), paras.get("password").toString(),
				paras.get("address").toString());
		response.getWriter().write(output);
	}

	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = employeeObj.deleteemployee(paras.get("empNo").toString());
		response.getWriter().write(output);
	}

}

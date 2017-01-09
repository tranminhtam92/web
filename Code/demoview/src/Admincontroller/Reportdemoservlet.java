package Admincontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Reportdemo;

/**
 * Servlet implementation class Reportdemoservlet
 */
@WebServlet(urlPatterns={"/Reportdemoservlet"})
public class Reportdemoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reportdemoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Reportdemo report=new Reportdemo();
		Map<String, Object> param=new HashMap<String,Object>();
		String pathjrxml="E:\\tai lieu\\totnghiep\\Code\\demoview\\WebContent\\report\\soluongsanphamkhachdat.jrxml";request.getServletContext().getRealPath("/reprot/Blank_A4.jrxml");
	
		//response.getWriter().write(pathjrxml);
		report.report(response, param, pathjrxml);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Reportdemo report=new Reportdemo();
		Map<String, Object> param=new HashMap<String,Object>();
		String pathjrxml=request.getServletContext().getRealPath("/reprot/Blank_A4.jrxml");
		report.report(response, param, pathjrxml);
	}
	
		
	
}

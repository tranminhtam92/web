package Admincontroller;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Reportdemo;

/**
 * Servlet implementation class Exportbill
 */
@WebServlet(urlPatterns={"/Exportbill"})
public class Exportbill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exportbill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int maddh=Integer.parseInt(request.getParameter("ordercode"));
		
		Reportdemo report=new Reportdemo();
		Map<String, Object> param=new HashMap<String,Object>();
		String pathjrxml="E:\\tai lieu\\totnghiep\\Code\\demoview\\WebContent\\report\\hoadon.jrxml";
		report.reportbill(response, param, pathjrxml, maddh);
	}

}

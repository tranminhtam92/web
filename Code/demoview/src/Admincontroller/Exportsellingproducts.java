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
import Model.SanphamDAO;

/**
 * Servlet implementation class Exportsellingproducts
 */
@WebServlet(urlPatterns={"/Exportsellingproducts"})
public class Exportsellingproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exportsellingproducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String thang=request.getParameter("month");
		String nam=request.getParameter("year");
		 Calendar cal = Calendar.getInstance();
		if(thang==null){
			thang=String.valueOf(cal.get(Calendar.MONTH)+1);
		}
		if(nam==null){
			nam=String.valueOf(cal.get(Calendar.YEAR));
		}
		String date=thang+"/1/"+nam;
		Reportdemo report=new Reportdemo();
		Map<String, Object> param=new HashMap<String,Object>();
		String pathjrxml="E:\\tai lieu\\totnghiep\\Code\\demoview\\WebContent\\report\\sanphambanchaytheothang.jrxml";
		report.reportsanphambanchay(response, param, pathjrxml, date);
	}

}

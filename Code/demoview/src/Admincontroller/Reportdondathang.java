package Admincontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Reportdemo;

/**
 * Servlet implementation class Reportdondathang
 */
@WebServlet(urlPatterns = { "/Reportdondathang" })
public class Reportdondathang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reportdondathang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Reportdemo report=new Reportdemo();
		Map<String, Object> param=new HashMap<String,Object>();
		String pathjrxml="E:\\tai lieu\\totnghiep\\Code\\demoview\\WebContent\\report\\dondathang.jrxml";
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("report") == "filler") {
			String casepeport = (String) session.getAttribute("fillcase");
			/*switch (casepeport) {
			case "1":

				break;
			case "2":

				break;
			case "3":

				break;
			case "4":

				break;
			case "5":

				break;
			case "6":

				break;
			case "7":

				break;
			case "8":

				break;
			case "9":

				break;
			case "10":

				break;
			case "11":

				break;
			case "12":

				break;
		
			}*/
			//Map<String, Object> param=new HashMap<String,Object>();
			//String pathjrxml="E:\\tai lieu\\totnghiep\\Code\\demoview\\WebContent\\report\\dondathang.jrxml";//request.getServletContext().getRealPath("/reprot/Blank_A4.jrxml");
			report.reportddhfiller(response, param, pathjrxml, casepeport);
		}
		else{
			if ((String) session.getAttribute("report") == "search"){
				String searchtype=(String) session.getAttribute("searchtype");
				String information=(String) session.getAttribute("information");
				report.reportsearchddh(response, param, pathjrxml, searchtype, information);
			}
			else{
				report.reportddh(response, param, pathjrxml);
			}
		}
	}

}

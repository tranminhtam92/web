package Admincontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dondathang;
import Model.DondathangDAO;
import Model.Donnhaphang;
import Model.DonnhaphangDAO;

/**
 * Servlet implementation class Report_revenues_and_expenditures
 */
@WebServlet(urlPatterns={"/Report_revenues_and_expenditures"})
public class Report_revenues_and_expenditures extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report_revenues_and_expenditures() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String thang=request.getParameter("month");
		String nam=request.getParameter("year");
		int tongthu=0;
		int tongchi=0;
		 Calendar cal = Calendar.getInstance();
		if(thang==null){
			thang=String.valueOf(cal.get(Calendar.MONTH)+1);
		}
		if(nam==null){
			nam=String.valueOf(cal.get(Calendar.YEAR));
		}
		String date=thang+"/1/"+nam;
		response.getWriter().append(date);
		DondathangDAO ddhDAO=new DondathangDAO();
		ArrayList<Dondathang> listddh=new ArrayList<>();
		listddh=ddhDAO.filler_ordermonth(date);
		DonnhaphangDAO dnhDAO=new DonnhaphangDAO();
		ArrayList<Donnhaphang> listdnh=new ArrayList<>();
		listdnh=dnhDAO.filler_importproductonemonth(date);
		for(int i=0;i<listddh.size();i++){
			tongthu+=listddh.get(i).getTongtien();
		}
		for(int i=0;i<listdnh.size();i++){
			tongchi+=listdnh.get(i).getTongtien();
		}
		request.setAttribute("list_order", listddh);
		request.setAttribute("list_importproduct", listdnh);
		request.setAttribute("month", thang);
		request.setAttribute("year", nam);
		request.setAttribute("thu", tongthu);
		request.setAttribute("chi", tongchi);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/report_revenues_and_expenditures.jsp");
		dispatcher.forward(request, response);
		
	}

}

package Conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.KhachhangDAO;

/**
 * Servlet implementation class CheckEmailServlet
 */
@WebServlet(urlPatterns={"/CheckEmailServlet"})
public class CheckEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhachhangDAO khDAO=new KhachhangDAO();
		//if(!khDAO.checkuser(request.getParameter("username"))){
			// response.getWriter().write("<img src='"+request.getContextPath()+"/hinhanh/available.png' />");
	        
		//}
		//else
			// response.getWriter().write("<img src='"+request.getContextPath()+"/hinhanh/available.png'/>");

		//doGet(request, response);
	}

}

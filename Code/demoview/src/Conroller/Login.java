package Conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.KhachhangDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns={"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =request.getParameter("username");
		String password= request.getParameter("password");
		KhachhangDAO khDAO= new KhachhangDAO();
		if(!khDAO.checkuser(username)){
			request.setAttribute("error","tên đăng nhập không tồn tại");
			RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/View/login.jsp");
	        dispatcher.forward(request, response);
	        return;
		}
		if(!khDAO.checkpass(password)){
			request.setAttribute("error","mật khẩu không đúng");
			RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/View/login.jsp");
	        dispatcher.forward(request, response);
	        return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("username",username);
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/");
        dispatcher.forward(request, response);
	}

}

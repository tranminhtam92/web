package Admincontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConnectDB.ConnectDB;
import Model.Nhanvien;
import Model.NhanvienDAO;
import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Adminemployee
 */
@WebServlet(urlPatterns={"/Adminemployee"})
public class Adminemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminemployee() {
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
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("adminusername");
		String password=(String)session.getAttribute("adminpassword");
		RequestDispatcher dispatcher;
		if(ConnectDB.getconnectDB(username, password)){
			ArrayList<Nhanvien>listnv=new ArrayList<>();
			NhanvienDAO nvDAO=new NhanvienDAO();
			String key=request.getParameter("key");
			String manhanvien="";
			String tennhanvien="";
			String sodienthoai="";
			String diachi="";
			switch (key) {
			case "edit":
				manhanvien=request.getParameter("employeecode");
				tennhanvien=request.getParameter("employeename");
				diachi=request.getParameter("employeeaddress");
				sodienthoai=request.getParameter("employeetel");
				nvDAO.updatnhanvien(manhanvien, tennhanvien, diachi, sodienthoai);
				listnv=nvDAO.getallnhanvien();
				request.setAttribute("list_employee", listnv);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_employee.jsp");
		        dispatcher.forward(request, response);
				//response.getWriter().append(maloai).append(request.getContextPath());
				break;
			case "add":
				manhanvien=request.getParameter("employeecode");
				tennhanvien=request.getParameter("employeename");
				diachi=request.getParameter("employeeaddress");
				sodienthoai=request.getParameter("employeetel");
				Nhanvien nv=new Nhanvien();
				if(!nvDAO.checknhanvien(manhanvien)){
				nvDAO.addnhanvien(manhanvien, tennhanvien, diachi, sodienthoai);
				listnv=nvDAO.getallnhanvien();
				request.setAttribute("list_employee", listnv);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_employee.jsp");
		        dispatcher.forward(request, response);
				}
				else{
					nv.setManhanvien(manhanvien);
					nv.setTennhanvien(tennhanvien);
					nv.setDiachi(diachi);
					nv.setSodienthoai(sodienthoai);
					request.setAttribute("employee",nv);
					request.setAttribute("error","Lỗi, nhân viên đã tồn tại");
					dispatcher = request.getServletContext()
			                 .getRequestDispatcher("/admin/Add_employee.jsp");
			        dispatcher.forward(request, response);
				}
			
				//response.getWriter().append(maloai).append(request.getContextPath());
				break;
			default:
				listnv=nvDAO.getallnhanvien();
				request.setAttribute("list_employee", listnv);
				dispatcher = request.getServletContext()
		                 .getRequestDispatcher("/admin/Manager_employee.jsp");
		         dispatcher.forward(request, response);
				break;
			}
		}
	}

}

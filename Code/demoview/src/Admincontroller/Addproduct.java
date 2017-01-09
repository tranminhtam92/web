package Admincontroller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import ConnectDB.ConnectDB;
import Model.Sanpham;
import Model.SanphamDAO;

/**
 * Servlet implementation class Addproduct
 */
@WebServlet(urlPatterns={"/Addproduct"})
public class Addproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addproduct() {
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
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("adminusername");
		String password = (String) session.getAttribute("adminpassword");
		RequestDispatcher dispatcher;
		if (ConnectDB.getconnectDB(username, password)) {
			Sanpham sp=new Sanpham();
			ArrayList<Sanpham> listproduct = new ArrayList<>();
			SanphamDAO spDAO = new SanphamDAO();
			String masp = "";
			String tensp = "";
			int gia=0;
			String donvitinh="";
			int soluong=0;
			String mota = "";
			String anh = "";
			String ngay = "";
			int khuyenmai=0;
			boolean sanphammoi=false;
			String maloai = "";
			PrintWriter writer = response.getWriter();
			if (!ServletFileUpload.isMultipartContent(request)) {
				// if not, we stop here

				writer.println("Error: Form must has enctype=multipart/form-data.");
				writer.flush();
				return;
			}
			FileItemFactory itemfatocry = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(itemfatocry);

			ArrayList<FileItem> items;
			try {
				items = (ArrayList<FileItem>) upload.parseRequest(request);
				for (FileItem item : items) {
		
					if(item.isFormField()){
						switch (item.getFieldName()) {
						case "productcode":
							masp=item.getString();
							break;
						case "productname":
							tensp=item.getString();
							writer.println(item.getString());
							break;
						case "productamount":
							gia=Integer.parseInt(item.getString());
							break;
						case "productdvt":
							donvitinh=item.getString();
							break;
						case "productquantity":
							soluong=Integer.parseInt(item.getString());
							break;
						case "productdescription":
							mota=item.getString();
							break;
						case "day":
							ngay=item.getString();
							break;
						case "sale":
							khuyenmai=Integer.parseInt(item.getString());
							break;
						case "newproduct":
							sanphammoi=Boolean.parseBoolean(item.getString());
							break;
						case "producttypecode":
							maloai=item.getString();
							break;
						default:
							break;
						}
					}
					String contenttype = item.getContentType();
					if (contenttype != null) {
						if (contenttype.equals("image/png") || contenttype.equals("image/jpeg")) {
							File uploadir = new File(getServletContext().getRealPath("") + "/hinhanh");
							// writer.println(getServletContext().getRealPath(""));
							// writer.println(uploadir.getAbsolutePath());
							// writer.println(uploadir.getName());
							File file = new File(uploadir.getAbsolutePath() + "/" + item.getName());
							try {
								if (!file.exists()) {
									item.write(file);
								}

								// writer.println(file.getAbsolutePath());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								writer.print("1");
							}
							anh=item.getName();
						}
					}

				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				writer.print("2");
			}
				spDAO.insertsanpham(masp, tensp, gia, donvitinh, anh, soluong, mota, ngay, maloai, khuyenmai, sanphammoi);
			listproduct=spDAO.searchproduct("");
			request.setAttribute("list_product", listproduct);
			dispatcher = request.getServletContext()
	                 .getRequestDispatcher("/admin/Manager_product.jsp");
	         dispatcher.forward(request, response);
		}
	}

}

package Conroller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import javax.swing.text.StringContent;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class nhap
 */
@WebServlet(urlPatterns={"/nhap"})
public class nhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nhap() {
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
		PrintWriter writer = response.getWriter();
	    if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
	    FileItemFactory itemfatocry=new DiskFileItemFactory();
	    ServletFileUpload upload=new ServletFileUpload(itemfatocry);
	   
	        ArrayList<FileItem> items;
			try {
				items = (ArrayList<FileItem>) upload.parseRequest(request);
				for(FileItem item:items){
		        	String contenttype=item.getContentType();
		        	if(item.isFormField())
		        	writer.println(item.getString());
		        	if(contenttype!=null){
		        		if(!contenttype.equals("image/png")){
		        		continue;
		        	}
		        	File uploadir=new File(getServletContext().getRealPath("")+"/hinhanh");
		        	writer.println(getServletContext().getRealPath(""));
		        	writer.println(uploadir.getAbsolutePath());
		        	writer.println(uploadir.getName());
		        	File file=new File(uploadir.getAbsolutePath()+"/"+item.getName());
		        	try {
		        		if(!file.exists()){
		        			item.write(file);
		        		}
		        		else{
		        			writer.println("fi da ton tai");
		        		}
						writer.println(file.getAbsolutePath());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						writer.print("1");
					}
		        	  writer.println(item.getContentType());
		        	  String a=item.getName();
		        	  
		        	  writer.println(item.getName());
		        	  writer.println(item.getFieldName());
		        	  writer.println(item.getHeaders());
		        	}
		        	
		        }
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				writer.print("2");
			}
	        
	  
	
		//doGet(request, response);
	}

}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-11-07 08:28:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/View/Content1.jsp", Long.valueOf(1477417442335L));
    _jspx_dependants.put("/View/Header.jsp", Long.valueOf(1477416999158L));
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.4.jar", Long.valueOf(1460126261370L));
    _jspx_dependants.put("/View/Nav.jsp", Long.valueOf(1478504615519L));
    _jspx_dependants.put("jar:file:/E:/tai%20lieu/totnghiep/Code/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/demoview/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.4.jar!/META-INF/c.tld", Long.valueOf(1420530628000L));
    _jspx_dependants.put("/View/Footer.jsp", Long.valueOf(1477417529460L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\r\n");
      out.write("<link href=\"Style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<title>Web ban hai san</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link href=\"Style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<title>header</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t\t<img alt=\"eror\" src=\"../hinhanh/cooltext167942677404796.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"hotline\">\r\n");
      out.write("\t\t\t\t<img alt=\"eror\" src=\"../hinhanh/sdt.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"chucnang\">\r\n");
      out.write("\t\t\t\t<div id=\"search\">\r\n");
      out.write("\t\t\t\t\t<form action=\"#\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"txtsearch\"> <input type=\"submit\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"btnsearch\" value=\"tim\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"giohang\">\r\n");
      out.write("\t\t\t\t\t<form action=\"#\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" name=\"btngiohang\" value=\"giohang\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"thongtin\">\r\n");
      out.write("\t\t\t\t\t<form action=\"#\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" name=\"btnthongtin\" value=\"thongtin\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>nav</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"nav\">\r\n");
      out.write("\t\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Trang chu</a>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">cá</a>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Tom</a>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Muc</a>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Ghe</a>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Oc - So</a>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"account\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Dang nhap</a>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\">Dang ky</a>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Content</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t<div class=\"danhmuc\">\r\n");
      out.write("\t\t\t\t<div id=\"title\">San pham ban chay</div>\r\n");
      out.write("\t\t\t\t<div id=\"product\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"danhmuc\">\r\n");
      out.write("\t\t\t\t<div id=\"title\">Ca</div>\r\n");
      out.write("\t\t\t\t<div id=\"product\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"danhmuc\">\r\n");
      out.write("\t\t\t<div id=\"title\">Tom</div>\r\n");
      out.write("\t\t\t\t<div id=\"product\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"danhmuc\">\r\n");
      out.write("\t\t\t<div id=\"title\">Muc</div>\r\n");
      out.write("\t\t\t\t<div id=\"product\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"danhmuc\">\r\n");
      out.write("\t\t\t<div id=\"title\">Ghe</div>\r\n");
      out.write("\t\t\t\t<div id=\"product\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"danhmuc\">\r\n");
      out.write("\t\t\t<div id=\"title\">Oc</div>\r\n");
      out.write("\t\t\t\t<div id=\"product\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t\t<li><img src=\"../hinhanh/cacang.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t<p>ca cang</p>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>250 k/kg</h3>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Footer</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("\t\t<h3>Thong tin lien he</h3><a href=\"#\"><img src=\"../hinhanh/logofb.jpg\"> </a>\r\n");
      out.write("\t\t\t<p>moi chi tiet xin lien he :\r\n");
      out.write("\t\t\t<p>anh Le Khanh Quang\r\n");
      out.write("\t\t\t<p>so dien thoai: 01627157704</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

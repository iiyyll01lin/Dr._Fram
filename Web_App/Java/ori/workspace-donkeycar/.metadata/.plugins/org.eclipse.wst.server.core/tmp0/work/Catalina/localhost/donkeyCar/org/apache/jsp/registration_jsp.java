/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.41
 * Generated at: 2021-02-13 15:33:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1610723335666L));
    _jspx_dependants.put("jar:file:/D:/AIOT08/Servlet/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/donkeyCar/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>註冊帳號</title>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://bootswatch.com/4/darkly/bootstrap.min.css\">\r\n");
      out.write("<link href=\"css/all.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"homepage\">\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"row mt-5\">\r\n");
      out.write("\t\t\t<div class=\"col-md-6 m-auto\">\r\n");
      out.write("\t\t\t\t<div class=\"card card-body\">\r\n");
      out.write("\t\t\t\t\t<h1 class=\"text-center mb-3\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fas fa-cat\"></i>註冊帳號\r\n");
      out.write("\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/register\" method=\"post\" onsubmit=\"return validate()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"account1\">姓名</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\" id=\"account1\" placeholder=\"Username\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"name\" required><br>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"accountM\">使用者帳號</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"accountM\" class=\"form-control\" placeholder=\"Useremail\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"account\" required><br>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"pwd1\">密碼</label> <input type=\"password\" id=\"pwd1\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Password\" class=\"form-control\" name=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired><br>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"adr1\">地址</label> <input type=\"text\" id=\"adr1\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Address\" class=\"form-control\" name=\"address\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired><br>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"tel1\">聯絡方式</label> <input type=\"text\" id=\"tel1\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Contact\" class=\"form-control\" name=\"contact\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired><br>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary btn-block\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"Register\">註冊</button>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"lead mt-4\">\r\n");
      out.write("\t\t\t\t\t\t\t已經有帳號了? <a href=\"index.jsp\">登入</a>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("\t\tintegrity=\"sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW\"\r\n");
      out.write("\t\tcrossorigin=\"anonymous\"></script>\r\n");
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

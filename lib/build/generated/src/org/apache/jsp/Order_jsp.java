package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Order_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/shopping.css\">\n");
      out.write("        <title>Đặt hàng</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"col-lg-6\">\n");
      out.write("           \n");
      out.write("            <div class=\"p-4\">\n");
      out.write("                <form action=\"#\" method=\"post\" onclick=\"alert(Đặt hàng thành công)\">\n");
      out.write("                     <div class=\"bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold\">Thông tin mua hàng</div>\n");
      out.write("                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <div class=\"input-group mb-4 border rounded-pill p-2\">\n");
      out.write("                            <input type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" aria-describedby=\"button-addon3\" class=\"form-control border-0\">\n");
      out.write("                        </div>\n");
      out.write("                    </c:if>\n");
      out.write("                    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.acc == null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <div class=\"input-group mb-4 border rounded-pill p-2\">\n");
      out.write("                            <input type=\"text\" name=\"name\" placeholder=\"Họ Tên\" aria-describedby=\"button-addon3\" class=\"form-control border-0\" required=\"\">\n");
      out.write("                        </div>\n");
      out.write("                    </c:if>\n");
      out.write("                    <div class=\"input-group mb-4 border rounded-pill p-2\">\n");
      out.write("                        <input type=\"text\" name=\"address\" placeholder=\"Địa chỉ\" aria-describedby=\"button-addon3\" class=\"form-control border-0\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-group mb-4 border rounded-pill p-2\">\n");
      out.write("                        <input type=\"number\" name=\"phone\" placeholder=\"Số điện thoại\" aria-describedby=\"button-addon3\" class=\"form-control border-0\" required=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-group-append border-0\">\n");
      out.write("                        <input  id=\"button-addon3\" type=\"submit\" value=\"Đặt Hàng\"  class=\"btn btn-dark px-4 rounded-pill\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("    <!-- ----------------Website features--------- -->\n");
      out.write("\n");
      out.write("    <section class=\"website-fratures\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-3 feature-box\">\n");
      out.write("                    <i class=\"fa fa-heart\" aria-hidden=\"true\"></i>\n");
      out.write("                    <div class=\"feature-text\">\n");
      out.write("                        <p><b>100% Original items </b>are available at company</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 feature-box\">\n");
      out.write("                    <i class=\"fa fa-retweet\" aria-hidden=\"true\"></i>\n");
      out.write("                    <div class=\"feature-text\">\n");
      out.write("                        <p><b>Return within 30 days </b>of receiving your order.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 feature-box\">\n");
      out.write("                    <i class=\"fa fa-truck\" aria-hidden=\"true\"></i>\n");
      out.write("                    <div class=\"feature-text\">\n");
      out.write("                        <p><b>Get free delivery for every </b>order on more than price.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 feature-box\">\n");
      out.write("                    <i class=\"fa fa-credit-card-alt\" aria-hidden=\"true\"></i>\n");
      out.write("                    <div class=\"feature-text\">\n");
      out.write("                        <p><b>Pay Online through multiple </b>options (card/Net banking)</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class changeAccord_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/principalMenu.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Modificado Acuerdo</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<link href=\"css/menu.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<div class=\"wrapperMenu\">\r\n");
      out.write("    <!--Navigation Start-->\r\n");
      out.write("    <nav class=\"navigation\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li class=\"active\">\r\n");
      out.write("                <a href=\"index.jsp\">Gestor de acuerdos</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"#\">Acuerdos</a>\r\n");
      out.write("                <ul class=\"children sub-menu\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"addAccord.jsp\">Registrar</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"listAccord.jsp\">Lista</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"changeAcord.jsp\">Modificar</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"\">Actas</a>    \r\n");
      out.write("                <ul class=\"children sub-menu\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">Registrar</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a href=\"#\">Modificar</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li >\r\n");
      out.write("                <a href=\"#\">Perfil</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"last\">\r\n");
      out.write("                <a href=\"#\">Salir</a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <!--Navigation End-->\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("        </div> \r\n");
      out.write("        <div id =\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <section class=\"container\" id=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <form action=\"\">\r\n");
      out.write("                            <div  class=\"form-group row\">\r\n");
      out.write("                                <label for=\"\" class=\"col-2 col-form-label\"> Oficio: </label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control col-10\" name=\"office\"> \r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"\" class=\"col-7 col-form-label\">Fecha de sesión:</label>\r\n");
      out.write("                                <input type=\"date\" class=\"form-control col-4\" name =\"incorporatedDate\">\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"\" class=\"col-7 col-form-label\">Vencimiento:</label>\r\n");
      out.write("                                <input type=\"date\" class=\"form-control col-4\" name=\"deadline\">\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"\" class=\"col-2 col-form-label\"> Observaciones</label>\r\n");
      out.write("                                <input type=\"text\" placeholder=\"Digite en este espacio sus observaciones\" class=\"form-control col-10\" name =\"observations\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <label for=\"\">Adjuntar archivo:</label>\r\n");
      out.write("                                <input type='file' name='archivo1' id='archivo1' placeholder=\"Inserte aquí el PDF\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-light\">Cancelar</button>\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-light\">Agregar</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("            </section>            \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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

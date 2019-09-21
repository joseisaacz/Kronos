package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listAccord_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"css/default.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/datatables.min.css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\"  type=\"text/css\" href=\"css/dataTables.bootstrap4.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/67596e9ec2.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <title>Lista de Acuerdos</title>\r\n");
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
      out.write("        <div style=\"height:100px\"></div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <div class=\"table-responsive\">        \r\n");
      out.write("                        <table id=\"tableAcc\" class=\"table table-striped table-bordered border-info\" style=\"width:100%\">\r\n");
      out.write("                            <thead class=\"toast-header\">\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th style=\"text-align: center\">Nombre</th>\r\n");
      out.write("                                    <th style=\"text-align: center\">Numero de sesion</th>\r\n");
      out.write("                                    <th style=\"text-align: center\">Fecha</th>\r\n");
      out.write("                                    <th style=\"text-align: center\">Editar</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </thead>\r\n");
      out.write("                            <tbody>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-01-19</td>\r\n");
      out.write("                                    <td>01-19</td>\r\n");
      out.write("                                    <td>09/19/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-02-19</td>\r\n");
      out.write("                                    <td>02-19</td>\r\n");
      out.write("                                    <td>09/20/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-03-19</td>\r\n");
      out.write("                                    <td>03-19</td>\r\n");
      out.write("                                    <td>02/06/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-04-19</td>\r\n");
      out.write("                                    <td>04-19</td>\r\n");
      out.write("                                    <td>09/14/2019</td>\r\n");
      out.write("                                   <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-05-19</td>\r\n");
      out.write("                                    <td>05-19</td>\r\n");
      out.write("                                    <td>01/17/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-06-19</td>\r\n");
      out.write("                                    <td>06-19</td>\r\n");
      out.write("                                    <td>09/18/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-07-19</td>\r\n");
      out.write("                                    <td>07-19</td>\r\n");
      out.write("                                    <td>06/13/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-08-19</td>\r\n");
      out.write("                                    <td>08-19</td>\r\n");
      out.write("                                    <td>02/05/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-09-19</td>\r\n");
      out.write("                                    <td>09-19</td>\r\n");
      out.write("                                    <td>01/12/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-10-19</td>\r\n");
      out.write("                                    <td>10-19</td>\r\n");
      out.write("                                    <td>05/18/2019</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <td>OFICIO MSPH-CM-ACUERDO-11-19</td>\r\n");
      out.write("                                    <td>11-19</td>\r\n");
      out.write("                                    <td>01/01/2018</td>\r\n");
      out.write("                                    <td><button type=\"button\" style='text-align: center' class=\"btn btn-primary\" onclick=\"location.href = 'changeAccord.jsp'\">\r\n");
      out.write("                                            <i class=\"fas fa-edit\"></i></button></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("                            </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div> \r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/popper.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/datatables.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/englishToSpanish.js\" type=\"text/javascript\"></script>\r\n");
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

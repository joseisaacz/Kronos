<%-- 
    Document   : listAccord
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <%-- 
    Los de abajo son los de prueba
        --%>
        <link rel="stylesheet" type="text/css" href="css/datatables.min.css"/>
        <link rel="stylesheet"  type="text/css" href="css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Lista de Acuerdos</title>
    </head>
    <body>
        <div>
            <%@include file="principalMenu.jsp" %>
        </div> 
        <div style="height:150px"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">        
                        <table id="tableAcc" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Numero de sesion</th>
                                    <th>Fecha</th>
                                    <th>Acción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-01-19</td>
                                    <td>01-19</td>
                                    <td>09/19/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-02-19</td>
                                    <td>02-19</td>
                                    <td>09/20/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-03-19</td>
                                    <td>03-19</td>
                                    <td>02/06/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-04-19</td>
                                    <td>04-19</td>
                                    <td>09/14/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-05-19</td>
                                    <td>05-19</td>
                                    <td>01/17/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-06-19</td>
                                    <td>06-19</td>
                                    <td>09/18/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-07-19</td>
                                    <td>07-19</td>
                                    <td>06/13/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-08-19</td>
                                    <td>08-19</td>
                                    <td>02/05/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-09-19</td>
                                    <td>09-19</td>
                                    <td>01/12/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-10-19</td>
                                    <td>10-19</td>
                                    <td>05/18/2019</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-11-19</td>
                                    <td>11-19</td>
                                    <td>01/01/2018</td>
                                    <td><button type="button" class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">Modificar</button></td>
                                </tr>
                            <%-- 
                                every time the function calls the list we need to add new btn to modify the accord.
                            --%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div> 
        </div>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <!-- datatables JS -->
        <script src="js/datatables.min.js" type="text/javascript"></script>
        
        <script src="js/main.js" type="text/javascript"></script>
    </body>
</html>

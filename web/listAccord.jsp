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
        <link rel="stylesheet" type="text/css" href="css/datatables.min.css"/>
        <link rel="stylesheet"  type="text/css" href="css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="https://kit.fontawesome.com/67596e9ec2.js" crossorigin="anonymous"></script>
        <title>Lista de Acuerdos</title>
    </head>
    <body>
        <div>
            <%@include file="principalMenu.jsp" %>
        </div> 
        <div style="height:100px"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">        
                        <table id="tableAcc" class="table table-striped table-bordered border-info" style="width:100%">
                            <thead>
                                <tr>
                                    <th style="text-align: center">Nombre</th>
                                    <th style="text-align: center">Numero de sesion</th>
                                    <th style="text-align: center">Fecha</th>
                                    <th style="text-align: center">Editar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-01-19</td>
                                    <td>01-19</td>
                                    <td>09/19/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-02-19</td>
                                    <td>02-19</td>
                                    <td>09/20/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-03-19</td>
                                    <td>03-19</td>
                                    <td>02/06/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-04-19</td>
                                    <td>04-19</td>
                                    <td>09/14/2019</td>
                                   <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-05-19</td>
                                    <td>05-19</td>
                                    <td>01/17/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-06-19</td>
                                    <td>06-19</td>
                                    <td>09/18/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-07-19</td>
                                    <td>07-19</td>
                                    <td>06/13/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-08-19</td>
                                    <td>08-19</td>
                                    <td>02/05/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-09-19</td>
                                    <td>09-19</td>
                                    <td>01/12/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-10-19</td>
                                    <td>10-19</td>
                                    <td>05/18/2019</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
                                </tr>
                                <tr>
                                    <td>OFICIO MSPH-CM-ACUERDO-11-19</td>
                                    <td>11-19</td>
                                    <td>01/01/2018</td>
                                    <td><button type="button" style='text-align: center' class="btn btn-primary" onclick="location.href = 'changeAccord.jsp'">
                                            <i class="fas fa-edit"></i></button></td>
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
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/datatables.min.js" type="text/javascript"></script>
        <script src="js/englishToSpanish.js" type="text/javascript"></script>
    </body>
</html>

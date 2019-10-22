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
        <link rel="stylesheet"  type="text/css" href="css/dataTables.bootstrap4.min.css">
        <title>Lista de Acuerdos</title>
    </head>
    <body>
        <div>
            <%@include file="principalMenu.jsp" %>
        </div> 
        <div style="height:100px"></div>
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <select class="form-control" id="serchType" onchange="changeSelect(this.value)">
                            <option value="notSelected">Elija una opción</option>
                            <option value="sessionDate">Fecha de Sesión</option>
                            <option value="incorDate">Fecha de Incorporación</option>
                            <option value="sessionType">Tipo de Acuerdo</option>
                            <option value="accNumber">Número de Oficio</option>
                            <option value="expiredAccords">Acuerdos Vencidos</option>
                            <option value="allAccords">Todos los Acuerdos</option>
                           
                        </select> 
                    </div>
                    <div class="col-sm-4" id="searchDiv">
                        <input type="hidden"  class="form-control" id ="searchText">
                         <select   class="form-control" id="selectType" style="visibility: hidden" >  </select>
                    </div>
                        <div class="col-sm-4" id="searchDiv">
                              <button type="button" style="visibility: hidden" class="btn btn-success" id="seacrhButton" onclick="searchAccord()">Buscar</button>
                        </div>    
                    

                </div>
            </div>
            <div class ="row">
                <span style="white-space: pre-line"></span>
                <br/>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive">        
                            <table id="tableAcc" class="table table-striped table-bordered border-info" style="width:100%">
                                <thead>
                                    <tr>
                                        <th style="text-align: center">Número de Oficio</th>
                                        <th style="text-align: center">Fecha de Incorporación</th>
                                        <th style="text-align: center">Fecha de Sesión</th>
                                        <th style="text-align: center">Fecha de Vencimiento</th>
                                        <th style="text-align: center">Tipo</th>
                                        <th style="text-align: center">Estado</th>
                                        <th style="text-align: center">Editar</th>
                                    </tr>
                                </thead>
                                <tbody id="accordList">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                <script src="https://kit.fontawesome.com/67596e9ec2.js" crossorigin="anonymous"></script>
                  <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
           <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
<!--        <script src="js/englishToSpanish.js" type="text/javascript"></script>-->
        <script src="js/listAccord.js" type="text/javascript"></script>
    </body>
</html>
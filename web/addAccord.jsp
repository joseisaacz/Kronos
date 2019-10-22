<%--
    Document   : addAccord
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title id="prinTitle">Agregar acuerdo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            <%@include file="principalMenu.jsp" %>
        </div>
        <div id="wrapper">
            <div class="container" >
                <div class="border-bottom" style="width: 97%">
                    <div class="row" style="background-color: white; width: 50%; border-radius: 50px 50px 1px 1px; background-color: #1f3140; border: solid #003366">
                        <div class="col-12">
                            <h3 align="center" style="color: #BBC9B4"id="pageTitle">Agregar Acuerdo</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container" id="container" style="border-radius: 1px 50px 50px 50px; border: solid #003366">
                <form id="uploadForm"  enctype="multipart/form-data" method="POST" action="javascript:addAccord()">
                    <div class="border-bottom">
                        <div class="row">
                            <div class="col-3">
                                <div class="form-group">
                                    <div class="col-sm-8">
                                        <label for="form-control col-4" class="form-label">Fecha de Sesion:</label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="form-group">
                                    <div class="col-sm-8">
                                        <input id="generalSession" name="generalSession"class="form-control" type="date" required>
                                    </div>
                                </div>
                         
                            </div>
                                    <div class="custom-control custom-switch" id='divSwitch'>
                                <input type="checkbox" class="custom-control-input" id="customSwitch1" checked onchange="changeSwitch(this)">
                                <label class="custom-control-label" for="customSwitch1">Click para editar Fecha</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <span class="border-warning">
                                <div class="form-group">
                                    <div class="col-sm-10">
                                        <label for="form-control col-4" class="form-label">Oficio:</label>
                                        <input type="text" class="form-control" name="desc" value="MSPH-CM-ACUER-" disabled>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" id="office" name="office" required>
                                    </div>
                                </div>
                            </span>
                        </div>
                        
                        <div id="divDeadline" class="col">
                            <div class="form-group">
                                <div class="col-sm-11">
                                    <label for="form-control" class="form-label" >Plazo(Dias):</label>
                                    <input type="number" class="form-control" name="days" id="days" onkeypress="return event.charCode >= 48" min="0" required>
                                    <select class="form-control" id="comboDays" name="comboDays">
                                        <option value="1">Laborales</option>
                                        <option value="2">Naturales</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <div class="col-sm-11">
                                    <label for="form-control" class="form-label" >Vencimiento:</label>
                                    <input type="date" class="form-control" name="deadline" id="deadline" disabled="true">
                                    <button class="btn btn-outline-primary" type="button" onclick="javascript:setDeadline()" id="daysButton" name="daysButton">Confirmar Plazo</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-group ">
                                <div class="col-8">
                                    <label for="form-control col-6" class="form-label"> Tipo de acuerdo: </label>
                                    <select  class="form-control" id="comboTypes" name="comboTypes" onchange="changeComboType()"></select>
                                </div>
                                  <div class="col-8">   
                                <label for="form-control col-6" class="form-label" id="labelState" style="visibility: hidden">Estado:</label>
                                <select  class="form-control" id="comboStates" name="comboStates" style="visibility: hidden"> </select>
                                  </div>
                                  </div>
                        </div>
                        <div class="col">
                            <div class="form-group ">
                                <label id="labelName" for="form-control col-9" class="form-label" style="visibility: hidden"> Nombre del Responsable </label>
                                <input type="hidden" class="form-control" name="username" id="username">
                            </div>
                            <div class="form-group ">
                                <label id="labelEmail" for="form-control col-9" class="form-label" style="visibility: hidden"> Correo Electronico del Responsable </label>
                                <input type="hidden" class="form-control" name="email" id="email">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                        
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-group ">
                                <div class="col-12">
                                    <label for="" class="form-label" > Observaciones</label>
                                    <textarea  placeholder="Digite en este espacio sus observaciones" class="form-control" rows="5" cols="40" name ="observations" id="observations" rows="3" style ="resize: none"></textarea>
                                </div>
                            </div>
                        </div>
                        <%-- DRAG and DROP zone --%>
                        <div class="col">
                            <div class="form-group files" id="files">
                                <label for="form-control" class="form-label"> Inserte aquí el pdf </label>
                                <input type="file" class="form-control" name="accord" id="accord" placeholder="Inserte aquí el PDF" required multiple  accept="application/pdf">
                            </div>
                            <div class="table-responsive" id="table" style="display: none">   
                                 <label for="table table-striped table-bordered border-info" class="form-label"> PDF </label>
                            <table id="tablePdf" class="table table-striped table-bordered border-info">
                                <thead>
                                    <tr>
                                        <th style="text-align: center">Nombre</th> 
                                        <th style="text-align: center">Ver PDF</th>
                                        <th style="text-align: center">Borrar PDF</th>
                                       
                                    </tr>
                                </thead>
                                <tbody id="pdfList">
                                </tbody>
                            </table>
                              
                        </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <button type="submit" class="btn btn-outline-success" id="okButton" >Agregar</button>
                        </div>
                        <div class="col-md-4">
                            <button type="button" class="btn btn-outline-danger" id="cancelButton" onclick='javascript:cancelAction()'>Cancelar</button>
                        </div>
                        
                        <div id="divDeleteButton" class="col-md-4" style="visibility: hidden">
                            <button type="button" class="btn btn-outline-danger" id="deleteButton" >Eliminar Acuerdo</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/login.js" type="text/javascript"></script>
        <script src="js/addAccord.js" type="text/javascript"></script>
    </body>
</html>
<%-- 
    Document   : changeAccord
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <title>Modificado Acuerdo</title>
    </head>
    <body>
        <div>
            <%@include file="principalMenu.jsp" %>
        </div> 
        <div id="wrapper">
            <div class="container" >
                <div class="border-bottom" style="width: 97%">
                    <div class="row" style="background-color: white; width: 50%; border-radius: 50px 50px 1px 1px;background-color: #1f3140; border: solid #003366">
                        <div class="col-12">
                            <h3 align="center">Modificar Acuerdo</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container" id="container" style="border-radius: 1px 50px 50px 50px; border: solid #003366">
                <form id="uploadForm"  enctype="multipart/form-data" method="POST">
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
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <input id="generalSession" class="form-control" type="date">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="custom-control custom-switch">
                                <input type="checkbox" class="custom-control-input" id="customSwitch1" checked>
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
                                        <input type="text" class="form-control" name="office" required>
                                    </div>
                                </div>
                            </span>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <div class="col-sm-11">
                                    <label for="form-control" class="form-label" >Fecha de Notificacion:</label>
                                    <input type="date" class="form-control" name="notDate" id="notDate" required>
                                </div>
                            </div>
                        </div>
                        <div class="col">
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
                                    <button class="btn btn-outline-primary" type="button" onclick="javascript:setDeadline()" name="daysButton">Confirmar Plazo</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-group ">
                                <div class="col-8">
                                    <label for="form-control col-6" class="form-label"> Tipo de acuerdo: </label>
                                    <select  class="form-control" id="comboTypes" name="comboTypes" onchange="changeComboType(this.value)"></select>
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
                        <div class="col">
                            <div class="form-group ">
                                <div class="col-2">
                                    <label for="form-control col-6" class="form-label" style="visibility: visible">Estado:</label>
                                    <select  class="form-control" id="comboStates" name="comboStates" style="visibility: visible"> </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-group ">
                                <div class="col-12">
                                    <label for="" class="form-label" > Observaciones</label>
                                    <textarea  placeholder="Digite en este espacio sus observaciones" class="form-control" rows="5" cols="40" name ="observations" rows="3" style ="resize: none"></textarea>
                                </div>
                            </div>
                        </div>
                        <%-- DRAG and DROP zone --%>
                        <div class="col">
                            <div class="form-group files">
                                <label for="form-control" class="form-label">Inserte aquí el pdf</label>
                                <input style="width: 10%" type="file" class="form-control" name="accord" id="accord" placeholder="Inserte aquí el PDF" required multiple  accept="application/pdf">
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group files">
                                <label for="form-control" class="form-label">PDF de Confirmacion</label>
                                <input type="file" class="form-control" name="PrincipalAccord" id="accord" placeholder="Inserte aquí el PDF" required multiple  accept="application/pdf">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4">
                            <div class="form-group">
                                <div class="col">
                                    <button type="button" class="btn btn-outline-success" onclick="">Confirmar</button>
                                    <button type="button" class="btn btn-outline-danger" >Cancelar</button>
                                </div>
                            </div>
                        </div>
                    </div>
              </div>
            </section>            
        </div>

        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/changeAccord.js" type="text/javascript"></script>
    </body>
</html>

<%-- 
    Document   : addAccord
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>  
        <title>Agregar acuerdo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>


        <title>Agregar acuerdo</title>
        <script src="js/addAccord.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>

    </head>
    <body>
        <div>
            <%@include file="principalMenu.jsp" %>
        </div> 
        <div id="wrapper">  

            <h4 align="center">Agregar Acuerdo</h4>
            <div class="container" >
                <form action="/Kronos/accord/addAccord" method="POST" enctype="multipart/form-data" id="uploadForm">

                    <div class="row">
                        <!--                        <div class="row">-->
                        <div class="col">
                            <div  class="form-group">
                                <label for="form-control col-9" class="form-label"> Oficio: </label>
                                <input type="text" class="form-control" name="accNumber" id="accNumber"> 
                            </div> 
                        </div>

                        <div class="col">
                            <div class="form-group">
                                <label for="form-control col-4" class="form-label">Fecha de sesión:</label>
                                <input type="date"  class="form-control" name ="sessionDate" id="sessionDate">
                            </div>
                        </div>

                        <div class="col">
                            <div class="row">
                                <div class="form-group">
                                    <label for="form-control col-4" class="form-label">Fecha de Incorporación:</label>
                                    <input type="date"  class="form-control" name ="incorDate" id="incorDate">
                                </div>
                            </div> 
                            <div class="row">

                                <div class="form-group">
                                    <label for="form-control" class="form-label" >Vencimiento:</label>
                                    <input type="date" class="form-control" name="deadline" id="deadline">
                                </div>
                            </div>    
                        </div>    
                        <!--                        </div>-->


                    </div>

                    <div class="row">

                        <div class="col">

                            <div class="form-group ">
                                <label for="form-control col-6" class="form-label"> Tipo de acuerdo: </label>                               
                                <select   class="form-control" id="comboStates" name="comboTypes" onchange="changeComboType(this.value)" >
                                    <option value="A" >Admistración Municipal</option >
                                    <option value="B" >Auditoría Interna</option >
                                    <option value="C" >LIC</option >
                                    <option value="D" >Obras</option >
                                    <option value="E" >Plan Regulador</option >
                                    <option value="F" >Hacienda</option >
                                    <option value="G" >Jurídicos</option >
                                    <option value="H" >Sociales</option >
                                    <option value="I" >Ambiente</option >
                                    <option value="J" >Varios</option >
                                </select>
                            </div>
                        </div> 
                        <div class="col">
                            <div class="form-group ">
                                <label for="form-control col-9" class="form-label" style="visibility: hidden" id="labelName"> Nombre del Responsable </label>
                                <input type="hidden" class="form-control" name="tempName" id="tempName"> 
                            </div>
                            <div class="form-group ">
                                <label for="form-control col-9" class="form-label"  id="labelEmail" style="visibility: hidden"> Correo Electronico del Responsable </label>
                                <input type="hidden" class="form-control" name="tempEmail" id="tempEmail"> 
                            </div>


                        </div>  
                    </div> 

                    <div class="row">
                        <div class="col">
                            <div class="form-group ">
                                <label for="" class="form-label" > Observaciones</label>
                                <input type="text" placeholder="Digite en este espacio sus observaciones" class="form-control"  name ="observations">
                            </div>
                        </div>

                        <div class="col">
                            <div class="form-group ">
                                <label for="form-control" class="form-label">Adjuntar archivo:</label>
                                <input type="file" class="form-control"name="sampleFile" id="sampleFile" placeholder="Inserte aquí el PDF" required multiple>
                            </div>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-6">
                            
                            
                            <div class="form-group" >
                                <input type="submit" class="btn btn-outline-success pull-right" onclick="javascript:agregarAcuerdo()" value="Agregar" >
                            </div>
                            
                        </div>
                        <div class="col-6">
                            <div class="form-group"> 
                                <button type="button" class="btn btn-outline-danger " >Cancelar</button>
                            </div>
                        </div>
                    </div>
                     </form>  
             </div>

                    <!--                    <div class="row">
                                            <div class="col-6">
                                                <div  class="form-group">
                                                    <label for="form-control col-9" class="form-label"> Oficio: </label>
                                                    <input type="text" class="form-control" name="office"> 
                                                </div> 
                                                <div class="form-group ">
                                                    <label for="form-control col-6" class="form-label"> Tipo de acuerdo: </label>                               
                                                    <select   class="form-control" id="comboStates" name="comboStates" >
                                                        <option value="A" >Admistración Municipal</option >
                                                        <option value="B" >Auditoría Interna</option >
                                                        <option value="C" >LIC</option >
                                                        <option value="D" >Obras</option >
                                                        <option value="E" >Plan Regulador</option >
                                                        <option value="F" >Hacienda</option >
                                                        <option value="G" >Jurídicos</option >
                                                        <option value="H" >Sociales</option >
                                                        <option value="I" >Ambiente</option >
                                                        <option value="J" >Varios</option >
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="form-control col-4" class="form-label">Fecha de sesión:</label>
                                                    <input type="date"  class="form-control" name ="incorporatedDate">
                                                    </div>
                    
                                                    <div class="form-group ">
                                                        <label for="" class="form-label" > Observaciones</label>
                                                        <input type="text" placeholder="Digite en este espacio sus observaciones" class="form-control col-10 input-lg" name ="observations">
                                                    </div>
                                                </div>
                                                <div class="col-6">
                                                    <div class="form-group">
                                                        <label for="form-control" class="form-label">Fecha de sesión:</label>
                                                        <input type="date" class="form-control" name ="incorporatedDate">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="form-control" class="form-label">Vencimiento:</label>
                                                        <input type="date" class="form-control" name="deadline">
                                                    </div>
                                                    <div>
                                                        <label for="" class="form-label">Adjuntar archivo:</label>
                                                        <input type="file" name="accord" id="accord" placeholder="Inserte aquí el PDF" required>
                                                    </div>
                    
                    
                                                </div>
                    
                                                <div class="container">
                    
                                                    <div class="col-6">
                    
                                                        <div class="col-6">
                                                            <div class="form-group" >
                                                                <button type="submit" class="btn btn-outline-success" >Agregar</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-6">
                                                            <div class="form-group"> 
                                                                <button type="submit" class="btn btn-outline-danger " >Cancelar</button>
                                                            </div>
                                                        </div>
                                                    </div>
                    
                                                </div>
                                            </div>-->

               
            </div>         

        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/addAccord.js" type="text/javascript"></script>
    </body>
</html>
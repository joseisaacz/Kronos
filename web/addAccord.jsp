<%-- 
    Document   : addAccord
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>  
        <title>Agregar acuerdo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
            <div class="container" id="container" >
                <form action="">

                    <div class="row">
                        <!--                        <div class="row">-->
                        <div class="col">
                            <label for="form-control col-9" class="form-label"> Oficio: </label>
                            <div class="col-sm-10">
                                <input type="text" name="desc" value="OFICIO MSPH-CM-ACUER-" disabled> 

                            </div>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" name="office" > 
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
                                    <label for="form-control" class="form-label" >Plazo(Dias):</label>
                                    <input type="number" class="form-control" name="deadline" id="deadline">
                                    <select class="form-control" id="comboDays" name="comboDays"> 
                                        <option> Naturales </option>
                                        <option> Laborales </option>
                                    </select>
                                </div>
                            </div>    
                        </div>

                        <!--                        </div>-->


                    </div>

                    <div class="row">

                        <div class="col">

                            <div class="form-group ">
                                <label for="form-control col-6" class="form-label"> Tipo de acuerdo: </label>                               
                                <select  class="form-control" id="comboStates" name="comboStates"> </select>
                            </div>
                        </div> 
                        <div class="col">
                            <div class="form-group ">
                                <label for="form-control col-9" class="form-label" style="visibility: hidden"> Nombre del Responsable </label>
                                <input type="hidden" class="form-control" name="username"> 
                            </div>
                            <div class="form-group ">
                                <label for="form-control col-9" class="form-label" style="visibility: hidden"> Correo Electronico del Responsable </label>
                                <input type="hidden" class="form-control" name="email"> 
                            </div>
                        </div>  


                    </div> 

                    <div class="row">
                        <div class="col">
                            <div class="form-group ">
                                <label for="" class="form-label" > Observaciones</label>
                                <textarea  placeholder="Digite en este espacio sus observaciones" class="form-control" rows="5" cols="40" name ="observations" rows="3" style ="resize: none"></textarea>
                            </div>
                        </div>


                        <%-- DRAG and DROP zone --%>

                        <div class="col">
                            <div class="form-group files">
                                <label for="form-control" class="form-label"> Inserte aquí el pdf </label>
                                <input type="file" class="form-control" id="accord" placeholder="Inserte aquí el PDF" required multiple  accept="application/pdf">
                            </div>

                        </div>

                    </div>
                    <div class="row">

                        <div class="col-6">
                            <div class="col-7"></div>

                            <div class="form-group col-5" >
                                <button type="submit" class="btn btn-outline-success pull-right" onclick="javascript:hola()">Agregar</button>
                            </div>

                        </div>
                        <div class="col-6">
                            <div class="form-group"> 
                                <button type="submit" class="btn btn-outline-danger " >Cancelar</button>
                            </div>
                        </div>
                    </div>

                </form>  
            </div>         
        </div>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/addAccord.js" type="text/javascript"></script>
    </body>
</html>
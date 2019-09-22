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
            <section class="container" id="container">
                <form action="">
                    <div class="row">
                        <div class="col-6">
                            <div  class="form-group row">
                                <label for="" class="col-2 col-form-label"> Oficio: </label>
                                <input type="text" class="form-control col-9" name="office"> 
                            </div> 
                            <div class="form-group row">
                                <label for="" class="col-5 col-form-label"> Tipo de acuerdo: </label>                               
                                <select class="form-control col-6" name ="comboType">
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="" class="col-7 col-form-label">Fecha de sesión:</label>
                                <input type="date"  class="form-control col-4" name ="incorporatedDate">


                            <div class="cform-group row">
                                <label for="" class="col-5 col-form-label"> Estado del acuerdo: </label>
                                <select class="form-control col-6 " name ="comboState">
                                </select>
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-3 col-form-label" > Observaciones</label>
                                <input type="text" placeholder="Digite en este espacio sus observaciones" class="form-control col-10 input-lg" name ="observations">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group row">
                                <label for="" class="col-4 col-form-label">Fecha de sesión:</label>
                                <input type="date" class="form-control col-8" name ="incorporatedDate">
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-4 col-form-label">Vencimiento:</label>
                                <input type="date" class="form-control col-8" name="deadline">
                            </div>
                            <div>
                                <label for="" class="col-4 col-form-label">Adjuntar archivo:</label>
                                <input type="file" name="accord" id="accord" placeholder="Inserte aquí el PDF" required>
                            </div>

                        </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group row" >
                                    <button type="submit" class="btn btn-outline-success btn-lg col-6">Agregar</button>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group row "> 
                                    <button type="submit" class="btn btn-outline-danger btn-lg col-6" >Cancelar</button>
                                </div>
                            </div>
                        </div>
                </form>  
            </section>         
        </div>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/addAccord.js" type="text/javascript"></script>
    </body>
</html>
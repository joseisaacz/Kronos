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
        <div id ="wrapper">


            <section class="container" id="container">
                <div class="row">
                    <div class="col">
                        <form action="">
                            <div  class="form-group">
                              <label for="" class="col-7 col-form-label">Oficio</label>
                               <input type="text" class="form-control col-4" name ="office">
                            </div>

                            <div class="form-group">
                                <label for="" class="col-7 col-form-label">Fecha de sesión:</label>
                                <input type="date" class="form-control col-4" name ="incorporatedDate">
                            </div>

                            <div class="form-group">
                                <label for="" class="col-7 col-form-label">Vencimiento:</label>
                                <input type="date" class="form-control col-4" name="deadline">
                            </div>

                            <div class="form-group">
                                <label for="" class="col-2 col-form-label"> Observaciones</label>
                                <input type="text" placeholder="Digite en este espacio sus observaciones" class="form-control col-10" name ="observations">
                            </div>
                            <div>
                                <div class ="table-responsive">
                                    <table id="tableAcc" class="table table-striped table-bordered border-info" style="width:100%">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center">Principal</th>
                                                <th style="text-align: center">Documento</th>
                                            </tr>
                                        </thead>
                                        <tbody id="accordDocumet">
                                        </tbody>
                                    </table>
                                </div>
                                <label for="">Adjuntar archivo:</label>
                                <input type='file' name='archivo1' id='archivo1' placeholder="Inserte aquí el PDF" required>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-light">Cancelar</button>
                                <button type="submit" class="btn btn-light">Agregar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>            
        </div>

        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/changeAccord.js" type="text/javascript"></script>
    </body>
</html>

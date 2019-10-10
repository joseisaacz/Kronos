<!DOCTYPE html>

<html>
    <head>
        <title> Gestor de acuerdos </title>
        <meta charset="UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
            <%@include file="principalMenu.jsp" %>            
        </div> 
        <div id="wrapper">
            <h4 align="center">Acuerdos próximos a vencer</h4>
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
                                        <th style="text-align: center">Estado</th>
                                    </tr>
                                </thead>
                                <tbody id="accordList">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <section>
                <a href="login.jsp"> to login</a>
                
            </section>      
        </div>
    </body>
</html>

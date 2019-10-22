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
            <h4 align="center">Acuerdos Vencidos</h4>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-responsive col-lg-12">        
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
        <script src="js/index.js" type="text/javascript"></script>   
    </body>
</html>

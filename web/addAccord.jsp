<%-- 
    Document   : addAccord
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <title>Agregar acuerdo</title>

    </head>
    <body>
        <div id="wrapper">

            <section class="container">
                <form class="col-4">
                    <div  class="form-group">
                        <label for=""> Oficio: </label>
                        <input type="text" class="form-control"> 
                    </div>
                    <div class="form-group">
                        <label for="">Vencimiento:</label>
                        <input type="date" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for> Observaciones</label>
                        <input type="text" placeholder="Digite en este espacio sus observaciones" class="form-control">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-light">Cancelar</button>
                        
                        <button type="submit" class="btn btn-light">Agregar</button>
                    </div>
                </form>
            </section>
            
            
        </div>
    </body>
</html>

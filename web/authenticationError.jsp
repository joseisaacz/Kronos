<%-- 
    Document   : authenticationError
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8" />
        <title>Error de Autenticación</title>
        <link href="css/popup.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <p><a href="#popup">Abrir Popup</a></p>
        <div id="popup" class="overlay">
            <div id="popupBody">
                <h2>Error de autenticación</h2>
                <a id="cerrar" href="#">&times;</a>
                <div class="popupContent">
                    <p>Usted no cuenta con los permisos  para accersar</p>
                </div>
            </div>
        </div>
    </body>
</html>

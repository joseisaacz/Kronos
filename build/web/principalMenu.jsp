<%-- 
    Document   : principalMenu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="css/menu.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<div class="wrapperMenu">
    <!--Navigation Start-->
    <nav class="navigation">
        <ul>
            <li class="active">
                <a href="index.jsp">Gestor de acuerdos</a>
            </li>
            <li>
                <a href="#">Acuerdos</a>
                <ul class="children sub-menu">
                    <li>
                        <a href="addAccord.jsp">Registrar</a>
                    </li>
                    <li>
                        <a href="listAccord.jsp">Lista</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="">Actas</a>    
                <ul class="children sub-menu">
                    <li>
                        <a href="#">Registrar</a>
                    </li>
                    <li>
                        <a href="#">Modificar</a>
                    </li>
                </ul>
            </li>

            <li >
                <a href="#">Perfil</a>
            </li>
            <li class="last">
                <a href="#">Salir</a>
            </li>
        </ul>
    </nav>
    <!--Navigation End-->
</div>
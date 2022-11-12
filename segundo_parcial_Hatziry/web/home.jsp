<%-- 
    Document   : home
    Created on : 10/11/2022, 23:06:38
    Author     : Hatziry Chacón
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <style>
            *{
                margin: 0;
                padding: 0;
            }
            body{
                min-height: 100vh;
                background-image: url(https://wallpapers.com/images/hd/minimalist-black-cartoon-cat-0dd6ao533jede2bq.webp);
                background-size: 100%;
                background-position: center center;
                background-attachment: fixed;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    </head>
    <% 
        response.setHeader("Cache-Control", "nocache, no-store, must-revalidate");
        if(session.getAttribute("user")==null){
            response.sendRedirect("/index.jsp");
        }
    %>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Libreria</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="FormAutor.jsp">Registrar autor</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="FormLibro.jsp">Registrar libro</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link">Libros registrados</a>
                    </li>
                    <li class="nav-item">
                       <a class="btn btn-outline-warning" href="Logout">Cerrar Sesion - ${UsuarioLogueado}</a>
                    </li>
                </ul>
            </div>
        </nav>
        <h1 class="display-4 my-4">Bienvenido ${UsuarioLogueado}</h1>
    </body>
</html>

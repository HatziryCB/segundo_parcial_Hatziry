<%-- 
    Document   : index
    Created on : 10/11/2022, 22:19:10
    Author     : Hatziry Chacón
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 10px;
                background: linear-gradient(135deg, #71b7e6, #9b59b6);
            </style>
        </head>
        <body>
            <div class="justify-content-around mx-3 my-3 bg-white">
                <div shadow-lg p-3 bg-white rounded>
                    <c:if test="${success ==0}">
                        <div class="alert alert-danger" id="error">${mensaje}</div>
                    </c:if>
                    <div class="mt-5 mb-5 mx-5">
                        <img src="https://cdn-icons-png.flaticon.com/512/2521/2521826.png" class="rounded mx-auto d-block" width="100" alt="...">
                        <h1 class="d-flex justify-content-center mt-3 mb-5">Inicio de sesión</h1>
                        <form action="Validation" method="POST">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Correo electrónico</label>
                                <input type="text" class="form-control" name="user" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter user">
                                <small id="emailHelp" class="form-text text-muted">Puedes estar seguro que no compartiremos tus datos personales</small>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Contraseña</label>
                                <input type="password" class="form-control" name="pass" id="exampleInputPassword1" placeholder="Password">
                            </div>
                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                                <label class="form-check-label" for="exampleCheck1">Mantener mi sesion iniciada</label>
                            </div>
                            <button type="submit" class="btn btn-primary my-2">Iniciar sesión</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
</html>

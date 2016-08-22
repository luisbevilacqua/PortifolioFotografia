<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 15/07/16
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="acao.Acao" %>
<%@ page import="acao.MostrarInformacoesFotografo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<head>
    <link rel="stylesheet" type="text/css"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <title>Title</title>
    <style>

        input {
            margin-bottom: 10px;
        }

        label {
            margin-bottom: 10px;
        }
        button{
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<% Acao acao = new MostrarInformacoesFotografo();
    try {
        acao.executa(request,response);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">${requestScope.nomeFotografo}</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li>
                    <a href="sobre.jsp">Contato</a>
                </li>
                <li>
                    <a href="#">Login</a>
                </li>
            </ul>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<hr>

<div class="container">

    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Login

            </h1>
        </div>
    </div>


    <form action="controller" method="post" class="form-signin">

        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">

            <label for="login" class="sr-only" >Login</label>
            <input id="login" class="form-control" placeholder="Login" required="" autofocus="" type="text" name="login"  x-moz-errormessage="Por favor, informe o login">
            <label for="senha" class="sr-only" >Senha</label>
            <input id="senha" class="form-control" placeholder="Senha" required="" type="password" name="senha" x-moz-errormessage="Por favor, informe a senha">

        <button class="btn btn-lg btn-primary btn-block" type="submit" name="opcao" value="Logar">Login</button>
        </div>
    </form>




</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>

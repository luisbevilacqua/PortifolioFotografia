<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 15/07/16
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<head>
    <link rel="stylesheet" type="text/css"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
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
            <a class="navbar-brand" href="#">Start Bootstrap</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="index.jsp">Fotos</a>
                </li>
                <li>
                    <a href="sobre.jsp">Sobre</a>
                </li>
                <li>
                    <a href="#">Login</a>
                </li>
            </ul>
            <div class="col-sm-3 col-md-3 pull-right">
                <form class="navbar-form" action="controller" method="post">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Buscar por tags" name="srch-term">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            <input type="hidden" name="opcao" value="MostrarFotosPorTag">
                        </div>
                    </div>
                </form>
            </div>
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
            <h1 class="page-header">Page Heading
                <small>Secondary Text</small>
            </h1>
        </div>
    </div>
    <form action="controller" method="post">
        Login: <input type="text" name="login"><br>
        Senha: <input type="password" name="senha"><br>
        <input type="submit" value="Login">
        <input type="hidden" name="opcao" value="Logar">
    </form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>

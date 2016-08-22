<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 17/07/16
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <title>Contato</title>
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
                    <a href="adicionar.jsp">Adicionar Foto</a>
                </li>
                <li>
                    <a href="deletar.jsp">Remover Foto</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<hr>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Informações:
            </h1>
        </div>
    </div>
    <div class="jumbotron">
        <div class="container">

            ${requestScope.infos}
        </div>
    </div>
</div>



<a href="adicionar.jsp">Adicionar foto</a><br>
<a href="deletar.jsp">Remover foto</a><br>
<a href="editar.jsp">Editar foto</a><br>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>

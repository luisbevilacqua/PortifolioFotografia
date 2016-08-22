<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 17/07/16
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="acao.MostrarTodasAsFotosAdm" %>
<%@ page import="acao.Acao" %>
<%@ page import="acao.MostrarInformacoesFotografo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <title>Adicionar Foto</title>
</head>
<body>
<% Acao acao = new MostrarTodasAsFotosAdm();
    Acao acao2 = new MostrarInformacoesFotografo();
    try {
        acao.executa(request,response);
        acao2.executa(request,response);
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
            <a class="navbar-brand" href="editor.jsp">${requestScope.nomeFotografo}</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li>
                    <a href="adicionar.jsp">Adicionar Foto</a>
                </li>

                <li>
                    <a href="editar.jsp">Editar Foto</a>
                </li>
                <li>
                    <a href="index.jsp">Log out</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<div class="container">

<hr>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Adicionar Foto

        </h1>
    </div>
</div>


<form action="controller" method="post" enctype="multipart/form-data">
    <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
        <label for="titulo" ">Título :</label>
        <input id="titulo" class="form-control" placeholder="Título" required="" autofocus="" type="text" name="titulo"  x-moz-errormessage="Por favor, informe o titulo">
        <input type="file" name="caminho"><br>
        <label for="descricao" >Descrição:</label>
        <input id="descricao" class="form-control" placeholder="Descrição" required="" autofocus="" type="text" name="descricao">

        <input type="submit" value="Adicionar">
        <input type="hidden" name="opcao" value="Adicionar">
    </div>
</form>
</div>
</body>
</html>

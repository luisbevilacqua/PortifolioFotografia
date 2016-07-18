<%@ page import="acao.MostrarTodasFotos" %>
<%@ page import="acao.Acao" %>
<%@ page import="acao.MostrarInformacoesFotografo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <title>Editor</title>
</head>
<body>
<% Acao acao = new MostrarTodasFotos();
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
            <a class="navbar-brand" href="#">${requestScope.nomeFotografo}</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">Inserir Foto</a>
                </li>
                <li>
                    <a href="#">Sobre</a>
                </li>
                <li>
                    <a href="index.jsp">LogOut</a>
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
            <h1 class="page-header">${requestScope.nomeTag}
                <small>Todas as fotos de autoria de ${requestScope.nomeFotografo}</small>
            </h1>
        </div>
    </div>

    ${requestScope.listaFotos}

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>

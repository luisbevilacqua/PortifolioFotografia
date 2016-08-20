<%--
  Created by IntelliJ IDEA.
  User: luis
  Date: 20/08/16
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="controller" method="post">
    Id: <input type="text" name="id"><br>
    Titulo: <input type="text" name="titulo"><br>
    Caminho: <input type="text" name="caminho"><br>
    Descrição: <input type="text" name="descricao"><br>
    <input type="submit" value="Editar">
    <input type="hidden" name="opcao" value="Editar">
</form>
</body>
</html>

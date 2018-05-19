<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Gerenciador de Empresas</title>
</head>
<body>
<p>Bem vindo ao gerenciador de empresas</p>

<c:if test="${not empty usuarioLogado}">
    Logado como ${usuarioLogado.email}
</c:if>

<fieldset>
    <legend>Cadastrar</legend>
    <form action="novaEmpresa" method="POST">
        Nome:
        <input type="text" name="nome"/>
        <input type="submit" value="Enviar"/>
    </form>
</fieldset>

<br/>

<fieldset>
    <legend>Login</legend>
    <form action="login" method="POST">
        E-mail <input type="email" name="email"/>
        Senha <input type="password" name="senha"/>
        <input type="submit" value="Enviar"/>
    </form>
</fieldset>
<br/>
<form action="executar" method="POST">
    <input type="hidden" name="tarefa" value="Logout"/>
    <input type="submit" value="Deslogar"/>
</form>

</body>
</html>

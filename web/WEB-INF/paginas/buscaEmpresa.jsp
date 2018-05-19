<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Empresas encontradas</title>
</head>
<body>

Resultado da busca:
<ul>
    <c:forEach var="empresa" items="${empresas}">
        <li>${empresa.id}: ${empresa.nome}</li>
    </c:forEach>
</ul>

</body>
</html>

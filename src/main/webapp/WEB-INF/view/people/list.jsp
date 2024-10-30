<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Listar Pessoas</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Lista de Pessoas</h1>
        <a href="${pageContext.request.contextPath}/v1/people/create" class="btn btn-primary mb-3">Criar Nova Pessoa</a>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Data de Nascimento</th>
                <th>CPF</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="person" items="${people}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.birthDate}</td>
                    <td>${person.cpf}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/v1/people/${person.id}/edit" class="btn btn-warning">Editar</a>
                        <form action="${pageContext.request.contextPath}/v1/people/${person.id}" method="post" style="display:inline;">
                            <input type="hidden" name="_method" value="DELETE">
                            <button type="submit" class="btn btn-danger">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

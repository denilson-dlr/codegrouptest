<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Listar Projetos</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Lista de Projetos</h1>
        <a href="${pageContext.request.contextPath}/v1/projects/create" class="btn btn-primary mb-3">Criar Novo Projeto</a>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="project" items="${projects}">
                <tr>
                    <td>${project.id}</td>
                    <td>${project.name}</td>
                    <td>${project.description}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/v1/projects/${project.id}" class="btn btn-info">Ver</a>
                        <a href="${pageContext.request.contextPath}/v1/projects/${project.id}/edit" class="btn btn-warning">Editar</a>
                        <form action="${pageContext.request.contextPath}/v1/projects/${project.id}" method="post" style="display:inline;">
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

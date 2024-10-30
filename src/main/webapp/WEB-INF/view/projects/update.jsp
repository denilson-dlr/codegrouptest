<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.acme.model.Project" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Atualizar Projeto</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Atualizar Projeto</h1>
        <form action="${pageContext.request.contextPath}/v1/projects/${project.id}" method="post">
            <div class="form-group">
                <label for="name">Nome do Projeto</label>
                <input type="text" class="form-control" id="name" name="name" value="${project.name}" required>
            </div>
            <div class="form-group">
                <label for="description">Descrição</label>
                <textarea class="form-control" id="description" name="description" required>${project.description}</textarea>
            </div>
            <div class="form-group">
                <label for="startDate">Data de Início</label>
                <input type="date" class="form-control" id="startDate" name="startDate" value="${project.startDate}" required>
            </div>
            <div class="form-group">
                <label for="expectedEndDate">Data Prevista de Término</label>
                <input type="date" class="form-control" id="expectedEndDate" name="expectedEndDate" value="${project.expectedEndDate}" required>
            </div>
            <button type="submit" class="btn btn-success">Atualizar Projeto</button>
            <a href="${pageContext.request.contextPath}/v1/projects" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</body>
</html>

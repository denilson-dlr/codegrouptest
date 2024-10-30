<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Criar Projeto</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Criar Novo Projeto</h1>
        <form action="${pageContext.request.contextPath}/v1/projects" method="post">
            <div class="form-group">
                <label for="name">Nome do Projeto</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="description">Descrição</label>
                <textarea class="form-control" id="description" name="description" required></textarea>
            </div>
            <div class="form-group">
                <label for="startDate">Data de Início</label>
                <input type="date" class="form-control" id="startDate" name="startDate" required>
            </div>
            <div class="form-group">
                <label for="expectedEndDate">Data Prevista de Término</label>
                <input type="date" class="form-control" id="expectedEndDate" name="expectedEndDate" required>
            </div>
            <button type="submit" class="btn btn-success">Criar Projeto</button>
            <a href="${pageContext.request.contextPath}/v1/projects" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</body>
</html>

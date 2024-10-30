<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Criar Pessoa</title>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Criar Nova Pessoa</h1>
        <form action="${pageContext.request.contextPath}/v1/people" method="post">
            <div class="form-group">
                <label for="name">Nome</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="birthDate">Data de Nascimento</label>
                <input type="date" class="form-control" id="birthDate" name="birthDate" required>
            </div>
            <div class="form-group">
                <label for="cpf">
                <input type="date" class="form-control" id="birthDate" name="birthDate" required>
            </div>
            <button type="submit" class="btn btn-success">Criar</button>
            <a href="${pageContext.request.contextPath}/v1/people" class="btn btn-danger">Cancelar</a>
        </form>
    </div>
</body>
</html>


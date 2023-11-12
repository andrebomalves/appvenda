<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"	rel="stylesheet">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
	<meta charset="ISO-8859-1">
	<title>AppVenda</title>
	<style>
	.material-symbols-outlined {
		font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 24
	}
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">AppVenda</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/vendedor/lista">Vendedores</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/produto/lista">Produtos</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/mouse/lista">Mouses</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/computador/lista">Computadores</a></li>
			</ul>
		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Vendedor
			${qtdeVendedor}</span> <span class="badge rounded-pill bg-secondary">Produto
			${qtdeProduto}</span> <span class="badge rounded-pill bg-success">Mouses
			${qtdeMouse}</span> <span class="badge rounded-pill bg-danger">Computadores
			${qtdeComputador }</span>

		<h2>AppVenda</h2>
		<p>Gestão de vendas de produtos:</p>
		<table class="table">
			<thead class="table-dark">
				<tr>
					<th>${titulo}</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listagem}">
					<tr>
						<td>${item}</td>
						<td>
							<a href="/${rota}/${item.id}/excluir">
								<span class="material-symbols-outlined">delete</span>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
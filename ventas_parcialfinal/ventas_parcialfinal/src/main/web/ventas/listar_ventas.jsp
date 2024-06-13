<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directorio - Venta</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
	rel="stylesheet">
</head>
<style>
body {
	font-family: Verdana;
	background-color: #1B1F3B;
	margin: 0;
	background-position: center center;
	height: 100vh;
}

h3 {
	font-weight: bold;
	color: #FE7F2D;
}

.card {
	
}
</style>
<body>
	<div class="d-flex justify-content-center align-items-center h-100">
		<div class="container mt-6">
			<div class="card">
				<div class="card card-header">
					<h3 class="text-center  mt-3">Listado de ventas</h3>
				</div>

				<div class="card card-body">
					<div class="text-end">
						<a title="Agregar"
							href="ventas?accion=agregar&id=${ven.id}"><i
							class="bi-person-add btn btn-outline-success"
							style="font-size: 1.5em"></i></a>
					</div>
					<c:if test="${requestScope.ventas.size() > 0}">
						<table class="table table-bordered table-striped mt-3">
							<tr>

								<th>Cliente:</th>
								<th>Producto:</th>
								<th>Precio:</th>
								<th>Cantidad:</th>
								<th>Fecha:</th>
								<th>Subtotal:</th>
								<th>Acciones</th>

							</tr>
							<c:forEach items="${requestScope.ventas}" var="ven">
								<tr>
									<td>${ven.cliente.nombreCompleto}</td>
									<td>${ven.producto.descripcion}</td>
									<td>${ven.precio}</td>
									<td>${ven.cantidad}</td>
									<td>${ven.fecha}</td>
									<td>${ven.precio * ven.cantidad}</td>
									<td><a title="Consultar"
										href="ventas?accion=consultar&id=${ven.id}"><i
											class="bi-eye" style="font-size: 1.3em"></i></a> <a
										href="ventas?accion=eliminar&id=${ven.id}" title="Eliminar"
										onclick="return confirm('Seguro de eliminar ?')"> <i
											class="bi-eraser text-danger" style="font-size: 1.3em"></i>
									</a> <a href="ventas?accion=modificar&id=${ven.id}"
										title="Modificar"><i class="bi-pencil"
											style="font-size: 1.3em; color: #7D930F;"></i></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<a href="javascript:history.back()"><i
						class="bi-arrow-left-circle-fill btn btn-outline-primary"
						style="font-size: 1.5em;"></i></a>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de la venta</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
	rel="stylesheet">
<style>
body {
	font-family: Verdana;
	background-color: #3bb3c1;
	background-image:
		url('https://cdn.pixabay.com/photo/2017/04/05/04/44/background-2203989_1280.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
	height: 100vh;
	margin: 0;
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
}

h3 {
	font-weight: bold;
	color: #FE7F2D;
}

.lblniv1 {
	font-weight: bold;
	color: #FE7F2D;
}

.button {
	
}
</style>
</head>
<body>

	<div class="d-flex justify-content-center align-items-center h-100">
		<div class="container mt-3">
			<div class="card bg-light">

				<div class="card-header">
					<h3>Datos de la venta</h3>
				</div>
				<div class="card-body">
					<h4 class="card-title text-right"></h4>
					<ul class="list-group">
						<li class="list-group-item"><b>Id: </b><span>${requestScope.venta.id}</span></li>
						<li class="list-group-item"><b>Cliente: </b><span>${requestScope.venta.cliente.nombreCompleto}</span></li>
						<li class="list-group-item"><b>Producto: </b><span></span>${requestScope.venta.producto.descripcion}</li>
						<li class="list-group-item"><b>Precio: </b><span>${requestScope.venta.precio}</span></li>
						<li class="list-group-item"><b>Cantidad: </b><span>${requestScope.venta.cantidad}</span></li>
						<li class="list-group-item"><b>Forma de pago: </b><span>${requestScope.venta.formaPago}</span></li>
						<li class="list-group-item"><b>Fecha: </b><span>${requestScope.venta.fecha}</span></li>
						<li class="list-group-item"><b>Aprobada ?: </b><span>${requestScope.venta.aprobada ? 'Sí' : 'No'}</span></li>
					</ul>
				</div>
				<div class="p-3">
					<a href="javascript:history.back()"><i
						class="bi-arrow-left-circle-fill btn btn-outline-primary"
						style="font-size: 1.5em;"></i></a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
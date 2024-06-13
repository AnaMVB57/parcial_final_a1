<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar la venta</title>

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
}

h3 {
	font-weight: bold;
	color: #FE7F2D;
}

.lblniv1 {
	font-weight: bold;
	color: #FE7F2D;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<div class="card">
			<div class="card-header">
				<h3>Modificar venta</h3>
			</div>
			<div class="card-body">
				<form method="post" action="ventas" class="mb-3"
					onsubmit="return validar()">

					<div class="mb-3">
						<label class="lblniv1" for="cliente">Cliente:</label> <select
							name="cliente" id="cliente" class="form-control form-select">
							<option value="">Seleccionar un cliente...</option>
							<c:forEach items="${requestScope.clientes}" var="cliente">
								<option value="${cliente.id}"
									${requestScope.cliente.indexOf(cliente.nombreCompleto) != -1 ? 'selected' : ''}>${cliente.nombreCompleto}</option>
							</c:forEach>
						</select> <small class="form-text text-primary" id="msgCliente"></small>
					</div>



					<div class="mb-3">
						<label class="lblniv1" for="producto">Producto:</label> <select
							name="producto" id="producto" class="form-control form-select">
							<option value="">Seleccionar un producto...</option>

							<c:forEach items="${requestScope.productos}" var="producto">
								<option value="${producto.id}"
									${requestScope.producto.indexOf(producto.descripcion) != -1 ? 'selected' : ''}>${producto.descripcion}</option>
							</c:forEach>
						</select> <small class="form-text text-primary" id="msgProducto"></small>
					</div>

					<div class="mb-3">
						<label class="lblniv1" for="precio">Precio: </label> <input
							type="text" name="precio" id="precio" class="form-control"
							value="${requestScope.venta.precio}" /> <small
							class="form-text text-primary" id="msgPrecio"></small>
					</div>

					<div class="mb-3">
						<label class="lblniv1" for="cantidad">Cantidad: </label> <input
							type="number" name="cantidad" id="cantidad" class="form-control"
							value="${requestScope.venta.cantidad}" /> <small
							class="form-text text-primary" id="msgCantidad"></small>
					</div>

					<div class="mb-3">
						<label class="lblniv1" for="fecha">Fecha ingreso: </label> <input
							type="date" name="fecha" value="${requestScope.venta.fecha}"
							id="fecha" class="form-control" /> <small
							class="form-text text-primary" id="msgFecha"></small>
					</div>

					<div class="mb-3">
						<label class="lblniv1">Forma de pago: </label><br />
						<div class="form-check">
							<input type="radio" name="formaPago" value="Contado" id="radio1"
								class="form-check-input"
								${requestScope.venta.formaPago.indexOf("Contado") != -1 ? 'checked' : ''} />
							<label for="radio1" class="form-check-label">Contado</label>
						</div>
						<div class="form-check">
							<input type="radio" name="formaPago" value="Débito" id="radio2"
								class="form-check-input"
								${requestScope.venta.formaPago.indexOf("Débito") != -1 ? 'checked' : ''} />
							<label for="radio2" class="form-check-label">Débito</label>
						</div>
						<div class="form-check">
							<input type="radio" name="formaPago" value="Crédito" id="radio3"
								class="form-check-input"
								${requestScope.venta.formaPago.indexOf("Crédito") != -1 ? 'checked' : ''} />
							<label for="radio3" class="form-check-label">Crédito</label>
						</div>
						<small class="form-text text-primary" id="msgFormaPago"></small>
					</div>

					<div class="mb-3">
						<div class="form-check">
							<input type="checkbox" name="aprobada" id="aprobada"
								class="form-check-input"
								${requestScope.venta.aprobada == true ? 'checked' : ''} /> <label
								for="aprobada" class="form-check-label lblniv1">Aprobada</label>
						</div>
					</div>

					<div>
						<input type="hidden" name="id" id="id"
							value="${requestScope.venta.id}">
					</div>
					<div class="text-end">
						<input type="submit" value="Guardar"
							class="btn btn-outline-primary btn-sm" />
					</div>
					<div>
						<a href="javascript:history.back()"><i
							class="bi-arrow-left-circle-fill btn btn-outline-primary"
							style="font-size: 1.5em;"></i></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
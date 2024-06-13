//alert ("Integrado con Javascript");

function validar() {

	let validado = true;

	let msgs = document.querySelectorAll("small[id^='msg']");

	for (let mensaje of msgs) {
		mensaje.innerHTML = '';
	}

	let cliente = document.getElementById("cliente");
	let producto = document.getElementById("producto");
	let cantidad = document.getElementById("cantidad");
	let precio = document.getElementById("precio");
	let fecha = document.getElementById("fecha");
	let radios = document.getElementsByName("formaPago");

	//Variables de mensajes de <small>
	let msgCliente = document.querySelector("#msgCliente");
	let msgProducto = document.querySelector("#msgProducto");
	let msgPrecio = document.querySelector("#msgPrecio");
	let msgCantidad = document.querySelector("#msgCantidad");
	let msgFecha = document.querySelector("#msgFecha");
	let msgFormaPago = document.querySelector("#msgFormaPago");

	let rgxDouble = /^\d{1,10}(\.\d{1,2})?$/;
	let rgxFecha = /^\d{4}-\d{2}-\d{2}$/;

	let esValidoRad = false;
	for (let i = 0; i < radios.length; i++) {
		if (radios[i].checked) {
			esValidoRad = true;
			break;
		}
	}

	if (cliente.selectedIndex == 0) {
		msgCliente.innerHTML += "Seleccionar un cliente. <br/>";
		validado = false;
	}
	if (producto.selectedIndex == 0) {
		msgProducto.innerHTML += "Seleccionar un producto. <br/>";
		validado = false;
	}
	if (!rgxDouble.test(precio.value)) {
		msgPrecio.innerHTML += "Ingrese un precio válido. Sólo números. <br/>";
		validado = false;
	}
	if (!rgxDouble.test(cantidad.value)) {
		msgCantidad.innerHTML += "Ingrese una cantidad válida. Sólo números. <br/>";
		validado = false;
	}
	if (!rgxFecha.test(fecha.value)) {
		msgFecha.innerHTML += "Ingrese una fecha válida. Formato (aaaa-MM-dd) <br/>";
		validado = false;
	}
	if (!esValidoRad) {
		msgFormaPago.innerHTML += "Seleccionar una forma de pago. <br/>";
		validado = false;
	}

	return validado;

}


function createNovedad() {
	let idCita = $("#idCita").val();
	let observacion = $("#observacioNovedad").val();
	fetch(`/cita/${idCita}/novedades`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ observacion: observacion })
	}).then(response => {
		if (response.status === 201) {
			window.location.href = window.location.origin + window.location.pathname + "?novadad=create";
		} else {
			alert("Error al crear novedad");
		}
	}).catch(error => {
		console.log(error);
		alert("Error al crear novedad");
	});
}


function deleteNovedad(idNovedad) {
	let idCita = $("#idCita").val();
	fetch(`/cita/${idCita}/novedades/${idNovedad}`, {
		method: 'DELETE',
		headers: {
			'Content-Type': 'application/json'
		}
	}).then(response => {
		if (response.status === 200) {
			window.location.href = window.location.origin + window.location.pathname + "?novadad=delete";
		} else {
			alert("Error al crear novedad");
		}
	}).catch(error => {
		console.log(error);
		alert("Error al crear novedad");
	});
}

//Funcionalidad de autorizacion
function createAutorizacionProcess() {
	let idCita = $("#idCita").val();
	fetch(`/cita/${idCita}/autorizaciones`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ descripcion: 'Creacion autorizacion' })

	}).then(response => {
		if (response.status === 201) {
			window.location.href = window.location.origin + window.location.pathname + "?autorizacion=create";
		} else {
			alert("Error al crear novedad");
		}
	}).catch(error => {
		console.log(error);
		alert("Error al crear novedad");
	});
}

// funcionalidad de examen
function crearExamen() {
	let idAutorizacion = $("#idautorizacion").val();
	let tipo = $("#tipoExamen").val();
	let centroMedico = $("#centroExamen").val();
	let fechaExamen = $("#fecha-send").val();
	fetch(`/autorizacion/${idAutorizacion}/examen`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ tipo: tipo, centroMedico: centroMedico, fechaExamen: fechaExamen })
	}).then(response => {
		if (response.status === 201) {
			window.location.href = window.location.origin + window.location.pathname + "?examen=create";
		} else {
			alert("Error al crear novedad");
		}
	}).catch(error => {
		console.log(error);
		alert("Error al crear novedad");
	});
}

function deleteExamen(idExamen) {
	let idAutorizacion = $("#idautorizacion").val();
	fetch(`/autorizacion/${idAutorizacion}/examen/${idExamen}`, {
		method: 'DELETE',
		headers: {
			'Content-Type': 'application/json'
		}
	}).then(response => {
		if (response.status === 200) {
			window.location.href = window.location.origin + window.location.pathname + "?examen=delete";
		} else {
			alert("Error al crear novedad");
		}
	}).catch(error => {
		console.log(error);
		alert("Error al crear novedad");
	});
}

//Funcionalidad Medicamentos

function crearMedicamento() {
	let idAutorizacion = $("#idautorizacion").val();
	let nombre = $("#nombreMedicamento").val();
	let cantidad = $("#cantidadMedicamento").val();
	let posologia = $("#posoligiaMedivamento").val();
	fetch(`/autorizacion/${idAutorizacion}/medicamento`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ nombre: nombre, cantidad: cantidad, posologia: posologia })
	}).then(response => {
		if (response.status === 201) {
			window.location.href = window.location.origin + window.location.pathname + "?medicamento=create";
		} else {
			alert("Error al crear novedad");
		}
	}).catch(error => {
		console.log(error);
		alert("Error al crear novedad");
	});
}

function deleteMedicamento(idmedicamento) {
	let idAutorizacion = $("#idautorizacion").val();
	fetch(`/autorizacion/${idAutorizacion}/medicamento/${idmedicamento}`, {
		method: 'DELETE',
		headers: {
			'Content-Type': 'application/json'
		}
	}).then(response => {
		if (response.status === 200) {
			window.location.href = window.location.origin + window.location.pathname + "?medicamento=delete";
		} else {
			alert("Error al crear novedad");
		}
	}).catch(error => {
		console.log(error);
		alert("Error al crear novedad");
	});
}


//Init
$(document).ready(function() {
	$(".deleteItemNovedad").on("click", function() {
		let id = $(this).attr("data-id");
		deleteNovedad(id);
	});
	$(".deleteExamen").on("click", function() {
		let id = $(this).attr("data-id");
		deleteExamen(id);
	});
	$(".deleteMedicamento").on("click", function() {
		let id = $(this).attr("data-id");
		deleteMedicamento(id);
	});
});

function createNovedad() {
	let idCita = $("").val();
	let observacion = $("").val();
	fetch(`/cita/${idCita}/novedades`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({ observacion: observacion })
	}).then(response => {
		if (response.status === 201) {

		} else {

		}
	}).catch(error => {
		console.error('Error de red:', error);
	});
}


function deleteNovedad() {
	let idCita = $("").val();
	let idNovedad = $("").val();
	fetch(`/cita/${idCita}/novedades/${idNovedad}`, {
		method: 'DELETE',
		headers: {
			'Content-Type': 'application/json'
		}
	}).then(response => {
		if (response.status === 200) {

		} else {

		}
	}).catch(error => {
		console.error('Error de red:', error);
	});
}

// funcionalidad de examen



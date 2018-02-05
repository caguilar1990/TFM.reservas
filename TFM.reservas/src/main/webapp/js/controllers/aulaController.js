(function($) {
	var aulaService = new AulaService();
	var personalService = new PersonalService();
	var resourcesService = new ResourceService();

	$(document).ready(function() {
		
		var deferred = aulaService.getAll();
		deferred.done(addRows).always(function() {
	
		});


		$("td").on("click", "button.resources", function() {
			 var aula = $(this).val();
			
				var deferred = resourcesService.findbyIDAula(aula);
				deferred.done(showResources).fail(function() {
					console.log ("No tiene Recursos asignados")
				});


		
		});


	});

	function addRows(response) {
		$.each(	response,function(ind, elem) {
							var fila = $('tr.classrooms:last').clone(true);
							fila.find('td[name=referencia]').text(response[ind].referencia);
							fila.find('td[name=superficie]').text(response[ind].superficie);
							if (response[ind].accesibilidad == 1) {
								accesibilidad = "SI";

							} else {
								accesibilidad = "NO";
							}
							fila.find('td[name=accesibilidad]').text(accesibilidad);
							var descripcionPersonal = "PENDIENTE ASIGNACION";
							if (response[ind].personal == ""
									|| response[ind].personal == null) {
								fila.find('td[name=responsable]').text(	descripcionPersonal);
							} else {
								var promise = personalService.getByID(response[ind].personal);
								promise	.done(function(data) {
									fila.find('td[name=responsable]').text(data.nombre+ " "	+ data.apellidos);
										});

							}
							var recursos = fila.find('td[name=resources]');
							recursos.html("<button class='resources btn btn-success' data-toggle='modal' data-target='#resourcesModal'   value='"+ response[ind].id+ "'>RECURSOS</button>");
							fila.appendTo('#classroomTable');
						});
	}

	function showOption(response) {
		$('option', '#responsible').remove();
		$.each(response, function(i, item) {

			$('#responsible').append($('<option>', {
				value : item.id,
				text : item.apellidos + "," + item.nombre
			}

			));
		});

	}

	function showPersonal() {
		var deferred = personalService.findMaestroLaboratorio();
		deferred.done(showOption).always(function() {
		});

	}


	function showResources(response) {
	 
		limpiarPantalla();
		$.each(	response,function(ind, elem) {
			var fila = $('tr.recursos:last').clone(true);
			fila.find('td[name=recurso]').text(response[ind].recursos.nombre +" "+ response[ind].recursos.descripcion);
		
			fila.find('td[name=cantidad]').text(response[ind].cantidad);
		
			fila.appendTo('#checkbox');
		});
	}
	
	function limpiarPantalla(){
		var recursos = $('.resourcesList tr').length;	
		$(".resourcesList tr").each(function(index) {

			if (index != 0) {
				$(this).remove();
			}

		});
	}

}(jQuery));
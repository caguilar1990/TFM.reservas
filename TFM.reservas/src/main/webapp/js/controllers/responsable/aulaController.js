(function($) {
	var aulaService = new AulaService();
	var personalService = new PersonalService();
	var resourcesService = new ResourceService();
	var IDPersonal= localStorage.getItem("ID");
	$(document).ready(function() {
		
		refreshClass();
		
		$("#formSelect").change(function() {
			refreshClass();

		});


		$("td").on("click", "button.resources", function() {
			 var identifica = $(this).val();
			var deferred = resourcesService.getAll();
			deferred.done(showResources).always(function() {
				
				var deferred = resourcesService.findbyIDAula(identifica);

				deferred.done(function(data) {
					$("#idAula").val(identifica);
					checkedResources(data);
				}).fail(function() {
					console.log ("No tiene Recursos asignados")
				});


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
							if (response[ind].personal == ""|| response[ind].personal == null) {
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

		$('.resources-tr').remove();
		$.each(response,function(i, item) {
							var insert = "<tr class='resources-tr'><td><input type='checkbox' name=resourcesItems  disabled id =resourcesItems value='"
									+ item.id
									+ "' > "
									+ item.nombre
									+ "<td></td></td>	<td><input  disabled type='text' name='"
									+ item.id
									+ "' style='width: 100px;'></td></tr>"
							$('#checkbox tbody').append(insert);
						});
	}

	function checkedResources(response){
		$.each(response,function(i, item) {
			//checked
			var $radios = $('input:checkbox[name="resourcesItems"]');
			$radios.filter('[value=' + response[i].id.idRecurso+ ']').prop('checked', true);
			// cantidad
			$("input:text[name='"+response[i].id.idRecurso+"']" ).val(response[i].cantidad);
		});

		
	}

	function refreshClass() {
		
		limpiarPantalla();
		if ($("#estadoSelect").val() == "") {
			// Buscar todas las aulas
			var deferred = aulaService.getAll();
			deferred.done(addRows).always(function() {
			});

		} else {
			// Busqueda por Estado
			var deferred = aulaService.findbyPersonal(IDPersonal);
			deferred.done(addRows).always(function() {
			});
		}

	}
	
	function limpiarPantalla() {
		var element = $('.classList tr').length;
		
		$(".classList tr").each(function(index) {

			if (index != 0) {
				$(this).remove();
			}

		});
		


	}


}(jQuery));
(function($) {
	var aulaService = new AulaService();
	var personalService = new PersonalService();
	var resourcesService = new ResourceService();

	$(document).ready(function() {

		var deferred = aulaService.getAll();
		deferred.done(addRows).always(function() {
			$('.table-spinner').hide();
		});

		// new Aula
		$("#addForm").submit(function(event) {
			addAula();

		});
		// resources
		$("#resourcesForm").submit(function(event) {
			editResourcesClassroom();

		});

		// edit
		$("#editAulaForm").submit(function(event) {
			updateAula();

		});

		// delete
		$("td").on("click", "button.delete", function() {
			removeAula($(this).val());

		});

		$("td").on("click", "button.edit", function() {
			getByID($(this).val());

		});

		$("td").on("click", "button.resources", function() {
			 var identifica = $(this).val();
			var deferred = resourcesService.getAll();
			deferred.done(showResources).always(function() {
				var promise = resourcesService.findbyIDAula(identifica);
				$("#idAula").val(identifica);
				promise.done(checkedResources);

			});
		});

		$("th").on("click", "button.add", function() {
			showPersonal();

		});

	});

	function addAula() {

		var aula = {
			referencia : $('#referenciaValue').val(),
			superficie : $('#superficieValue').val(),
			accesibilidad : $('input[name=optradio]:checked', '#addForm').val(),
			personal : {
				id : $("#responsible option:selected").val()
			}
		};

		var deferred = aulaService.addAula(aula);
		deferred.done(addRows).always(function() {
			location.reload(true)
		});

	}

	function updateAula() {

		var aula = {
			id : $('#idVal').val(),
			referencia : $('#referenciaVal').val(),
			superficie : $('#superficieVal').val(),
			accesibilidad : $('input[name=optradioEdit]:checked',
					'#editAulaForm').val(),
			personal : {
				id : $("#responsibleEdit option:selected").val(),
			}

		};

		var deferred = aulaService.updateAula(aula);
		deferred.done(addRows).always(function() {
			location.reload(true)
		});
	}

	function removeAula(identificador) {
		var deferred = aulaService.removeAula(identificador);
		deferred.done(addRows).always(function() {
			location.reload(true)
		});

	}

	function getByID(identificador) {
		var deferred = aulaService.getByID(identificador);
		deferred.done(showPersonalEdit).always(
				function(data) {
					$("#idVal").val(data.id);
					$("#referenciaVal").val(data.referencia);
					$("#superficieVal").val(data.superficie);
					var $radios = $('input:radio[name="optradioEdit"]');
					$radios.filter('[value=' + data.accesibilidad + ']').prop('checked', true);


				});

	}
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

							var edit = fila.find('td[name=edicion]');
							edit.html("<button class='edit btn btn-default'  data-toggle='modal' data-target='#editModal' value='"+ response[ind].id+ "'>EDITAR</button>");
							var recursos = fila.find('td[name=resources]');
							recursos.html("<button class='resources btn btn-success' data-toggle='modal' data-target='#resourcesModal'   value='"+ response[ind].id+ "'>RECURSOS</button>");
							var remove = fila.find('td[name=baja]');
							remove.html("<button class='delete btn btn-danger' value='"+ response[ind].id+ "'>BAJA</button>");
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

	function showPersonalEdit(response) {
		var deferred = personalService.findMaestroLaboratorio();
		deferred.done(function(data) {
			$('option', '#responsibleEdit').remove();
			$.each(data, function(i, item) {
				if(response.personal == item.id){
				$('#responsibleEdit').append($('<option>', {
					value : item.id,
					text : item.apellidos + "," + item.nombre,
					selected : true
					
				}));
				}
				else{
					$('#responsibleEdit').append($('<option>', {
						value : item.id,
						text : item.apellidos + "," + item.nombre
						
					}));	
					
				}
			});
		});

	}


	function showResources(response) {
		$('.resources-tr').remove();
		$.each(response,function(i, item) {
							var insert = "<tr class='resources-tr'><td><input type='checkbox' name=resourcesItems id =resourcesItems value='"
									+ item.id
									+ "' > "
									+ item.nombre
									+ "<td></td></td>	<td><input type='text' name='"
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
	function editResourcesClassroom() {
		var itemsAdd = new Array();
		var quantity = new Array();
		var itemsRemove = new Array();
		var value = 0;

		var checked = [];
		var notChecked = [];

		// Busco los seleccionados
		$("input:checkbox[name=resourcesItems]:checked").each(function() {
			itemsAdd.push($(this).val());
			value = $("input[name='" + $(this).val() + "']").val();
			if (value == "") {
				quantity.push("1");
			} else {
				quantity.push(value);
			}

		});
		for (var i = 0; i < quantity.length; i++) {
			var item = {
				cantidad : quantity[i],
				aula : {
					id : $('#idAula').val(),
				},
				recursos : {
					id : itemsAdd[i],
				}
			};

			checked.push(item);
		}

		var deferred = resourcesService.addResourcesClassroom(checked);
		deferred.always(function() {

		$("input:checkbox[name=resourcesItems]:not(:checked)").each(function() {
		var deferred = resourcesService	.removeResourceClassroom($('#idAula').val(),$(this).val());
		});

		});

	}

}(jQuery));
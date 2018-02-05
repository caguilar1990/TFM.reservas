(function($) {
	var resourceService = new ResourceService();
	var personalService = new PersonalService();
	var timeService = new TimeService();
	var bookingService = new BookingService();
	var flag;
	var IDPersonal= localStorage.getItem("ID");

	$(document).ready(function() {


		$("td").on("click", "button.booking", function() {
			var descripcion = $("#descripcion").val();
			if(descripcion == ""){
				alert("Por favor, introduce una descripción");
			}
			else{
				var aula = $(this).val();
				var fecha = $("#fechaInicial").val();
				var selectHorario = $.map($('input[name="listaHorario"]:checkbox:checked'), function(e,i) {
				    return +e.value;
				});
				
				$.map(selectHorario, function( val, i ) {
					addBooking(aula,val,descripcion);
				});	
			}
	

		});
		
		var today = moment().format('YYYY-MM-DD');
		$("#fechaInicial").val(today);
		// añado el tiempo
		var deferred = timeService.getAll();
		deferred.done(showOption).always(function() {
			$('input:checkbox[value="1"]').prop('checked', true);
			// añado los recursos
			var deferred = resourceService.getAll()
			deferred.done(showResources).always(function() {
				refreshClass();
			});
		
		});

		$("#formDaily").change(function() {
			refreshClass();

		});


						$("td").on("click", "button.resources", function() {
							var identifica = $(this).val();
							var deferred = resourceService.findbyIDAula(identifica);
							deferred.done(function(data) {
								mostrarDetalles(data);
							}).fail(function() {
//								alert("Usuario no Registrado");
							});
						});

					});
	


	//Muestra listado de horarios
	function showOption(response) {
		$.each(response, function (i, item) {
		    $('#horario').append($('<input type="checkbox" name = "listaHorario" value='+item.id+'>   '+ item.inicio + ' - ' + item.fin +'</input><br>'));
		});
	
	}
	
	function showResources(response) {
		var unica = true;
		$.each(response, function (i, item) {
			if(unica){
				//primera opcion seleccionada
				   $('#recursos').append($('<input type="checkbox" name = "listaRecursos" value='+item.id+' checked>   '+ item.nombre + '</input><br>'));
				   unica = false;
			}
			else{
				 $('#recursos').append($('<input type="checkbox" name = "listaRecursos" value='+item.id+'>   '+ item.nombre + '</input><br>'));
			}
		 
		});
	
	}
	function refreshClass (){
		limpiarPantalla(false);
		var selectHorario = $.map($('input[name="listaHorario"]:checkbox:checked'), function(e,i) {
		    return +e.value;
		});
		var selectRecursos = $.map($('input[name="listaRecursos"]:checkbox:checked'), function(e,i) {
		    return +e.value;
		});
		var deferred = bookingService.findClassroomsfree($("#fechaInicial").val(),selectHorario,selectRecursos);
		deferred.done(addRows).always(function() {
		});

	}

		function limpiarPantalla(recursos) {
			
			if(recursos){
				var recursos = $('.listaRecursos tr').length;	
				$(".listaRecursos tr").each(function(index) {

					if (index != 0) {
						$(this).remove();
					}

				});
			}
			else{
				var element = $('.classList tr').length;

				$(".classList tr").each(function(index) {

					if (index != 0) {
						$(this).remove();
					}

				});
			}
		

		
	}
	// Listado de Aulas
	function addRows(response) {

		$.each(response,function(ind, elem) {

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

							var edit = fila.find('td[name=booking]');
							edit.html("<button class='booking btn btn-success' value='"+ response[ind].id+ "'>Reservar</button>");
							var recursos = fila.find('td[name=resources]');
							recursos.html("<button class='resources btn btn-default' data-toggle='modal' data-target='#resourcesModal'   value='"+ response[ind].id+ "'>Ver Detalles</button>");
							fila.appendTo('#classroomTable');
						});
	}
	
	function addBooking(aula,horario,descripcion) {

		var booking = {
			id : {
				fechaReserva : $("#fechaInicial").val(),
				idHorario: horario,
				idAula:aula,
				idPersonal : IDPersonal,
			}  ,
			descripcion : descripcion,
		};

		var deferred = bookingService.addBooking(booking);
		deferred.done().always(function() {
			refreshClass();
		});

	}
	
	function mostrarDetalles(response){
		limpiarPantalla(true);
		$.each(	response,function(ind, elem) {
			var fila = $('tr.recurso:last').clone(true);
			fila.find('td[name=nombre]').text(response[ind].recursos.nombre);
			fila.find('td[name=descripcion]').text(response[ind].recursos.descripcion);
			fila.find('td[name=cantidad]').text(response[ind].cantidad);
			fila.appendTo('#detailTable');
		});
	}

}(jQuery));
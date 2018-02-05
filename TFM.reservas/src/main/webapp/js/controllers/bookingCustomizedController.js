(function($) {
	var timeService = new TimeService();
	var aulaService = new AulaService();
	var personalService = new PersonalService();
	var bookingService = new BookingService();

	var resourcesService = new ResourceService();
	var IDPersonal= localStorage.getItem("ID");
	$(document).ready(function() {
		
		//Checked
		verifyChecked();

		var deferred = aulaService.getAll();
		deferred.done(addRows).always(function() {
	
		});
		
		// smuestro horario
		showTime();
	
		


		$("td").on("click", "button.resources", function() {
			 var aula = $(this).val();
		
				var deferred = resourcesService.findbyIDAula(aula);
				deferred.done(showResources).fail(function() {
					console.log ("No tiene Recursos asignados")
				});


		
		});
		
		//Pulsa reservar
		$("td").on("click", "button.booking", function() {
			
			var aula = $(this).val();
			var fechaInicial = $("#fechaInicial").val();
			var fechaFinal = $("#fechaFin").val();
			var descripcion = $("#descripcion").val();
			var selectDay;
			var selectHorario = $.map($('input[name="listaHorario"]:checkbox:checked'), function(e,i) {
			    return +e.value;
			});
			
			if($("#allDays").is(":checked")){

				selectDay=99;
			}else{
				selectDay = $.map($('input[name="listDay"]:checkbox:checked'), function(e,i) {
				    return +e.value;
				});
			}
			
			
			if (fechaInicial === "" || fechaFinal === ""|| selectDay ==""  || descripcion == "") {
			   alert("Debes Rellenar todos los campos necesario");
			}
			else{
				reservar(aula,fechaInicial,fechaFinal,selectDay,selectHorario,descripcion);
			}
		
		
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
							recursos.html("<button class='resources btn btn-default' data-toggle='modal' data-target='#resourcesModal'   value='"+ response[ind].id+ "'>Ver Detalles</button>");
							var booking = fila.find('td[name=booking]');
							booking.html("<button class='booking btn btn-success' value='"+ response[ind].id+ "'>Reservar</button>");
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
		$.each(response, function(ind, elem) {
			var fila = $('tr.recursos:last').clone(true);
			fila.find('td[name=recurso]').text(	response[ind].recursos.nombre + " "	+ response[ind].recursos.descripcion);
			fila.find('td[name=cantidad]').text(response[ind].cantidad);

			fila.appendTo('#checkbox');
		});
	}
	
	function verifyChecked() {
		$('#allDays').prop('checked', true);
		$('#allDays').change(function() {
			if (!$(this).is(":checked")) {
				$('#personalizado').prop('hidden', false);
			} else {

				$('#personalizado').prop('hidden', true);

			}

		});

	}
	function showTime(){
		var deferred = timeService.getAll();
		deferred.done(showOption).always(function() {
			$('input:checkbox[value="1"]').prop('checked', true);
		});
		
		function showOption(response) {
			$.each(response, function (i, item) {
			    $('#horario').append($('<input type="checkbox" name = "listaHorario" value='+item.id+'>   '+ item.inicio + ' - ' + item.fin +'</input><br>'));
			});
		
		}
	}
	
	function reservar(aula,fechaInicial,fechaFinal,selectDay,selectHorario,descripcion){
		var deferred =bookingService.addBookingCustomize(aula,fechaInicial,fechaFinal,selectDay,selectHorario,IDPersonal,descripcion);

		deferred.done(showMessage).always(function() {
		});
		

	}
	
	function showMessage(response){
		if(response){
			alert("Reserva actualizada")
		}
		else{
			alert ("Ha habido un error al reservar el aula, compruebe sus reservas.")
		}
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
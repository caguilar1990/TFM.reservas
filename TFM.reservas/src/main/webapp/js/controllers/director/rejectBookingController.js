(function($) {
	var aulaService = new AulaService();
	var personalService = new PersonalService();
	var bookingService = new BookingService();


	
	$(document).ready(function() {
	
		var today = moment().format('YYYY-MM-DD');
		$("#fecha").val(today);
		refreshClass();

		$("#formDaily").change(function() {
			refreshClass();

		});

		$("td").on("click", "button.reject", function() {
			var reservaID = $(this).val();
			$("#reservaID").val(reservaID);
		

		
		});

		
				$("#deleteBooking").click(
						function() {
							var obj = JSON.parse($("#reservaID").val());
							var deferred = bookingService.removeBooking(obj.idPersonal, obj.idAula,	obj.fechaReserva, obj.idHorario);

							deferred.done().always(function() {
								refreshClass();
							});
						});
			});

	function showClassrooms(response) {
		
		$.each(	response,function(ind, elem) {
							var fila = $('tr.booking:last').clone(true);
							fila.find('td[name=classroom]').text(response[ind].aula.referencia);
							fila.find('td[name=datetime]').text(response[ind].horario.inicio + " - "	+ response[ind].horario.fin);
							fila.find('td[name=description]').text(response[ind].descripcion);
							var deferred = personalService.getByID(response[ind].id.idPersonal);
							deferred.done(function(value) {
								fila.find('td[name=teacher]').text(	value.nombre + " " + value.apellidos);
							});

							var deferred = aulaService.getByID(response[ind].aula.id);
							deferred.done(function(value) {

								var deferred = personalService.getByID(value.personal);
								deferred.done(function(value) {
									fila.find('td[name=master]').text(value.nombre + " "+ value.apellidos);
								});

							});
							var edit = fila.find('td[name="reject"]');

							var idReserva = {
									idPersonal: response[ind].id.idPersonal,
									idAula: response[ind].id.idAula,
									fechaReserva: response[ind].id.fechaReserva,
									idHorario: response[ind].id.idHorario
							};
							
					

						
							edit.html("<button class='reject btn btn-danger' value='"+ JSON.stringify(idReserva)+ "' data-toggle='modal' data-target='#myModal'>Eliminar</button>");
							fila.appendTo('#bookingTable');
						});
		
		

	}

	function refreshClass() {
		limpiarPantalla();
		//Ojooo eliminar todas las reservas
		var deferred = bookingService.findClassroomsBookingByDate($("#fecha").val(),0,0);
		deferred.done(showClassrooms).always(function() {
		});

	}

	function limpiarPantalla(){
		var element = $('.bookingList tr').length; 

		$( ".bookingList tr" ).each(function( index ) {
			
			if (index != 0){
				$( this ).remove();
			}
			 
			});
	}
	function removeBooking(){

	}
}(jQuery));
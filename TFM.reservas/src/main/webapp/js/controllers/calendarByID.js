(function($) {
	var bookingService = new BookingService();
	$(document).ready(function() {
		var today = moment().format('YYYY-MM-DD');

		jsonObj = [];
		var IDPersonal= localStorage.getItem("ID");

		var deferred = bookingService.findByPersonal(IDPersonal)
		deferred.done().always(function(data) {
			 
			 $.each(data, function(k, v) {
			        var title = v.aula.referencia + " - " + v.descripcion;
			        var start = v.id.fechaReserva + "T" + v.horario.inicio;
			        var end =  v.id.fechaReserva + "T" + v.horario.fin;

			        item = {}
			        item ["title"] = title;
			        item ["start"] = start;
			        item ["end"] = end;

			        jsonObj.push(item);
			    });

				$('#calendar').fullCalendar({
					header: {
						left: 'prev,next today',
						center: 'title',
						right: 'month,agendaWeek,agendaDay,listWeek'
					},
					defaultDate: today,
					navLinks: true, // can click day/week names to navigate views
					editable: true,
					eventLimit: true, // allow "more" link when too many events
					events: jsonObj,

				});
			    
			    

		});

	});

}(jQuery));
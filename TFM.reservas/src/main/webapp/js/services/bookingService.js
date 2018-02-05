function BookingService() {
	this.restUrl = '../../api/reservas/';
}


BookingService.prototype.addBooking = function(bookingClass) {
	return $.ajax({
		method : 'POST',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : this.restUrl,
		data: JSON.stringify(bookingClass),
	});

};


BookingService.prototype.addBookingCustomize = function(idAula, fInicial, fFinal, dias, horarios,idPersonal,descripcion) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : this.restUrl+idAula+"/"+fInicial+"/"+fFinal+"/"+dias+"/"+horarios+"/"+idPersonal+"/"+descripcion,

	});

};


BookingService.prototype.getAll = function() {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl,
	});
};


// aulas libres por fecha , horario y recurso

BookingService.prototype.findClassroomsfree = function(fecha,horario,recursos) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+fecha +"/"+horario+"/"+recursos,
	
	});
};


BookingService.prototype.findClassroomsBookingByDate = function(fecha,personal) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+fecha+"/personal/"+personal,
	
	});
};

BookingService.prototype.findClassroomsBookingByDateAndState = function(fecha,estado,personal) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+fecha+"/"+estado+"/personal/"+personal,
	
	});
};

BookingService.prototype.removeBooking = function(personal,aula,fecha,horario) {
	return $.ajax({
		method : 'DELETE',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+personal+"/"+aula+"/"+fecha+"/"+horario,
	
	});
};

BookingService.prototype.acceptBooking = function(personal,aula,fecha,horario) {
	return $.ajax({
		method : 'PUT',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+personal+"/"+aula+"/"+fecha+"/"+horario,
	
	});
};


//Profesor
BookingService.prototype.findByPersonal = function(IDPersonal) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+"/"+"/personal/"+IDPersonal,
	});
};

//Maestros

BookingService.prototype.findClassroomsBookingByDateMaster = function(fecha,maestro) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+fecha+"/maestros/"+maestro,
	
	});
};

BookingService.prototype.findClassroomsBookingByDateAndStateMaster = function(fecha,estado,maestro) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+fecha+"/"+estado+"/maestros/"+maestro,
	
	});
};




BookingService.prototype.getByMaster = function(maestro) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+"maestros/"+maestro,
	
	});
};


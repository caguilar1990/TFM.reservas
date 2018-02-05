function AulaService() {
	this.restUrl = '../../api/aulas/';
}



AulaService.prototype.getAll = function() {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl,
	});
};


AulaService.prototype.addAula = function(aula) {
	return $.ajax({
		method : 'POST',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : this.restUrl,
		data: JSON.stringify(aula),
	});

};

AulaService.prototype.updateAula = function(aula) {
	return $.ajax({
		method : 'PUT',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : this.restUrl,
		data: JSON.stringify(aula),
	});

};


AulaService.prototype.removeAula = function(aulaID) {
	return $.ajax({
		method : 'DELETE',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+ aulaID,
	
	});
};
	
AulaService.prototype.findbyPersonal = function(aulaID) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+ "maestros/"+ aulaID,
	});
};

AulaService.prototype.getByID = function(aulaID) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+ aulaID,
	});
};



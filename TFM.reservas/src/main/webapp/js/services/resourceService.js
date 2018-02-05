function ResourceService() {
	this.restUrl = '../../api/recursos/';
}
ResourceService.prototype.getAll = function() {
	return $.ajax({
		method : 'get',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl,
	});
};

ResourceService.prototype.removeResource = function(resourceID) {
	return $.ajax({
		method : 'DELETE',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl + resourceID,

	});
};

ResourceService.prototype.addResource = function(resource) {
	return $.ajax({
		method : 'POST',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : this.restUrl,
		data: JSON.stringify(resource),
	});

};


ResourceService.prototype.updateResource = function(resource) {
	return $.ajax({
		method : 'PUT',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : this.restUrl,
		data: JSON.stringify(resource),
	});

};


ResourceService.prototype.getByID = function(resourceID) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : this.restUrl + resourceID,

	});

};
// AULA_RECURSOS
ResourceService.prototype.addResourcesClassroom = function(resourceClass) {

		return $.ajax({
			method : 'POST',
			dataType : "json",
			headers : {	'Content-Type' : 'application/json'	},
			url : '../../api/aulaRecursos/',
			data: JSON.stringify(resourceClass),
		});

};

ResourceService.prototype.removeResourceClassroom = function(classID,resourceID) {
	return $.ajax({
		method : 'DELETE',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : '../../api/aulaRecursos/'+classID +"/"+resourceID,
	
	});
};

ResourceService.prototype.findbyIDAula = function(classID) {
	
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : '../../api/aulaRecursos/' + classID,

	});

};

function PersonalService() {
	this.restUrl = '../../api/personal/';
}



PersonalService.prototype.getAll = function() {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl,
	});
};


PersonalService.prototype.addPersonal = function(personal) {
	return $.ajax({
		method : 'POST',
		dataType : "json",
		headers : {	'Content-Type' : 'application/json'	},
		url : this.restUrl,
		data: JSON.stringify(personal),
	});

};

PersonalService.prototype.removePersonal = function(personalID) {
	return $.ajax({
		method : 'DELETE',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+ personalID,
	
	});
};
	
PersonalService.prototype.getByID = function(personalID) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+ personalID,
		success: function (data) {
            return data;
        },
	});
};

PersonalService.prototype.findMaestroLaboratorio = function() {
	var urlMaestro = "maestros/";
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+urlMaestro,
	});
};


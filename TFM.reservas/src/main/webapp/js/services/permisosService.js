function PermisosService() {
	this.restUrl = '../../api/permisos/';
}

PermisosService.prototype.getAll = function() {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl,
	});
};




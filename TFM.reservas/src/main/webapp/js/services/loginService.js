function LoginService() {
	this.restUrl = '/TFM.reserva/api/login/';
}

LoginService.prototype.searchByUsername = function(username) {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl+ username,
	});
};


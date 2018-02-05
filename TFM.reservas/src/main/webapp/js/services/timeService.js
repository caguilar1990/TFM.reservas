function TimeService() {
	this.restUrl = '../../api/horarios/';
}



TimeService.prototype.getAll = function() {
	return $.ajax({
		method : 'GET',
		dataType : "json",
		headers : {
			'Content-Type' : 'application/json'
		},
		url : this.restUrl,
	});
};




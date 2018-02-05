(function($) {
	var resourceService = new ResourceService();

	$(document).ready(function() {

		var deferred = resourceService.getAll();
		deferred.done(addRows).always(function() {
			$('.table-spinner').hide();
		});

		// delete
		$("td").on("click", "button.delete", function() {
			removeResource($(this).val());

		});
		$("#addResourceForm").submit(function(event) {
			addResource();

		});

		$("td").on("click", "button.edit", function() {
			getByID($(this).val());

		});

		$("#editResourceForm").submit(function(event) {
			updateResource();

		});

	});

	function getByID(identificador) {
		var deferred = resourceService.getByID(identificador);
		deferred.done(showResource).always(function() {

		});

	}

	function updateResource() {

		var resource = {

			id : $('#editId').val(),
			nombre : $('#editName').val(),
			descripcion : $('#editDescription').val(),
		};

		var deferred = resourceService.updateResource(resource);
		deferred.done(addRows).always(function() {
			location.reload(true)
		});

	}

	function addResource() {

		var resource = {
			nombre : $('#addName').val(),
			descripcion : $('#addDescription').val(),
		};

		var deferred = resourceService.addResource(resource);
		deferred.done(addRows).always(function() {
			location.reload(true)
		});

	}
	function removeResource(identificador) {
		var deferred = resourceService.removeResource(identificador);
		deferred.done(addRows).always(function() {
			location.reload(true)
		});

	}
	function addRows(response) {
		$.each(	response,function(ind, elem) {
							var fila = $('tr:last').clone(true);
							fila.find('td[name=name]').text(response[ind].nombre);
							fila.find('td[name=description]').text(	response[ind].descripcion);
							var edit = fila.find('td[name=edit]');
							edit.html("<button class='edit btn btn-default'  data-toggle='modal' data-target='#editModal' value='"
											+ response[ind].id
											+ "'>EDIT</button>");
							var remove = fila.find('td[name=delete]');
							remove.html("<button class='delete btn btn-danger' value='"	+ response[ind].id+ "'>DELETE</button>");
							fila.appendTo('table');
						});
	}

	function showResource(response) {

		$("#editId").val(response.id);
		$("#editName").val(response.nombre);
		$("#editDescription").val(response.descripcion);

	}

}(jQuery));
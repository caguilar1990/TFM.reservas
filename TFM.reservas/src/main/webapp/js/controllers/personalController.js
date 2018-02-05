(function($) {
	var personalService = new PersonalService();
	var permisosService = new PermisosService();


	$(document).ready(function() {

		var deferred = personalService.getAll();
		deferred.done(addRows).always(function() {
			$('.table-spinner').hide();
		});
		
		var deferred = permisosService.getAll();
		deferred.done(showOption).always(function() {
			$('.table-spinner').hide();
		});

		//	new Personal
		$("#addForm").submit(function(event) {
			addPersonal();
	
		});

		$("td").on("click", "button.delete", function() {
			removePersonal($(this).val());
				
		});
		
	
		
	
	});

	function addPersonal() {

		var personal = 
		{
			username    : $('#usernameValue').val(),
			nombre    : $('#nameValue').val(),
			apellidos : $('#lastNameValue').val(),
			permisos  :
					{
					id :$( "#role option:selected" ).val()
					}
	
		};



		var deferred = personalService.addPersonal(personal);
		deferred.done(addRows).always(function() {
			location.reload(true)
		});
	
	}
	

	function removePersonal(identificador) {
		var deferred = personalService.removePersonal(identificador);
		deferred.done(addRows).always(function() {
			location.reload(true)
		});

	}


	function addRows(response) {
		$.each(response, function(ind, elem) {
			var fila = $('tr:last').clone(true);
			fila.find('td[name=username]').text(response[ind].username);
			fila.find('td[name=name]').text(response[ind].nombre);
			fila.find('td[name=lastName]').text(response[ind].apellidos);
			fila.find('td[name=role]').text(response[ind].permisos.descripcion);
			var edit = fila.find('td[name=edicion]');
			edit.html("<button class='edit btn btn-default'  data-toggle='modal' data-target='#editModal' value='"	+ response[ind].id + "'>EDIT</button>");
			var remove = fila.find('td[name=baja]');
			remove.html("<button class='delete btn btn-danger' value='"	+ response[ind].id + "'>DELETE</button>");
			fila.appendTo('table');
		});
	}
	
		function showOption(response) {
			$('option', '#role').remove();
			$.each(response, function (i, item) {
			    $('#role').append($('<option>', { 
			        value: item.id,
			        text : item.descripcion 
			    }
			    
			    ));
			});
		
		}

}(jQuery));
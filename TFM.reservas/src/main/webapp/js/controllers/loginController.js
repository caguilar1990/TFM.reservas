(function($) {
	var loginService = new LoginService();

	$(document).ready(function() {

		$("#autenticacion").click(function() {
			autenticacion();
		});

	});

	function autenticacion() {
		var username = $("#usuario").val();

		var deferred = loginService.searchByUsername(username);

		deferred.done(function(data) {
			if (data.pass == null) {
				alert("No tiene password")
			} else {
			
				var password = $("#password").val();
				if (data.pass == password) {
					redireccionaPerfil(data);

				} else {
					alert("Password incorrecta");
				}
			}

		}).fail(function() {
			alert("Usuario no Registrado");
		});

	}
	

		function redireccionaPerfil(data) {
		localStorage.setItem("ID", data.id);
		localStorage.setItem("Perfil", data.permisos.id);
		localStorage.setItem("Nombre", data.nombre + " " + data.apellidos);

		switch (data.permisos.id) {
		case 1:
			location.href = "/TFM.reserva/pages/administrador/index.jsp";
			break;
		case 2:
			location.href = "/TFM.reserva/pages/director/index.jsp";
			break;
		case 3:
			location.href = "/TFM.reserva/pages/responsable/index.jsp";
			break;
		default:
			location.href = "/TFM.reserva/pages/profesor/index.jsp";
		}

	}
	
	

}(jQuery));
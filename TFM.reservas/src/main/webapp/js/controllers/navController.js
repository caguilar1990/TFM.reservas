(function($) {

	$(document).ready(function() {

		$("#logout").on("click", function() {

			localStorage.clear();
			location.href = "/TFM.reserva/index.jsp";
		});

	});

}(jQuery));
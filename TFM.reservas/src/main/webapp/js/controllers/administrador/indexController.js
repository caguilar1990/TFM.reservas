(function($) {
	var IDPersonal= localStorage.getItem("Perfil");

	$(document).ready(function() {
		
		
		switch(IDPersonal) {
	   // ADMINISTRADOR
		case 1:
			{
			$("#aulas").click(function() {
				location.href = "/TFM.reserva/pages/administrador/classroom.jsp";
			});
			$("#recursos").click(function() {
				location.href = "/TFM.reserva/pages/administrador/resources.jsp";
			});
			$("#personas").click(function() {
				location.href = "/TFM.reserva/pages/administrador/personal.jsp";
			});
			$("#calendarios").click(function() {
				$("#target").click();
			});
			 break;
			}
	       //director
	    case 2:
		{
			$("#aulas").click(function() {
				location.href = "/TFM.reserva/pages/administrador/classroom.jsp";
			});
			$("#recursos").click(function() {
				location.href = "/TFM.reserva/pages/administrador/resources.jsp";
			});
			$("#personas").click(function() {
				location.href = "/TFM.reserva/pages/administrador/personal.jsp";
			});
			$("#calendarios").click(function() {
				$("#target").click();
			});
			 break;
			}
		//Maestro de laboratorio
	    case 3:
		{
			$("#aulas").click(function() {
				location.href = "/TFM.reserva/pages/administrador/classroom.jsp";
			});
			$("#recursos").click(function() {
				location.href = "/TFM.reserva/pages/administrador/resources.jsp";
			});
			$("#personas").click(function() {
				location.href = "/TFM.reserva/pages/administrador/personal.jsp";
			});
			$("#calendarios").click(function() {
				$("#target").click();
			});
			 break;
		}
	    default:
		{
			$("#aulas").click(function() {
				location.href = "/TFM.reserva/pages/administrador/classroom.jsp";
			});
			$("#recursos").click(function() {
				location.href = "/TFM.reserva/pages/administrador/resources.jsp";
			});
			$("#personas").click(function() {
				location.href = "/TFM.reserva/pages/administrador/personal.jsp";
			});
			$("#calendarios").click(function() {
				$("#target").click();
			});
			 break;
		}
	} 
		


	});

}(jQuery));
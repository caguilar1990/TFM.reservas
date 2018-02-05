<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>ClassRoom List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>

<link href='../../css/fullcalendar.min.css' rel='stylesheet' />
<link href='../../css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='../../js/scripts/moment.min.js'></script>
<script src='../../js/scripts/fullcalendar.min.js'></script>
<script src="../../js/services/bookingService.js"></script>
<script src="../../js/controllers/fullCalendarController.js"></script>
</head>
<body>
<jsp:include page="/pages/director/nav.jsp" />

	<div class="container">
	<h2>Calendario de todas las Reservas</h2>
		<div id='calendar'></div>

	</div>

</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Booking List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.js"></script>



<script src="../../js/services/aulaService.js"></script>
<script src="../../js/services/timeService.js"></script>
<script src="../../js/services/personalService.js"></script>
<script src="../../js/services/bookingService.js"></script>
<script src="../../js/controllers/bookingListController.js"></script>

</head>
<body>
	<jsp:include page="/pages/director/nav.jsp" />

	<div class="container">
		<h2>Gestion de Reservas</h2>

		<div class="col-md-8">  
		<table class="table" id="bookingTable">

			<thead>
				<tr class="active">
					<th>Aula</th>
					<th>Horario</th>
					<th>Descripción</th>
					<th>Solicitante</th>
					<th>Maestro de Laboratorio</th>
					<th></th>
				</tr>
			</thead>
			<tbody  class='bookingList'>
			<tr class="booking">
					<td name="classroom"></td>
					<td name="datetime"></td>
					<td name="description"></td>
					<td name="teacher"></td>
					<td name="master"></td>
					<td name="accept"></td>
					
				</tr>
			</tbody>
			
		</table>
		
		</div>
		<form class="form" id="formDaily">
		<div class="col-md-4">  
			<div class="form-group">
				<label >Fecha: </label> 
				<input type="date"  id="fecha"  width="50%">
			</div>
			<div class="form-group">
							<label for="message-text" class="form-control-label">Estado:</label>
							<select class="form-control" name = "estadoSelect" id="estadoSelect"  required="required">
								<option value="">Todos</option>
							  	<option value=false>Pendiente</option>
  								<option value=true>Confirmado</option>
						   </select>
			</div>
		</div>
		
			<br>
		
		</form>
		<br>
		<br>


	</div>
</body>
</html>
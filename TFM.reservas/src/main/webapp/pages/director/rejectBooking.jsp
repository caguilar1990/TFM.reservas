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
<script src="../../js/services/personalService.js"></script>
<script src="../../js/services/bookingService.js"></script>
<script src="../../js/controllers/director/rejectBookingController.js"></script>

</head>
<body>
	<jsp:include page="/pages/director/nav.jsp" />

	<div class="container">
		<h2>Cancelación Reservas</h2>

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
					<td name="reject"></td>
					
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
		</div>
		
			<br>
		
		</form>
		<br>
		<br>


	</div>
	  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <input type="text"  id="reservaID" hidden=true>
          <h4 class="modal-title">BAJA RESERVA</h4>
        </div>
        <div class="modal-body">
            <div class="alert alert-danger">
   			 ¿Esta seguro de eliminar la reserva?
  			</div>
        </div>
        <div class="modal-footer">
       	<button type="button" class="btn btn-primary" data-dismiss="modal" id="deleteBooking">Si</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
        </div>
      </div>
      
    </div>
  </div>
</body>
</html>
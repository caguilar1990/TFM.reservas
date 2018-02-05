<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>ClassRoom List</title>
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
<script src="../../js/services/resourceService.js"></script>
<script src="../../js/services/bookingService.js"></script>
<script src="../../js/controllers/bookingController.js"></script>

</head>
<body>
	<jsp:include page="/pages/responsable/nav.jsp" />

	<div class="container">
		<h2>Reserva de Aulas por día</h2>
		<p>Mediante los filtros de búsqueda , podrá reservar aulas en el día seleccionado.</p>
		<p></p>

		

		<div class="col-12 col-md-8">  
		<table class="table" id="classroomTable">

			<thead>
				<tr class="active">
					<th>Referencia</th>
					<th>Area</th>
					<th>Accesibilidad</th>
					<th>Responsable</th>
					<th></th>
					<th></th>
					<th></th>
					
				
				</tr>
			</thead>
			<tbody  class='classList'>
			<tr class="classrooms">
					<td name="referencia"></td>
					<td name="superficie"></td>
					<td name="accesibilidad"></td>
					<td name="responsable"></td>
					<td name="resources"></td>
					<td name="booking"></td>
					<th></th>
					
				</tr>
			</tbody>
		</table>
		
		</div>
		<div class="col-6 col-md-4"> 
		<div class="form-group">
				<label>Descripcion </label> 
				<input type="text" id="descripcion" class ="form-control">
		</div>
		
		<form class="form" id="formDaily" >
 
			<div class="form-group">
				<label >Día</label> <input type="date"  id="fechaInicial"  width="50%">
			</div>

			<div class="form-group">
				<label >Horario:</label><div  id="horario"  >	</div>
			</div>	
			<div class="form-group">
				<label >Recursos:</label><div  id="recursos"  >	</div>
			</div>	

		
			<br>
		
		</form>
				</div>
	



	</div>
<!-- Detalles -->
<div class="modal fade" id="resourcesModal" tabindex="-1" role="dialog" 	aria-labelledby="resourcesModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="resourcesModal">Recursos</h4>
					<input type="text"  id="idAula" hidden=true>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="resourcesForm">
						<div id="checkbox">
							<table id="detailTable" class="table table-bordered">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Descripción</th>
										<th>Unidades</th>
									</tr>
								</thead>
								<tbody  class='listaRecursos'>
								<tr class="recurso">
									<td name="nombre"></td>
									<td name="descripcion"></td>
									<td name="cantidad"></td>
								</tr>
							</tbody>
							</table>
						</div>

					</form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
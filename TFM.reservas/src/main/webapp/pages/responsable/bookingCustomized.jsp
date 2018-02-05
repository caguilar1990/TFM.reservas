<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>ClassRoom List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../../js/services/aulaService.js"></script>
<script src="../../js/services/personalService.js"></script>
<script src="../../js/services/resourceService.js"></script>
<script src="../../js/services/timeService.js"></script>
<script src="../../js/services/bookingService.js"></script>
<script src="../../js/controllers/bookingCustomizedController.js"></script>

   
</head>
<body>
<jsp:include page="/pages/responsable/nav.jsp" />

	<div class="container">
		<h2>Consulta de Aulas</h2>
<div class="col-12 col-md-8">  
		<table class="table" id="classroomTable">

			<thead>
				<tr class="active">
					<th>Numero de Aula</th>
					<th>Área</th>
					<th>Accesibilidad</th>
					<th>Maestro de Laboratorio</th>
					<th></th>
					<th></th>
					
				
				</tr>
			</thead>
			<tbody>
				<tr class="classrooms">
					<td name="referencia"></td>
					<td name="superficie"></td>
					<td name="accesibilidad"></td>
					<td name="responsable"></td>
					<td name="resources"></td>
					<td name="booking"></td>
				
					
				</tr>
			</tbody>
		</table>
		</div>
	 <div class="col-md-4">
				<form class="form" id="formDaily">
					<div class="form-group">
						<label>Fecha Inicio</label> 
						<input type="date" id="fechaInicial" class ="form-control">
					</div>

					<div class="form-group">
						<label>Fecha Fin </label> 
						<input type="date" id="fechaFin" class ="form-control">
					</div>
					<div class="form-group">
						<label>Descripcion </label> 
						<input type="text" id="descripcion" class ="form-control">
					</div>

					<div class="checkbox">
						<label> <input type="checkbox" id="allDays">  Todos los días
						</label>
					</div>

					<div id="personalizado" hidden="true">
						<label class="checkbox-inline"> 
						<input type="checkbox"  name=listDay value="2">Lunes</label>
						<label class="checkbox-inline"> 
						<input type="checkbox"	name=listDay  value="3">Martes</label> 
						<label class="checkbox-inline"> 
						<input type="checkbox"  name=listDay  value="4">Miercoles</label>
						<br>
						<label class="checkbox-inline"> 
						<input type="checkbox"  name=listDay  value="5">Jueves</label>
						<label class="checkbox-inline"> 
						<input type="checkbox"  name=listDay value="6">Viernes</label>
						<label class="checkbox-inline"> 
						<input type="checkbox"  name=listDay  value="7"> Sabado</label>

					</div>
					<div class="form-group">
						<label>Horario:</label>
						<div id="horario"></div>
					</div>
				</form>
			</div>
	</div>

<!-- RESOURCES -->
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
						<div >
							<table id="checkbox" class="table table-bordered">
								<thead>
									<tr>
										<th>Recurso</th>
										<th></th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody  class='resourcesList'>
								<tr class="recursos">
									<td name="recurso"></td>
									<td name=""></td>
									<td name="cantidad"></td>
					
								</tr>
								</tbody >
							</table>

						</div>

					</form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
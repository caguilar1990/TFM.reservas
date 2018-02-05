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
<script src="../../js/controllers/responsable/aulaController.js"></script>

   
</head>
<body>
<jsp:include page="/pages/responsable/nav.jsp" />

	<div class="container">
		<h2>Consulta de Aulas</h2>
		<div class="col-md-10">  
		<table class="table" id="classroomTable">

			<thead>
				<tr class="active">
					<th>Numero de Aula</th>
					<th>Área</th>
					<th>Accesibilidad</th>
					<th>Maestro de Laboratorio</th>
					<th></th>
					<th></th>
					<th></th>
					
				
				</tr>
			</thead>
			<tbody class="classList">
				<tr class="classrooms">
					<td name="referencia"></td>
					<td name="superficie"></td>
					<td name="accesibilidad"></td>
					<td name="responsable"></td>
					<td name="resources"></td>
					<th></th>
					
				</tr>
			</tbody>
		</table>
		</div>
		<div class="col-md-2"> 
		<form class="form" id="formSelect">
			<div class="form-group">
							<label for="message-text" class="form-control-label">Selecciona Listado:</label>
							<select class="form-control" name = "estadoSelect" id="estadoSelect"  required="required">
								<option value="">Todas</option>
  								<option value=true>Mis Aulas</option>
						   </select>
			</div>
			<br>
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
						<div id="checkbox">
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
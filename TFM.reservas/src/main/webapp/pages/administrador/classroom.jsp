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
<script src="../../js/controllers/administrador/aulaController.js"></script>

   
</head>
<body>
<jsp:include page="/pages/administrador/nav.jsp" />

	<div class="container">
		<h2>Gestión de Aulas</h2>
		<table class="table" id="classroomTable">
			<thead>
				<tr class="active">
					<th>Aula</th>
					<th>Area</th>
					<th>Accesibilidad</th>
					<th>Maestro de Laboratorio</th>
					<th></th>
					<th></th>
					<th><button type="button" class="add btn btn-primary" data-toggle="modal" data-target="#addModal">NUEVA</button></th>
					<th></th>
					
				
				</tr>
			</thead>
			<tbody>
				<tr class="classrooms">
					<td name="referencia"></td>
					<td name="superficie"></td>
					<td name="accesibilidad"></td>
					<td name="responsable"></td>
					<td name="edicion"></td>
					<td name="resources"></td>
					<td name="baja"></td>
					<th></th>
					
				</tr>
			</tbody>
		</table>
	</div>
<!-- AÑADIR AULA -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" 	aria-labelledby="addModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addModal">Nueva Aula</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="addForm">
						<div class="form-group">
							<label for="recipient-name" class="form-control-label">ID Aula:</label>
							<input type="number" class="form-control" name = "referenciaValue" id="referenciaValue" required="required">
						</div>
						<div class="form-group">
							<label for="message-text" class="form-control-label">Superficie:</label>
							<input type="number"  step="0.01" class="form-control" name = "superficieValue" id="superficieValue"  required="required">
						</div>
						<div class="form-group">
							<label for="message-text" class="form-control-label">Accesibilidad:</label>
							<label class="radio-inline"><input type="radio"	name="optradio" value=true>SI</label>
							<label class="radio-inline"><input type="radio" name="optradio" value=false checked>NO</label>
						</div>
							<div class="form-group">
							<label for="message-text" class="form-control-label">Maestro de Laboratorio:</label>
							<select class="form-control" name = "responsible" id="responsible"  required="required">
							</select>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"		data-dismiss="modal">Cancelar</button>
							<input id="addAula" type="submit" class="btn btn-primary" value="ACEPTAR">
						</div>
					
					</form>
				</div>
				
			</div>
		</div>
	</div>

<!-- MODIFICAR AULA -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" 	aria-labelledby="editModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="editModal">EDITAR AULA</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="editAulaForm">
					<div class="form-group">
							<label for="recipient-name" class="form-control-label">ID Aula:</label>
							<input class="form-control" name = "idValue" id="idVal" disabled>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="form-control-label">Referencia:</label>
							<input class="form-control" name = "referenciaValue" id="referenciaVal" disabled>
						</div>
						<div class="form-group">
							<label for="message-text" class="form-control-label">Superficie:</label>
							<input type="number"  step="0.01" class="form-control" name = "superficieValue" id="superficieVal" required="required" >
						</div>
						<div class="form-group">
							<label for="message-text" class="form-control-label">Accesibilidad:</label>
							<label class="radio-inline"><input type="radio"	name="optradioEdit" value=true>SI</label>
							<label class="radio-inline"><input type="radio" name="optradioEdit" value=false checked>NO</label>
						</div>
						
							<div class="form-group">
							<label for="message-text" class="form-control-label">Maestro de Laboratorio:</label>
							<select class="form-control" name = "responsibleEdit" id="responsibleEdit"  required="required">
							</select>
						</div>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"		data-dismiss="modal">Cancelar</button>
							<input id="editAula" type="submit" class="btn btn-primary" value="ACEPTAR">
						</div>
					</form>
				</div>
				
			</div>
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
										<th>Name</th>
										<th></th>
										<th>Quantity</th>
									</tr>
								</thead>
								<tbody >
								
								</tbody >
							</table>

						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"	data-dismiss="modal">CANCEL</button>
							<input id="saveResouces" type="submit" class="btn btn-primary"	value="SAVE">
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
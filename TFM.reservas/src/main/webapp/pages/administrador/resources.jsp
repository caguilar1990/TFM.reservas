<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Listado de Recursos</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../../js/services/resourceService.js"></script>
<script src="../../js/controllers/resourceController.js"></script>
</head>
<body>
<jsp:include page="/pages/administrador/nav.jsp" />
	<div class="container">
		<h2>Gestión de Recursos</h2>
		<table class="table">
			<thead>
				<tr class="active">
					<th>Nombre</th>
					<th>Descripción</th>
					<th><button type="button" class="btn btn-primary"data-toggle="modal" data-target="#addModal">Alta</button></th>
					<th></th>
					<th></th>


				</tr>
			</thead>
			<tbody>
				<tr>
					<td name="name"></td>
					<td name="description"></td>
					<td name="edit"></td>
					<td name="delete"></td>
					<th></th>

				</tr>
			</tbody>
		</table>
	</div>
	
	<!-- AÑADIR RECURSO -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" 	aria-labelledby="addModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addModal">Alta Recurso</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="addResourceForm">
						<div class="form-group">
							<label for="recipient-name" class="form-control-label">Nombre:</label>
							<input type="text" class="form-control" name = "addName" id="addName" required="required">
						</div>
						<div class="form-group">
							<label for="message-text" class="form-control-label">Descripción:</label>
							<input type="text" class="form-control" name = "addDescription" id="addDescription"  required="required">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"		data-dismiss="modal">Cancelar</button>
							<input  type="submit" class="btn btn-primary" value="SAVE">
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
	
	
	
	<!-- EDIT RESOURCE -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" 	aria-labelledby="editModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="editModal">Modificar Recurso</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="editResourceForm">
					<div class="form-group">
							<label for="recipient-name" class="form-control-label">ID Recurso:</label>
							<input type="text" class="form-control" name = "editId" id="editId" disabled>
						</div>
						
						<div class="form-group">
							<label for="recipient-name" class="form-control-label">Nombre:</label>
							<input type="text" class="form-control" name = "editName" id="editName" disabled>
						</div>
						<div class="form-group">
							<label for="message-text" class="form-control-label">Descripción:</label>
							<input type="text" class="form-control" name = "editDescription" id="editDescription"  required="required">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"		data-dismiss="modal">Cancelar</button>
							<input  type="submit" class="btn btn-primary" value="UPDATE">
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>ClassRoom List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../../js/services/personalService.js"></script>
<script src="../../js/services/permisosService.js"></script>
<script src="../../js/controllers/personalController.js"></script>

   
</head>
<body>
<jsp:include page="/pages/administrador/nav.jsp" />
	<div class="container">
		<h2>Gestión de Personas</h2>
		<table class="table">

			<thead>
				<tr class="active">
					<th>Usuario</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Perfil</th>
					<th><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal">NEW ITEM</button></th>
					<th></th>
					
				
				</tr>
			</thead>
			<tbody>
				<tr>
					<td name="username"></td>
					<td name="name"></td>
					<td name="lastName"></td>
					<td name="role"></td>
					<th></th>
					<td name="baja"></td>
					
				</tr>
			</tbody>
		</table>
	</div>
<!-- AÑADIR AULA -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" 	aria-labelledby="addModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addModal">Alta Personal</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="addForm">
						<div class="form-group">
							<label for="recipient-name" class="form-control-label">Usuario:</label>
							<input type="text" class="form-control" name = "usernameValue" id="usernameValue" required="required">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="form-control-label">Nombre:</label>
							<input type="text" class="form-control" name = "nameValue" id="nameValue" required="required">
						</div>
						<div class="form-group">
							<label for="message-text" class="form-control-label">Apellidos:</label>
							<input type="text" class="form-control" name = "lastNameValue" id="lastNameValue"  required="required">
						</div>

						<div class="form-group">
							<label for="message-text" class="form-control-label">Perfil:</label>
							<select class="form-control" name = "role" id="role"  required="required">
							</select>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"		data-dismiss="modal">Cancelar</button>
							<input id="addPersonal" type="submit" class="btn btn-primary" value="SUBMIT">
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>

</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/TFM.reserva/js/scripts/require.js"></script>
<script src="/TFM.reserva/js/services/loginService.js"></script>
<script src="/TFM.reserva/js/controllers/loginController.js"></script>
<title>Class booking UPM</title>


</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Reserva de Aulas </a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<div   class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="usuario" id="usuario" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="contraseña" id="password" class="form-control">
					</div>
					<button id ="autenticacion" class="autentica btn btn-success">Acceso</button>
				</div>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

    <div class="jumbotron">
      <div class="container">
        <h1>
        Reservas UPM
        </h1>
        <p>Web para la gestión de reservas de aulas.</p>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-md-4">
           <p align="center"><img src="/TFM.reserva/img/IMG_1.JPG" height="300px" width="300px"/></p>
        </div>
        <div class="col-md-4">
         <p align="center"><img src="/TFM.reserva/img/IMG_2.JPG" height="350px" width="350px"/></p>
       </div>
        <div class="col-md-4">
          <p align="center"><img src="/TFM.reserva/img/IMG_4.JPG" height="300px" width="300px"/></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Cecilia Aguilar Mendez.</p>
      </footer>
    </div> 

  </body>
</html>
	


<script src="../../js/controllers/navController.js"></script>
<div class="navbar-wrapper">
	<div class="container">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">PROFESOR</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="/TFM.reserva/pages/profesor/index.jsp">Home</a></li>
					<li><a href="/TFM.reserva/pages/profesor/classroom.jsp">Listado de Aulas</a></li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mis Reservas<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/TFM.reserva/pages/profesor/bookingList.jsp">Listado</a></li>
							<li><a href="/TFM.reserva/pages/profesor/calendarByID.jsp">Calendario</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reservar<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/TFM.reserva/pages/profesor/bookingDay.jsp">Diario</a></li>
							<li><a href="/TFM.reserva/pages/profesor/bookingCustomized.jsp">Personalizado</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
					<a id="logout" href="#">
						<span class="glyphicon glyphicon-log-out"></span> Log out</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
</div>
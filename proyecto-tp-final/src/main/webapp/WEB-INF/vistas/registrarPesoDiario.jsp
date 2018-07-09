<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="css/estilos.css">
	</head>
	<body>
	

		
		<header class="header container">
			<h1 class="logo">Registrar Peso Diario</h1>
			<nav>
                 <ul class="container">
                    <li><a href="home">Inicio</a></li>
                    <li><a href="paciente">Elegir Plan Nutricional</a></li>
                    <li><a class="btn active white"  href="registrarPesoDiario">Registrar Peso Diario</a></li>
                    <li><a href="progresoSeleccionarPaciente">Ver Progreso</a></li>
                </ul>
            </nav>
		</header>
		<div class = "main container">	
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				
			<form:form action="completarRegistroPesoDiario" method="POST" modelAttribute="registrarPesoDiarioDTO">
				
				<br>
				<form:label path="peso">Peso</form:label>
				<form:input path="peso" id="peso" type="number" class="form-control" required="required" placeholder="Exprese su peso en kilogramos" /> 
				<br>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit">Confirmar</button>
			
			</form:form>
			<%--Bloque que es visible si el elemento error no está vacío	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>

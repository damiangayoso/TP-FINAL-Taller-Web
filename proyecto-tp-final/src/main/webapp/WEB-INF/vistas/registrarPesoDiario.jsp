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
			<h1 class="logo">Control Nutricional</h1>
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
			<h3 class="form-signin-heading">Registrar Peso Diario</h3>
				<br />
				<c:choose>
					<c:when test="${not empty error}">
						<hr class="colorgraph"><br>
						<%--Bloque que es visible si el elemento error no está vacío	--%>
				        <h4><span style="color:red;">${error}</span></h4>
				        <br>
			        </c:when>
			        <c:otherwise>
						<form:form action="completarRegistroPesoDiario" method="POST" modelAttribute="registrarPesoDiarioDTO">
							<form:select path="idPaciente">
							
							<c:forEach items="${listaPacientes}" var = "i">
								<form:option value="${i.id}">${i.nombre}</form:option>
							</c:forEach>]
								
							</form:select>
							<br>
							<form:label path="peso">Peso</form:label>
							<form:input path="peso" id="peso" type="number" class="form-control" required="required" placeholder="Exprese su peso en kilogramos" /> 
							<br>
							<button class="btn btn-lg btn-primary btn-block" Type="Submit">Confirmar</button>
						
						</form:form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>

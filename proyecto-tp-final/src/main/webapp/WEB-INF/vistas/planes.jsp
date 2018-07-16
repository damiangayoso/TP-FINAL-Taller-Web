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
                    <c:if test="${ROL=='medico'}" >
                    	<li><a class="btn" href="registrarusuario">Registrar Paciente</a></li>  
                    	<li><a class="btn" href="registrarPesoDiario">Registrar Peso Diario</a></li>
                   		<li><a class="btn" href="progresoSeleccionarPaciente">Ver Progreso</a></li>
                   	</c:if>
                    <c:if test="${ROL!='medico'}" >
                    	<li><a class="btn" href="verplan">Ver Plan</a></li>
                    	<li><a class="btn" href="registrarConsumoAlimento">Registrar Comida</a></li>
                    </c:if>
                </ul>
            </nav>
		</header>
		
		<div class = "main container">
		
		<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<!-- Stepper -->
			<div class="steps-form-2">
			    <div class="steps-row-2 setup-panel-2 d-flex justify-content-between">
			        <div class="steps-step-2">
			            <label class="btn-circle-2" data-toggle="tooltip" data-placement="top"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></label><br>PACIENTE
			        </div>
			        <div class="steps-step-2">
			            <label class="btn-circle-2" data-toggle="tooltip" data-placement="top"><i class="glyphicon glyphicon-check" aria-hidden="true"></i></label><br>EXCLUSIONES
			        </div>
			        <div class="steps-step-2">
			            <label class="btn-circle-2-selected" data-toggle="tooltip" data-placement="top"><i class="glyphicon glyphicon-cutlery" aria-hidden="true"></i></label><br>PLANES
			        </div>
			        <div class="steps-step-2">
			            <label class="btn-circle-2" data-toggle="tooltip" data-placement="top"><i class="glyphicon glyphicon-sort-by-attributes-alt" aria-hidden="true"></i></label><br>TU PLAN
			        </div>
			    </div>
			</div>
			
			<h3>Estos son los planes sugeridos: </h3>
			<p>Peso Actual:${pacienteDTO.paciente.peso} Peso ideal: ${pacienteDTO.pesoIdeal}</p>
			
			<c:if test="${pacienteDTO.excluirCarne}" >
				<span>Sin carnes</span>
			</c:if>
			<c:if test="${pacienteDTO.excluirLacteos}" >
				<span>Sin l�cteos</span>
			</c:if>
			<c:if test="${pacienteDTO.aptoHipertenso}" >
				<span>Apto Hipertensi�n</span>
			</c:if>
			<c:if test="${pacienteDTO.aptoCeliaco}" >
				<span>Apto celiaqu�a</span>
			</c:if>
			<c:if test="${pacienteDTO.intensidad}" >
				<span>${pacienteDTO.intensidad}</span>
			</c:if>
			<span></span>
			<br><br>

			<form:form action="final" method="POST" modelAttribute="pacienteDTO">
			
			  
				<c:forEach items="${planesSugeridos}" var = "item" >
					<form:radiobutton path="plan.id" value="${item.id}" required="required"/> ${item.nombre} - ${item.caloriasDiarias} calor�as diarias <br>
				</c:forEach>
			
				<%--Plan Recomendado:</b>
				
				<form:radiobutton path="plan.id" value="${planSugerido.id}" checked="checked"/> ${planSugerido.nombre} - ${planSugerido.caloriasDiarias} calor�as diarias <br>
				  
				${planSugerido.nombre} - ${planSugerido.caloriasDiarias} calor�as diarias <br>
				
				<br> --%>
				
				<form:input type="hidden" path="paciente.nombre" value="${paciente.nombre}"/>
				<form:input type="hidden" path="paciente.peso" value="${paciente.peso}"/>
				<form:input type="hidden" path="paciente.altura" value="${paciente.altura}"/>
				<form:input type="hidden" path="paciente.sexo" value="${paciente.sexo}"/>
				<form:input type="hidden" path="paciente.edad" value="${paciente.edad}"/>
				<form:input type="hidden" path="paciente.ejercicio" value="${paciente.ejercicio}"/>
				
				<br><br>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit">Ver Plan</button>
	  	    </form:form>
	  	    
	  	    </div>
	  	   </div>
		
		<jsp:include page="footer.jsp"></jsp:include>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>

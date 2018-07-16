<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="css/estilos.css">
	    <script src="<c:url value="js/Chart.min.js" />"></script>
	</head>
	
	<body>
		
		<header class="header container">
			<h1 class="logo">Control Nutricional</h1>
            <nav>
                 <ul class="container">
                    <li><a class="btn" href="home">Inicio</a></li>
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
		<form:form action="finalizarRegistro" method="POST" modelAttribute="pacienteDTO">
			
			<div id="stepperbox"  class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2" style="margin-top:50px;">
			<!--<div id="stepperbox"  class="mainbox" style="margin-top:50px;">-->
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
				            <label class="btn-circle-2" data-toggle="tooltip" data-placement="top"><i class="glyphicon glyphicon-cutlery" aria-hidden="true"></i></label><br>PLANES
				        </div>
				        <div class="steps-step-2">
				            <label class="btn-circle-2-selected" data-toggle="tooltip" data-placement="top"><i class="glyphicon glyphicon-sort-by-attributes-alt" aria-hidden="true"></i></label><br>TU PLAN
				        </div>
				    </div>
				</div>
			</div>
				
			<div id="plan"  class="mainbox col-md-8 col-sm-1 col-sm-offset-2">	
			<!--<div id="loginbox"  class="mainbox">-->
			
				
				<div id="table" class="mainbox col-md-12">
					
					<h2>Plan escogido: ${pacienteDTO.plan.nombre}</h2>
					<h4>Intensidad: ${pacienteDTO.plan.intensidad } ${pacienteDTO.plan.caloriasDiarias } Kcal. diarias</h4> 
		
			        <table id="acrylic">
			            <thead>
			                <tr>
			                    <th>Comida</th>
			                    <th>Alimentos</th>      
			                </tr>
			            </thead>
			            <tbody>
			                <tr>
			                    <td>Desayuno</td>
			                    <td>${pacienteDTO.plan.desayuno }</td>
			                </tr>
			                <tr>
			                    <td>Media ma�ana</td>
			                    <td>${pacienteDTO.plan.colacion1}</td>
			                </tr>
			                <tr>
			                    <td>Almuerzo</td>
			                    <td>${pacienteDTO.plan.almuerzo}</td>
			                </tr>
			                <tr>
			                    <td>Merienda</td>
			                    <td>${pacienteDTO.plan.merienda}</td>
			                </tr>
			                <tr>
			                    <td>Media tarde</td>
			                    <td>${pacienteDTO.plan.colacion2}</td>
			                </tr>
			                <tr>
			                    <td>Cena</td>
			                    <td>${pacienteDTO.plan.cena}</td>
			                </tr>
			            </tbody>
			        </table>
				</div>
				</div>
<br>
				
	
				<div id="grafico"  class="mainbox col-md-8 col-sm-1 col-sm-offset-2">	
				<!--  <div class="mainbox">-->
				<br>
					<h2 class="center">Tiempo estimado en cumplir objetivo</h2>
					<c:set var="pesoPGPorMes" value="${(caloriasPGPorDia*4)/1000}" />
					<c:set var="contador" value="${peso}" />  
					<div class="chartjs-wrapper">
							<canvas id="chartjs-0" class="chartjs" width="undefined" height="undefined"></canvas>
							<script>new Chart(document.getElementById("chartjs-0"),{"type":"line","data":
							{"labels":["",<c:forEach var = "i" begin = "0" end = "${diasObjetivo / 30}">
				        					 "Mes ${i + 1}",
						      				</c:forEach>],
						      		"datasets":
								[{"label":"Peso","data":[
										<c:set var="pesoPGPorMes" value="${(caloriasPGPorDia*4)/1000}" />
										<c:set var="contador" value="${peso}" />   
										<c:forEach var = "i" begin = "0" end = "${(diasObjetivo / 30)+1}">	        	 
										${contador}, 
										<c:if test="${peso < pesoIdeal}">
										<c:set var="contador" value="${contador + pesoPGPorMes}" /> 
										</c:if>
										
										<c:if test="${peso > pesoIdeal}">
										<c:set var="contador" value="${contador - pesoPGPorMes}" /> 
										</c:if> 
										
										</c:forEach>
									${pesoIdeal}],"fill":
									false,"borderColor":"rgb(75, 192, 192)","lineTension":
										0.1}]},"options":{}});
							</script>
					</div>
				</div>
				
				<div class="row">
				<div   class="mainbox col-md-3 col-sm-1 col-sm-offset-3">	
				<!--  <div class="mainbox">-->
					<br>
					<h2>Datos del Paciente</h2>
					<br>
					<span>Peso inicial del Paciente: ${peso} Kg.</span>
					<br>
					<span>TMB: ${tmb} Calorias.</span><span class="badge badge-secondary" data-toggle="tooltip" data-placement="top" title="La tasa metab�lica basal (TMB) es el c�lculo de las calor�as m�nimas que precisa una persona para realizar sus funciones org�nicas cada d�a.">
					?
					</span>
					<br>
					<span>Peso Objetivo: ${pesoIdeal} Kg.</span>
					<br>
					<c:if test="${peso > pesoIdeal}">
					<span>Peso a Perder: ${pesoAPerderOGanar} Kg.</span>
					<br>
					</c:if>
					<c:if test="${peso < pesoIdeal}">
					<span>Peso a Ganar: ${pesoAPerderOGanar} Kg.</span>
					<br>
					</c:if>
					<c:if test="${tmb > pacienteDTO.plan.caloriasDiarias}">
					<span>Calor�as perdidas por d�a: ${caloriasPGPorDia} Calorias.</span>
					<br>
					</c:if>
					<c:if test="${tmb < pacienteDTO.plan.caloriasDiarias}">
					<span>Calor�as Ganadas por d�a: ${caloriasPGPorDia} Calorias.</span>
					<br>
					</c:if>
					<span>D�as objetivo: ${diasObjetivo} Dias</span>
				</div>
				
				
				
				<form:input type="hidden" path="paciente.peso" value="${paciente.peso}"/>
				<form:input type="hidden" path="paciente.altura" value="${paciente.altura}"/>
				<form:input type="hidden" path="paciente.sexo" value="${paciente.sexo}"/>
				<form:input type="hidden" path="paciente.edad" value="${paciente.edad}"/>
				<form:input type="hidden" path="paciente.ejercicio" value="${paciente.ejercicio}"/>
				<form:input type="hidden" path="plan.id" value="${pacienteDTO.plan.id}"/>
				
			<div   class="mainbox col-md-4 col-sm-1 col-sm-offset-1" style="margin-top:8em;">
				<button class="btn btn-lg btn-primary " Type="Submit">Confirmar Registro</button>
			</div>
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			
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
			<span></span>
			<br>
			<br>
			<span>Estos son los planes sugeridos: </span>
			<br>
			<form:form action="final" method="POST" modelAttribute="pacienteDTO">
				<c:forEach items="${planesSugeridos}" var = "item" >
					<form:radiobutton path="plan.id" value="${item.id}"/> ${item.nombre} - ${item.caloriasDiarias} calor�as diarias <br>
				</c:forEach>
				
					
				<form:input type="hidden" path="paciente.peso" value="${paciente.peso}"/>
				<form:input type="hidden" path="paciente.altura" value="${paciente.altura}"/>
				<form:input type="hidden" path="paciente.sexo" value="${paciente.sexo}"/>
				<form:input type="hidden" path="paciente.edad" value="${paciente.edad}"/>
				<form:input type="hidden" path="paciente.ejercicio" value="${paciente.ejercicio}"/>
				
				<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Siguiente</button>
	  	    </form:form>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
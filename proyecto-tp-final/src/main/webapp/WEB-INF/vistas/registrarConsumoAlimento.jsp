<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                    <li><a class="btn" href="home">Inicio</a></li>
                    <c:if test="${ROL!='medico'}" >
                    	<li><a class="btn" href="verplan">Ver Plan</a></li>
                   		<li><a class="btn active white"  href="registrarConsumoAlimento">Registrar Comida</a></li>
                     </c:if>
                </ul>
            </nav>
            
		</header>
	
		<div class = "main container">	
		
			<div id="" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			
			<h3 class="">Registrar Comida</h3>
			<form:form action="ConsumoAlimento" method="POST" modelAttribute="alimento">
				<lavel for="comida">Comida</lavel>
				<form:select id="comida" path="id" class="form-control">
						<form:options itemValue="id" itemLabel="nombre" items="${listadoAlimentos}"></form:options>
				</form:select>
				<lavel for="bebida">Bebida</lavel>
				<form:select id="bebida" path="id" class="form-control">
						<form:options itemValue="id" itemLabel="nombre" items="${listadoBebidas}"></form:options>
				</form:select>
				<br>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit">Calcular Calorias</button>
			
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!-- para funções -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Eleições 2014</title>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/votacao.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/font-awesome-4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top top-nav-collapse"
		role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-main-collapse">
				<i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="#page-top"> <i
				class="fa fa-play-circle"></i> <span class="light">Simulação</span>
				ELEIÇÕES - <span style="color: #FFC400">2</span> <span
				style="color: #04D800">0</span> <span style="color: #004BB5">1</span>
				<span style="color: #FFFFFF">4</span> - PB
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div
			class="collapse navbar-collapse navbar-right navbar-main-collapse">
			<ul class="nav navbar-nav">
				<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
				<li class="hidden active"><a href="#page-top"></a></li>
				<li><a class="page-scroll"
					href="${pageContext.request.contextPath}/index.html">Home</a></li>
				<!-- 				<li><a class="page-scroll" href="#contact">Contato</a></li> -->
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Intro Header -->

	<header class="intro">
	<div class="intro-body">
		<div class="row" align="center">
			<div class="col-md-8 col-md-offset-2">
				<br>
				<h1 style="color: black;">Candidatos a Governador</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-6 col-sm-4 col-lg-4">
				<h2 style="color: black;">Cássio Cunha Lima</h2>
				<div class="thumb espaca">
					<span class="btn_confirma"> </span> <img
						src="${pageContext.request.contextPath}/img/candidatos/cassio-peq.png"
						alt="Cássio - PSDB" title="Cássio - PSDB">
				</div>
				<p style="color: black;">
					<strong>VOTOS: ${votosCassio}</strong>
				</p>
			</div>
			<div class="col-6 col-sm-4 col-lg-4">
				<h2 style="color: black;">Ricardo Coutinho</h2>
				<div class="thumb espaca">
					<span class="btn_confirma"> </span> <img
						src="${pageContext.request.contextPath}/img/candidatos/ricardo-peq.png"
						alt="Ricardo Coutinho - PSB" title="Ricardo Coutinho - PSB">
				</div>
				<p style="color: black;">
					<strong>VOTOS: ${votosRicardo}</strong>
				</p>
			</div>
			<div class="col-6 col-sm-4 col-lg-4">
				<h2 style="color: black;">Nulo ou Branco</h2>
				<div class="thumb espaca">
					<span class="btn_confirma"> </span> <img
						src="${pageContext.request.contextPath}/img/candidatos/indeciso-peq.png"
						alt="Não sei" title="Não sei">
				</div>
				<p style="color: black;">
					<strong>VOTOS: ${votosNuloGov}</strong>
				</p>
			</div>
		</div>
		<a href="#about" class="btn btn2-circle page-scroll"> <i
		class="fa fa-angle-double-down animated"></i>
	</a>
	</div>
	</header>
	
	<section id="about" class="container content-section text-center">
	<div class="row" align="center">
		<div class="col-md-8 col-md-offset-2">
			<br>
			<h1 style="color: white;">Candidatos a Presidente</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-6 col-sm-4 col-lg-4">
			<h2>Aécio Neves</h2>
			<div class="thumb espaca">
				<span class="btn_confirma"> </span> <img
					src="${pageContext.request.contextPath}/img/candidatos/aecio.png"
					alt="Aécio Neves - PSDB" title="Aécio Neves - PSDB">
			</div>
			<p>
				<strong>VOTOS: ${votosAecio}</strong>
			</p>

		</div>
		<div class="col-6 col-sm-4 col-lg-4">
			<h2>Dilma Roussef</h2>
			<div class="thumb espaca">
				<span class="btn_confirma"> </span> <img
					src="${pageContext.request.contextPath}/img/candidatos/dilma.png"
					alt="Dilma Roussef - PT" title="Dilma Roussef - PT">
			</div>
			<p>
				<strong>VOTOS: ${votosDilma}</strong>
			</p>
		</div>
		<div class="col-6 col-sm-4 col-lg-4">
				<h2 >Nulo ou Branco</h2>
				<div class="thumb espaca">
					<span class="btn_confirma"> </span> <img
						src="${pageContext.request.contextPath}/img/candidatos/indeciso-peq.png"
						alt="Não sei" title="Não sei">
				</div>
				<p>
					<strong>VOTOS: ${votosNuloPres}</strong>
				</p>
			</div>
	</div>

	</section>


	<!-- Footer -->
	<footer>
	<div class="container text-center">
		<!--             <p>Copyright &copy; Geraldo Valencia, 2014</p> -->
	</div>
	</footer>

	<!-- jQuery Version 1.11.0 -->
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/js/jquery.easing.min.js"></script>
	<!-- Plugin Votacao -->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>

	<!--     Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
	<script type="text/javascript"
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/js/grayscale.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Eleições 2014</title>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<link href="../css/main.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/votacao.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../font-awesome-4.1.0/css/font-awesome.min.css"
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
	<nav class="navbar navbar-custom navbar-fixed-top top-nav-collapse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
				<i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="#page-top"> <i class="fa fa-play-circle"></i> <span class="light">Simulação</span>
				ELEIÇÕES - <span style="color: #FFC400">2</span> <span style="color: #04D800">0</span> <span style="color: #004BB5">1</span>
				<span style="color: #FFFFFF">4</span> - PB
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-right navbar-main-collapse">
			<ul class="nav navbar-nav">
				<!-- Hidden li included to remove active class from about link when scrolled up past about section -->
				<li class="hidden active"><a href="#page-top"></a></li>
				<li><a class="page-scroll" href="../index.html">Home</a></li>
				<li><a class="page-scroll" href="#download">Resultados</a></li>
<!-- 				<li><a class="page-scroll" href="#contact">Contato</a></li> -->
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Intro Header -->
	<header class="intro">
	<div class="intro-body">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<br>
					<h1 style="color: black;">Vote Abaixo.</h1>
						<a href="#about" class="btn btn2-circle page-scroll">
                            <i class="fa fa-angle-double-down animated"></i>
                        </a>
				</div>
			</div>
		</div>
	</div>
	</header>
			
	<section id="about" class="container content-section text-center">
	<div class="row" align="center">
				<div class="col-md-8 col-md-offset-2">
					<br>
					<h1 style="color: white;">Candidatos a Presidente</h1>
				</div>
			</div>
		<div class="linhas espaca" style="margin-left: 3%; ">
		<article class="candidatos" data-candidato="1" data-identificacao="aecio-neves">
		<div class="header">
			<span>Aécio Neves</span> <br> <a href="http://www.psdb.org.br/" target="_blanck"> <em>PSDB</em>
			</a>
		</div>
		<div class="thumb espaca">
			<span class="btn_confirma"><img src="../img/candidatos/botao_confirma.png"></span>
			<img src="../img/candidatos/candidato1.png" alt="Aécio Neves - PSDB" title="Aécio Neves - PSDB"> 
		</div>
		<div class="percent"></div>
		</article>
		<article class="candidatos" data-candidato="3" data-identificacao="dilma-roussef">
		<div class="header">
			<span>Dilma Roussef</span> <br> <a href="http://www.pt.org.br/" target="_blanck"> <em>PT</em>
			</a>
		</div>
		<div class="thumb espaca">
			<span class="btn_confirma"><img src="../img/candidatos/botao_confirma.png"></span>
			<img src="../img/candidatos/candidato3.png" alt="Dilma Roussef - PT" title="Dilma Roussef - PT"> 
		</div>
		<div class="percent"></div>
		</article>
		<article class="candidatos" data-candidato="4" data-identificacao="marina-silva">
		<div class="header">
			<span>Marina Silva</span> <br> <a href="http://www.psb40.org.br/" target="_blanck"> <em>PSB</em>
			</a>
		</div>
		<div class="thumb espaca">
			<span class="btn_confirma"><img src="../img/candidatos/botao_confirma.png"></span>
			<img src="../img/candidatos/candidato4.png" alt="Marina Silva - PSB" title="Marina Silva - PSB"> 
		</div>
		<div class="percent"></div>
		</article>
		<article class="candidatos" data-candidato="5" data-identificacao="everaldo-pereira">
		<div class="header">
			<span>Pr. Everaldo Pereira</span> <br> <a href="http://www.psc.org.br/" target="_blanck"> <em>PSC</em>
			</a>
		</div>
		<div class="thumb espaca">
			<span class="btn_confirma"><img src="../img/candidatos/botao_confirma.png"></span>
			<img src="../img/candidatos/candidato5.png" alt="Pr. Everaldo Pereira - PSC" title="Pr. Everaldo Pereira - PSC">
			
		</div>
		<div class="percent"></div>
		</article>
  <article class="candidatos" data-candidato="6" data-identificacao="nao_sei">
		<div class="header">
			<span>Não sei</span> <br> <em>Sem Partido</em>
		</div>
		<div class="thumb espaca">
			<span class="btn_confirma"><img src="../img/candidatos/botao_confirma.png"></span>
			<img src="../img/candidatos/candidato12.png" alt="Não sei - Não sei" title="Não sei - Não sei"> 
		</div>
		</article>
		</div>
	</section>

    <!-- Footer -->
    <footer>
        <div class="container text-center">
<!--             <p>Copyright &copy; Geraldo Valencia, 2014</p> -->
        </div>
    </footer>

    <!-- jQuery Version 1.11.0 -->
    <script src="../js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="../js/jquery.easing.min.js"></script>
    <!-- Plugin Votacao -->
    <script src="../js/main.js"></script>

<!--     Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/grayscale.js"></script>

</body>
</html>
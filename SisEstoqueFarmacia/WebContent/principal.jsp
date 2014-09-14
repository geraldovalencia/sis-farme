<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!-- para funções -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>

<title>PÁGINA PRINCIPAL SIS ESTOQUE FARMÁCIA</title>
<%@ include file="/linksReferencias.html"%>
</head>
<body style="font-family: sans-serif" background="images/bg.jpg">

	<div id="titulo-costa" align="center">
		<button style="float: right; margin-left: -20%;" class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-sm">Sair</button>
		<!-- <img src="imagens/SisFarme.JPG" style="float: center;" height="80%" /> -->
		<img src="imagens/SisFarme.JPG" style="float: center;" height="80%" />
		
		<div id='usuarioLogado'>
			<strong>Bem vindo:</strong> ${fn:toUpperCase(usuarioLogado.nome)} <strong>
				| Tipo de Usuário:</strong> ${fn:toUpperCase(usuarioLogado.tipo)} | <strong>Data:</strong>  ${dataAtual}
		</div>	
	</div>

	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid" align="center">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<!-- Verifica os tipos de usuário e carrega os menus de acordo com o tipo -->



			<!-- -------------------------------CARREGA O MENU PARA O TIPO DE USUARIO ADMIN --------------------------- -->

			<c:if test="${usuarioLogado.tipo == 'ADMINISTRADOR'}">
				<%@ include file="/pags/menus/menuAdm.html"%>
			</c:if>

			<!-- -------------------------------CARREGA O MENU PARA O TIPO DE USUARIO FARMACEUTICO --------------------------- -->

			<c:if test="${usuarioLogado.tipo =='FARMACEUTICO'}">
				<%@ include file="/pags/menus/menuFarmaceutico.html"%>
			</c:if>

			<!-- -------------------------------CARREGA O MENU PARA O TIPO DE USUARIO GERENTE --------------------------- -->

			<c:if test="${usuarioLogado.tipo =='GERENTE'}">
				<%@ include file="/pags/menus/menuGerente.html"%>
			</c:if>


			<!-- -------------------------------CARREGA O MENU PARA O TIPO DE USUARIO VENDEDOR --------------------------- -->

			<c:if test="${usuarioLogado.tipo =='VENDEDOR'}">
				<%@ include file="/pags/menus/menuVendedor.html"%>
			</c:if>
		</div>
	</div>
</nav>

	<blockquote class="blockquote-reverse">
		<p style="margin-top:-1%;">
			<strong>SISFARME</strong> - Sistema de Gerenciamento de Estoque de
			Farmácia
		</p>
		<footer>Desenvolvido por: <cite><strong>Geraldo
				Valencia</strong></cite></footer>
	</blockquote>

	<div align='center'>
		<strong>${message}</strong>
		<c:remove var="message" scope="session" />
	</div>
	<div style=" margin-bottom: -3%;"></div>
	<div>${apagarClienteSessao}</div>
	<c:if test="${apagarClienteSessao != null}">
		<c:remove var="cliente" scope="session" />
		<c:remove var="fornecedor" scope="session" />
	</c:if>


<div><%@ include file="modais/modal.html"%></div><!-- Não remover div, pois dará problema nas telas. ESSE é o SAIR-->
   
</body>
</html>
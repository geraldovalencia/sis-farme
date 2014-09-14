<%@ include file="/../../principal.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- para estruturas de controle e repetição e setar variáveis -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- para formatações -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><!-- para funções -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>RELATÓRIO SNGPC - SIS ESTOQUE FARMÁCIA</title>
<style>
.CSSTableGenerator {
	width: 80%;
}

#login {
	width: 60%;
	position: 0px;;
}

#wrapper input:not ([type="checkbox"] ) {
	width: 50%;
}

#wrapper p.button input {
	width: auto;
}
</style>
</head>
<body>

	<br>
	<br>
	<div id="wrapper" align="center">
		<div id="login" align="center">
			<h1>Gerar Relatório SNGPC</h1>

			<div id='usuarioLogado' align="left">
				<h4>
					<br>
					<strong>USUARIO:</strong> ${fn:toUpperCase(usuarioLogado.nome)}<br>
					<br> <br>
					<strong>CPF:</strong> ${fn:toUpperCase(usuarioLogado.cpf)}<br>
					<br> <br>
					<strong>CRF:</strong> ${fn:toUpperCase(usuarioLogado.crf)}<br>
					<br>
				</h4>
			</div>

			<!-- EmitirRelatorioSngpcServlet.du -->
			<c:if test="${usuarioLogado.tipo =='FARMACEUTICO'}">
				<form action="GerarXMLSngpcServlet.du">
				<div align="left">
					<table cellpadding="1" cellspacing="0">
						<tbody>
							<tr>
								<td align="left"><h4>
										<strong>CNPJ Emissor</strong>
									</h4></td>
								<td align="left"><h4>
										<strong>DATA INICIO</strong>
									</h4></td>
									
							</tr>
							<tr class="active">
								<td><input type="text" value="88.998.899/0001-01" class="form-control"/></td>
								<td> <input type="date"	 class="form-control" placeholder="DD/MM/AA" name="dataInicio" required="true"></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
					<div align="center">
						<br><br><input type="submit" class="btn btn-danger"
							value="Gerar XML">
					</div>
					<br> 
				</form>
				</div>
			</c:if>

			<!-- 	
           	CPF	<select name='cliente'>
						<option value=''> -- Selecione -- </option>
						<c:forEach var="cliente" items="${fisicas}">
						<option value='${cliente.id}'> ${cliente.nome} </option>}
						</c:forEach>
					</select>
			CNPJ	<select name='cliente'>
						<option value=''> -- Selecione -- </option>
						<c:forEach var="cliente" items="${fisicas}">
						<option value='${cliente.id}'> ${cliente.nome} </option>}
						</c:forEach>
					</select><br>
				Mes	<select name='cliente'>
						<option value=''> -- Selecione -- </option>
						<c:forEach var="cliente" items="${fisicas}">
						<option value='${cliente.id}'> ${cliente.nome} </option>}
						</c:forEach>
					</select>
			ANO		<select name='cliente'>
						<option value=''> -- Selecione -- </option>
						<c:forEach var="cliente" items="${fisicas}">
						<option value='${cliente.id}'> ${cliente.nome} </option>}
						</c:forEach>
					</select><br>
         			  Registro Farmaceutico	<input><br>
    <br>
           	
           	<input type="submit" value="Gerar">	
           	</div>
        </div>
 -->












			<!--  	
           CPF	<select name='cliente'>
						<option value=''> -- Selecione -- </option>
						<c:forEach var="cliente" items="${fisicas}">
						<option value='${cliente.id}'> ${cliente.nome} </option>}
						</c:forEach>
					</select>
			CNPJ	<select name='cliente'>
						<option value=''> -- Selecione -- </option>
						<c:forEach var="cliente" items="${fisicas}">
						<option value='${cliente.id}'> ${cliente.nome} </option>}
						</c:forEach>
					</select><br>
				Mes	<select name='cliente'>
						<option value=''> -- Selecione -- </option>
						<c:forEach var="cliente" items="${fisicas}">
						<option value='${cliente.id}'> ${cliente.nome} </option>}
						</c:forEach>
					</select>
			ANO		<select name='cliente'>
						<option value=''> -- Selecione -- </option>
						<c:forEach var="cliente" items="${fisicas}">
						<option value='${cliente.id}'> ${cliente.nome} </option>}
						</c:forEach>
					</select><br>
           Registro Farmaceutico	<input><br>
    <br>
           	
           	<input type="submit" value="Gerar">	
           	</div>
        </div>
 -->
</body>
</html>
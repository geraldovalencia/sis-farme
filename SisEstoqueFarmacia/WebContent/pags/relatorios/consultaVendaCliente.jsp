<%@ include file="/../../principal.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CONSULTA VENDAS-CLIENTE - SIS ESTOQUE FARMÁCIA</title>
</head>
<body>
	<br>
	<br>
	<div id="wrapper">
		<div id="login" >
			<h1>CONSULTA DE VENDAS POR CLIENTE</h1>
				
			<table class="table tabelaCentro">
				<th cellspacing='2'>CÓDIGO</th>
				<th cellpadding='3'>DATA</th>
				<th cellpadding='3'>USUARIO RESP.</th>
				<th cellpadding='3'>TIPO USUARIO</th>
				<th cellpadding='3'>CLIENTE</th>
				<th cellpadding='3'>TOTAL</th>
		<c:choose>
			<c:when test="${vendasRelatorio != null}">
				<c:forEach var="vendasRelatorio" items="${vendasRelatorio}">
					<tr>
						<td align='center'>${vendasRelatorio.id}</td>

					<td align='center'><fmt:formatDate value="${vendasRelatorio.data}" type="both"   
									pattern="dd/MM/yyyy" /></td>
						
						<td align='center'>${vendasRelatorio.usuario.nome}</td>

						<td align='center'>${vendasRelatorio.usuario.tipo}</td>
						<td align='center'>${vendasRelatorio.pf.nome}</td>
			<c:set var="calculoPreco" value="${calculoPreco + vendasRelatorio.total}" />
						<td align='center'>R$ ${vendasRelatorio.total}</td>
					</tr>
				</c:forEach>
				<tr style="clear:both; font-size:240%; width: 120px; height:80px; background-color:#006666; color: #FFFFFF;!important;">
				<td colspan="6" align="center"><strong>TOTAL DE VENDAS PARA ESTE CLIENTE: R$  <fmt:formatNumber value="${calculoPreco}" pattern="#,#00.00#"/></strong></td>
				</tr>
				
			</c:when>
			<c:otherwise>
				<tr>	
						<td colspan="6" align='center'><br> <strong>---------- NENHUM RESULTADO PARA ESTE CLIENTE ----------</strong>  </td>
					</tr>
				<tr style="clear:both; font-size:240%; width: 120px; height:80px; background-color:#006666; color: #FFFFFF;!important;">
				<td colspan="6" align="center"><strong>TOTAL DE VENDAS PARA ESTE CLIENTE: R$ 00,00</strong></td>
				</tr>
			</c:otherwise>
			
		</c:choose>	
			</table>
			<br>
			<c:if test="${not empty qtdePages}">
			<div align="center">
				<ul class="pagination">
					<c:if test="${not empty param.pag}">				
						<li><a href="RelatorioCompraClienteServlet.du?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="RelatorioCompraClienteServlet.du?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="RelatorioCompraClienteServlet.du?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>
		</div>
	</div>
</body>
</html>
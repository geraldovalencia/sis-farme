<%@ include file="/../../principal.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	$(document).on(
			'click',
			'.open-RemoverModal',
			function() {
				var propValue = $(this).data('id');
				var propMsg = $(this).data('msg');
				$('#removerModalPropValue').val(propValue);
				$('#removerModalMessage').text(
						'Deseja realmente remover o Produto \"' + propMsg + '\"?');
			});

	$(document).on('click', '#removerModalConfirma', function() {
		$("#removerForm").submit();
	});
</script>
<title>LISTAR VENDAS - SIS ESTOQUE FARMÁCIA</title>
</head>
<body>
	<br>
	<br>
	<div id="wrapper">
		<div id="login" >
			<h1>LISTAR VENDAS</h1>
				
			<table class="table tabelaCentro">
				<th cellspacing='2'>CÓDIGO</th>
				<th cellpadding='3'>DATA</th>
				<th cellpadding='3'>USUARIO RESP.</th>
				<th cellpadding='3'>TIPO USUARIO</th>
				<th cellpadding='3'>CLIENTE</th>
				<th cellpadding='3'>TOTAL</th>

				<c:forEach var="vendasListagem" items="${vendasListagem}">

					<tr>
						<td align='center'>${vendasListagem.id}</td>

						<td align='center'><fmt:formatDate value="${vendasListagem.data}" type="both"   
									pattern="dd/MM/yyyy" /></td>

						<td align='center'>${vendasListagem.usuario.nome}</td>

						<td align='center'>${vendasListagem.usuario.tipo}</td>
						<td align='center'>${vendasListagem.pf.nome}</td>
			<c:set var="calculoPreco" value="${calculoPreco + vendasListagem.total}" />
						<td align='center'>R$ ${vendasListagem.total}</td>

					</tr>
				</c:forEach>
				<tr style="clear:both; font-size:300%; width: 120px; height:80px; background-color:#006666; color: #FFFFFF;!important;">
				<td colspan="6" align="center"><strong>TOTAL EM VENDAS: R$  <fmt:formatNumber value="${totalDeVenda}" pattern="#,#00.00#"/></strong></td>
				</tr>
			</table>
			<c:if test="${not empty qtdePages}">
			<div align="center">
				<ul class="pagination">
					<c:if test="${not empty param.pag}">				
						<li><a href="ListarVendasServet.du?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="ListarVendasServet.du?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="ListarVendasServet.du?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>
		</div>
	</div>
</body>
</html>
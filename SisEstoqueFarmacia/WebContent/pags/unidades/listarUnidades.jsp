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
<title>LISTAGEM DE UNIDADES - SIS ESTOQUE FARMÁCIA</title>
<style>
#wrapper {
	width: 50%;
}
</style>
</head>
<body>
	<br>
	<br>
	<div id="wrapper">
		<div id="login" align="center">
			<h1>LISTAR UNIDADES</h1>

			<form method='post' action='/SisEstoqueFarmacia/ListarUnidadeServlet.du'>
				<div class="form-group" align="center">
					<label for="username" class="col-sm-2 control-label">BUSCAR
						UNIDADE</label>
					<div class="col-sm-10" style="width: 60%">
						<input type='text' name='filtro' id="unidadeId" class="form-control"
							 />
					</div>
				</div>
				<div align="left">
					<input type='submit' class="btn btn-danger" value='Pesquisar'>
					</p>
				</div>
			</form>
			<br />
			<%//Todo link é get. Então no servlet é mister que se use o DoGet%>
			
			<div class="table-responsive">
			<table class="table tabelaCentro">
				<tr>
					<th cellpadding='5' width="15%">CÓDIGO</th>
					<th cellpadding='5'>UNIDADE</th>
					<th cellpadding='5' width="30%">AÇÕES</th>
				</tr>

				<c:forEach var="unidade" items="${unidades}">
					<tr>
						<td align='center'>${unidade.id}</td>
						<td align='center'>${unidade.nome}</td>
						<td align="center"><a style="margin-right: 6px;"
							href='/SisEstoqueFarmacia/EditarUnidadeServlet.du?idUnidade=${unidade.id}'>
							<img src="imagens/editar.png" alt="EDITAR" title="EDITAR" style="float: center; width: 20px;" /></a>
							
							<a href="#" class="open-RemoverModal" data-id="${unidade.id}" data-msg="${unidade.nome}" data-toggle="modal" data-target="#removerModal"><!-- data-msg é uma variavel criada lano Principal.jsp dentro do Javascrit do include -->
							<img src="imagens/excluir.png" alt="REMOVER" title="REMOVER" style="float: center; width:20px;" /></a>
						</td>


					</tr>
				</c:forEach>

			</table>
			</div>
			<c:if test="${not empty qtdePages}">
			<div align="center">
				<ul class="pagination">
					<c:if test="${not empty param.pag}">				
						<li><a href="ListarUnidadeServlet.du?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="ListarUnidadeServlet.du?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="ListarUnidadeServlet.du?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>
		</div>
	</div>
	
	<div><%@ include file="removerModalUnidade.html"%></div>
</body>
</html>
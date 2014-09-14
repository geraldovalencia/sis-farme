
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
<title>LISTAGEM DE PRODUTOS - SIS ESTOQUE FARMÁCIA</title>
<style>
#wrapper {
	width: 82%;
}

</style>
</head>
<body>
	<br>
	<br>
	<div id="wrapper">
		<div id="login" align="center">
			<h1>LISTAR PRODUTOS</h1>

			<form action='ListarProdutoServlet.du' method='post'>

				<div class="form-group">
					<label class="col-sm-2 control-label"> BUSCAR PRODUTO</label>
					<div class="col-sm-10" style="width: 60%">
						<input type="text" id="produto" name="nomeProduto"
							class="form-control">
					</div>
				</div>
				<p align="center">
					<input type='submit' class="btn btn-danger" value='Pesquisar'>
				</p>
			</form>
			<br>
			<table class='table tabelaCentro'>
				<th>CÓDIGO</th>
				<th>Nº LOTE</th>
				<th>REGISTRO MSM</th>
				<th>NOME</th>
				<th>MARCA</th>
				<th>QT_ESTOQUE</th>
				<th>CATEGORIA</th>
				<th>UNIDADE</th>
				<th>PREÇO</th>
				<th colspan='2'>Ações</th>


				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td align='center'>${produto.id}</td>
						<td align='center'>${produto.numeroLoteMedicamento}</td>
						<td align='center'>${produto.registroMSMedicamento}</td>
						<td align='center'>${fn:toUpperCase(produto.nome)}</td>
						<td align='center'>${fn:toUpperCase(produto.marca)}</td>
						<td align='center'><fmt:formatNumber type="number"
								value="${produto.qtde_estoque}" maxFractionDigits="0" /> Unids</td>
						<td align='center'>${produto.categoria.nome}</td>
						<td align='center'>${produto.unidade.nome}</td>
						<td align='center'>R$ ${produto.precovenda}</td>
						
						
						<td align="center"><a style="margin-right: 5px;"
							href='/SisEstoqueFarmacia/EditarProdutoServlet.du?idProduto=${produto.id}'>
								<img src="imagens/editar.png" alt="EDITAR" title="EDITAR"
								style="float: center; width: 20px;" />
								</a> 
								
								<a href="#" class="open-RemoverModal" data-id="${produto.id}" data-msg="${produto.nome}" data-toggle="modal" data-target="#removerModal">
								<!-- data-msg é uma variavel criada lano Principal.jsp dentro do Javascrit do include -->
								<img src="imagens/excluir.png" alt="REMOVER" title="REMOVER"
								style="float: center; width: 20px;" />
						</a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<c:if test="${not empty qtdePages}">
			<div class="pagination">
				<ul class="pagination">
					<c:if test="${not empty param.pag}">				
						<li><a href="ListarProdutoServlet.du?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="ListarProdutoServlet.du?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="ListarProdutoServlet.du?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>
		</div>
	</div>

	<div><%@ include file="removerModal.html"%></div>
	<!-- Não remover div, pois dará problema nas telas -->
</body>
</html>

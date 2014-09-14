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
					'Deseja realmente remover \"' + propMsg
							+ '\"?');
		});

$(document).on('click', '#removerModalConfirma', function() {
	$("#removerForm").submit();
});
</script>
<title>LISTAGEM DE CATEGORIAS - SIS ESTOQUE FARMÁCIA</title>
<style>
#wrapper {
	width: 50%;
}
</style>
</head>
<body data-spy="scroll" data-target="#divSessao">
<br><br>
		<div id="wrapper">
           <div id="login" align="center">
           <h1>LISTAR CATEGORIA TERAPÊUTICA</h1>
           		
		<form method='post' action='/SisEstoqueFarmacia/listarCategorias.du'>
			<div class="form-group" align="center" id="divSessao">
					<label for="username" class="col-sm-2 control-label">BUSCAR</label>
					<div class="col-sm-10" style="width: 60%"> 
						<input type='text' name='categoria' id="categoriaId" class="form-control" />
					</div>
			</div>
			<div align="left">
						<input type='submit' class="btn btn-danger" value='Pesquisar'>
					</p>
				</div>
		</form><br />
		
		
		<%//Todo link é get. Então no servlet é mister que se use o DoGet%>

		<table class="table tabelaCentro">
			<tr>
				<th cellpadding='5' width="15%">CÓDIGO</th>
				<th cellpadding='5'>CATEGORIA</th>
				<th cellpadding='5'>CONTROLADO</th>
				<th cellpadding='5' width="30%" >AÇÕES</th>
			</tr>
			
		<c:forEach var="categoria" items="${categorias}">		
			<tr >
			<td align='center' >
			${categoria.id}
			</td>
			
			
			<td align='center'>
			${categoria.nome}
			</td>
			
			

			<td align='center'>
				<c:choose>
					<c:when test="${categoria.controlado}"> <!-- le gt == > < not empty and or -->
						SIM
					</c:when>
					<c:otherwise>
						NÃO
					</c:otherwise>
				</c:choose>
			</td>
			
			<td align="center">
				<a style="margin-right:5px;" href="/SisEstoqueFarmacia/EditarCategoriaServlet.du?idCategoria=${categoria.id}">
				<img src="imagens/editar.png" alt="EDITAR" title="EDITAR" style="float: center; width: 20px;" /></a>
				
				
				<a href="#" class="open-RemoverModal" data-id="${categoria.id}" data-msg="${categoria.nome}" data-toggle="modal" data-target="#removerModal">
				<img src="imagens/excluir.png" alt="REMOVER" title="REMOVER" style="float: center; width:20px;" /></a>
				
				
				
				
				
<%-- 				<a href="/SisEstoqueFarmacia/removerCategoriaServlet.du?idCategoria=${categoria.id}"> --%>
<!-- 				<img class="CorrigirImagem" src="imagens/excluir.png" alt="REMOVER" title="REMOVER" style="float: center; width:20px;" /></a> -->
			</td>
			
			
			</tr>
		</c:forEach>
			
		</table>
		<c:if test="${not empty qtdePages}">
			<div align="center">
				<ul class="pagination">
					<c:if test="${not empty param.pag}">				
						<li><a href="listarCategorias.du?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="listarCategorias.du?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="listarCategorias.du?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>
	</div>	
	</div>
<div><%@ include file="removerModal.html"%></div><!-- Não remover div, pois dará problema nas telas --> 
</body>
</html>
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
						'Deseja realmente remover o Usuário \"' + propMsg + '\"?');
			});

	$(document).on('click', '#removerModalConfirma', function() {
		$("#removerForm").submit();
	});
</script>
<title>LISTAR FORNECEDOR - SIS ESTOQUE FARMÁCIA</title>
</head>
<body>
	<br>
	<div align='center'>
		<strong>${messageErro}</strong>
		<c:remove var="messageErro" scope="session" />
		</div>
	<br>
	<div id="wrapper">
		<div id="login" >
			<h1>Listar Usuários</h1>
			<form method='post'
				action='/SisEstoqueFarmacia/ListarUsuarios.du'>
				<div class="form-group" align="center">
					<label for="username" class="col-sm-2 control-label">Buscar Usuário </label>
					<div class="col-sm-10" style="width: 70%"> 
						<input type='text' name='filtro' id="usuarioId" class="form-control" />
					</div>	
				</div>
				<div align="left">
						<input type='submit' class="btn btn-danger" value='Pesquisar'>
				</div>
				<br>
			</form>
			<br>
			<br>
			<table class="table tabelaCentro">
				<th cellpadding='3'>ID</th>
				<th cellpadding='3'>NOME</th>
				<th cellpadding='3'>CPF</th>
				<th cellpadding='1'>MATRÍCULA</th>
				<th cellpadding='2'>LOGIN</th>
				<th cellpadding='3'>TIPO</th>
				<th cellpadding='3'>AÇÕES</th>
				

				<c:forEach var="usuario" items="${usuarios}">

					<tr>
						<td align='center'>${usuario.id}</td>
						
						<td align='center'>${usuario.nome}</td>
						
						<td align='center'>${usuario.cpf}</td>

						<td align='center'>${usuario.matricula}</td>

						<td align='center'>${usuario.login}</td>
						
						<td align='center' >${usuario.tipo}</td>

						<td align='center'>
						
						
						<a style="margin-right: 1px;" href="/SisEstoqueFarmacia/EditarUsuarioGenerico.du?idusuario=${usuario.id}&usuarioTipo=${usuario.tipo}">
						<img src="imagens/editar.png" alt="EDITAR" title="EDITAR" style="float: center; width: 20px;" /></a>
						
						<a href="#" class="open-RemoverModal" data-id="${usuario.id}" data-msg="${usuario.nome}" data-toggle="modal" data-target="#removerModal">
						<img src="imagens/excluir.png" alt="REMOVER" title="REMOVER" style="float: center; width:20px;" /></a>
						
						
<%-- 						<a 	href="/SisEstoqueFarmacia/EditarFornecedorServlet.du?idusuario=${usuario.id}">editar</a> --%>
<%-- 						<a href="/SisEstoqueFarmacia/removerFornecedorServlet.du?idusuario=${usuario.id}">remover</a> --%>
						</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${not empty qtdePages}">
			<div align="center">
				<ul class="pagination">
					<c:if test="${not empty param.pag}">				
						<li><a href="ListarUsuarios.du?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="ListarUsuarios.du?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="ListarUsuarios.du?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>
		</div>
	</div>
	<div><%@ include file="removerModalUsuario.html"%></div>
</body>
</html>
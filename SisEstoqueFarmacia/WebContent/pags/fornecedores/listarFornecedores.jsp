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
<title>LISTAR FORNECEDOR - SIS ESTOQUE FARMÁCIA</title>
</head>
<body>
	<br>
	<br>
	<div id="wrapper">
		<div id="login" >
			<h1>LISTAR FORNECEDORES</h1>
			<form method='post'
				action='/SisEstoqueFarmacia/ListarFornecedorServlet.du'>
				<div class="form-group" align="center">
					<label for="username" class="col-sm-2 control-label">Buscar Fornecedor </label>
					<div class="col-sm-10" style="width: 70%"> 
						<input type='text' name='filtro' id="fornecedorId" class="form-control" />
					</div>	
				</div>
				<div align="left">
						<input type='submit' class="btn btn-danger" value='Pesquisar'>
					</p>
				</div>
				<br>
			</form>
			<br>
			<br>
			<table class="table tabelaCentro">
				<th cellspacing='2'>CÓDIGO</th>
				<th cellpadding='3'>NOME</th>
				<th cellpadding='3'>RG</th>
				<th cellpadding='3'>CNPJ</th>
				<th cellpadding='3'>FONE</th>
				<th cellpadding='3'>BAIRRO</th>
				<th cellpadding='3'>CEP</th>
				<th cellpadding='3'>RUA</th>
				<th cellpadding='3'>NUMERO</th>
				<th cellpadding='3'>CIDADE</th>
				<th cellpadding='3'>ESTADO</th>
				<th cellpadding='3'>AÇÕES</th>

				<c:forEach var="pessoaJuridica" items="${juridicas}">

					<tr>
						<td align='center'>${pessoaJuridica.id}</td>

						<td align='center'>${pessoaJuridica.nome}</td>

						<td align='center'>${pessoaJuridica.rg} / ${pessoaJuridica.uf}</td>
						
						<td align='center'>${pessoaJuridica.cnpj}</td>

						<td align='center'>${pessoaJuridica.telefone}</td>

						<td align='center'>${pessoaJuridica.endereco.bairro}</td>

						<td align='center'>${pessoaJuridica.endereco.cep}</td>

						<td align='center'>${pessoaJuridica.endereco.rua}</td>

						<td align='center'>${pessoaJuridica.endereco.numero}</td>

						<td align='center'>${pessoaJuridica.endereco.cidade}</td>

						<td align='center'>${pessoaJuridica.endereco.estado}</td>

						<td align="center">
						
						
						<a style="margin-right: 5px;"
							href="/SisEstoqueFarmacia/EditarFornecedorServlet.du?idpessoaJuridica=${pessoaJuridica.id}">
							<img src="imagens/editar.png" alt="EDITAR" title="EDITAR" style="float: center; width: 20px;" /></a>
							<a href="#" class="open-RemoverModal" data-id="${pessoaJuridica.id}" data-msg="${pessoaJuridica.nome}" data-toggle="modal" data-target="#removerModal">
							<img src="imagens/excluir.png" alt="REMOVER" title="REMOVER" style="float: center; width:20px;" /></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${not empty qtdePages}">
			<div align="center">
				<ul class="pagination">
					<c:if test="${not empty param.pag}">				
						<li><a href="ListarFornecedorServlet.du?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="ListarFornecedorServlet.du?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="ListarFornecedorServlet.du?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>
		</div>
	</div>
	<div><%@ include file="removerModalFornecedor.html"%></div>
</body>
</html>
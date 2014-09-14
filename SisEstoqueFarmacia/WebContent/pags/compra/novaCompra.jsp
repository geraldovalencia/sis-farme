<%@ include file="/../../principal.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	$(function() {
		$("#produtoCompra")
				.autocomplete(
						{
							source : function(request, response) {
								$
										.ajax({
											url : "/SisEstoqueFarmacia/AutoCompleteProdutoServlet.du?filtro="
													+ request.term,
											type : "GET",
											dataType : "json",
											success : function(data) {

												response($.map(data, function(
														i, v) {
													return {
														label : i,
														value : v
													};
												}));
											}
										});
							},
							select : function(event, ui) {
								$("#idProduto").val(ui.item.value);
								ui.item.value = ui.item.label;
								$("#produto").val(ui.item.value);
								$("#botaoAdd").prop("disabled", false);
							}
						});
	});
</script>
<title>EDITAR Compra - SIS ESTOQUE FARMÁCIA</title>
</head>
<body>
	<br>
	<c:if test="${apagarClienteSessao != null}">
		<c:remove var="apagarClienteSessao" scope="session" />
	</c:if>
	<div id="wrapper" style="margin-top: 1%;">
		<div id="login">
			<h1>REGISTRO DE NOVA COMPRA - PEDIDO</h1>

			<c:set var="idAtualFornecedor" value="${null}" />
			<c:set var="idProdutoAtual" value="${null}" />

			<c:choose>
				<c:when test="${fornecedor.nome == null}">

					<form action="TelaCadastroCompraSessao.du">
						<table cellpadding="1" cellspacing="0" style="margin-left: 8%;">
							<tbody>
								<tr class="active">
									<td align="center"><h4>
											<strong>FORNECEDOR</strong>
										</h4></td>
								</tr>
								<tr>
									<input type="hidden" id="codigoFornecedorVenda"
										name="codigofornecedor" class="form-control" />

									<td><input type="text"
										placeholder="Digite e espere pesquisar" id="fornecedorVenda"
										required="true" name="fornecedorNome"
										class="form-control ui-autocomplete-input fornecedorVenda" />
									</td>
									<td><input type="submit" class="btn btn-warning"
										id="botaoAdd" value="Adicionar" disabled="true" /></td>
								</tr>
							</tbody>
						</table>
					</form>
					<table cellpadding="1" cellspacing="0" style="margin-left: 8%;">
						<tr>
							<td><h4>* <small>É necessário digitar a primeira letra e esperar o sistema carregar opções.</small></h4></td>
						</tr>
					</table>
					<br>
					<table align="left" cellpadding="1" cellspacing="0"
						style="margin-left: 8%;">
						<tbody>
							<tr class="active">
								<td align="center"><h4>
										<strong>PRODUTO</strong>
									</h4></td>
								<td align="center"><h4>
										<strong>QTDE</strong>
									</h4></td>
								<td align="center"><h4>
										<strong>DATA</strong>
									</h4></td>

							</tr>
							<tr align="center">

								<td><input type="text" readonly="true" id="produtoCompra"
									required="true" name="produtoNome"
									class="form-control ui-autocomplete-input " /></td>
								<td><input type="number" readonly="true" min="1" max="99"
									class="form-control" maxlength="2" placeholder="Número"
									name="quantidade" style="width: 75%" required="true"></td>
								<td><input type="text" readonly="true" class="form-control"
									value="${dataAtual}" name="dataCompra" required="true"></td>
								<td><input type="hidden" readonly="true"
									id="codigofornecedorCompra" value="${fornecedor.id}"
									name="codigofornecedor" class="form-control"></td>
								<td><input type="hidden" readonly="true" id="idUsuario"
									value="${usuarioLogado.id}" name="idUsuario"
									class="form-control ui-autocomplete-input fornecedorCompra"></td>

								<c:choose>
									<c:when test="${idAtualFornecedor != null}">
										<td><input type="submit" value="Adicionar"
											class="btn btn-warning"></td>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
							</tr>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div id='usuarioLogado' style="margin-left: 8%;">
						<h4>
							<br>
							<strong>USUARIO:</strong> ${fn:toUpperCase(usuarioLogado.nome)}<br>
							<br> <strong>FORNECEDOR:</strong>
							${fn:toUpperCase(fornecedor.nome)} <br>
							<br>
							<c:set var="idAtualFornecedor" value="${fornecedor.nome}" />
						</h4>
					</div>


					<form method="post" action="TelaCadastroCompraServlet.du">
						<table align="left" cellpadding="1" cellspacing="0"
							style="margin-left: 8%;">
							<tbody>
								<tr class="active">
									<td align="center"><h4>
											<strong>PRODUTO</strong>
										</h4></td>
									<td align="center"><h4>
											<strong>QTDE</strong>
										</h4></td>
									<td align="center"><h4>
											<strong>DATA</strong>
										</h4></td>

								</tr>
								<tr align="center">
									<input type="hidden" id="idProduto" name="codigoProduto"
										class="form-control" />

									<td><input type="text"
										placeholder="Digite e espere pesquisar" id="produtoCompra"
										required="true" name="produtoNome"
										class="form-control ui-autocomplete-input " /></td>
									<td><input type="number" min="1" max="99"
										class="form-control" maxlength="2" placeholder="Número"
										name="quantidade" style="width: 75%" required="true"></td>
									<c:choose>
										<c:when test="${dataAtual == null}">
											<td><input type="date" class="form-control"
												placeholder="DD/MM/AA" name="dataCompra" required="true"></td>
										</c:when>
										<c:otherwise>
											<td><input type="text" readonly="true"
												class="form-control" value="${dataAtual}" name="dataCompra"
												required="true"></td>
										</c:otherwise>
									</c:choose>
									<td><input type="hidden" id="codigofornecedorCompra"
										value="${fornecedor.id}" name="codigofornecedor"
										class="form-control"></td>
									<td><input type="hidden" id="idUsuario"
										value="${usuarioLogado.id}" name="idUsuario"
										class="form-control ui-autocomplete-input fornecedorCompra"></td>

									<c:choose>
										<c:when test="${idAtualFornecedor != null}">
											<td><input type="submit" id="botaoAdd" value="Adicionar"
												disabled="true" class="btn btn-warning"></td>
										</c:when>
										<c:otherwise>

										</c:otherwise>
									</c:choose>
								</tr>
							</tbody>
						</table>
					</form>

				</c:otherwise>
			</c:choose>
			<br>
			<br>
			<br>
			<br>
			<table cellpadding="1" cellspacing="0" style="margin-left: 8%;">
				<tr>
					<td><h4>* <small>É necessário digitar a primeira letra e esperar o sistema carregar opções.</small></h4></td>
				</tr>
			</table>
			
			<br>
			<br>



			<form method="post" action="SalvarCompraServlet.du">



				<table align="center" style="width: 85%;" border="1" cellpadding="1"
					cellspacing="0" class="table">
					<tbody>
						<tr
							style="clear: both; font-size: 300%; width: 120px; height: 30px; background-color: black; color: #FFFFFF;">
							<td align="center"><h4>
									<strong>Codigo</strong>
								</h4></td>
							<td align="center"><h4>
									<strong>Unidade</strong>
								</h4></td>
							<td align="center"><h4>
									<strong>Produto</strong>
								</h4></td>
							<td align="center"><h4>
									<strong>Quantidade</strong>
								</h4></td>
							<td align="center"><h4>
									<strong>Preço</strong>
								</h4></td>
							<td align="center"><h4>
									<strong>Ação</strong>
								</h4></td>
						</tr>
						<c:if test="${compra != null and not empty compra.itemMovimentos}">
							<c:forEach var="item" items="${compra.itemMovimentos}">
								<tr align='center'>

									<td>${item.produto.id}</td>
									<c:set var="idProdutoAtual" value="${item.produto.nome}" />
									<td>${item.produto.unidade.nome}</td>

									<td>${item.produto.nome}</td>

									<td><fmt:formatNumber type="number"
											value='${item.quantidade}' maxFractionDigits="0" /></td>

									<c:set var="calculoPreco"
										value="${item.produto.precovenda * item.quantidade}" />
									<td align='center'>R$ ${calculoPreco}</td>

									<td><a
										href='/SisEstoqueFarmacia/removerProdutoCompraServlet.du?iditem=${item.produto.id}'>remover</a>
									</td>
								</tr>
								<c:set var="total" value="${total + calculoPreco}" />
							</c:forEach>
						</c:if>
						<tr
							style="clear: both; font-size: 300%; width: 120px; height: 80px; background-color: #006666; color: #FFFFFF;">
							<td colspan="6" align="center"><strong>TOTAL: R$ <fmt:formatNumber
										value="${total}" pattern="#,#00.00#" /></strong></td>
						</tr>
					</tbody>
				</table>
				<div align="center">
					<input type="hidden" name="total" value="${total}" />

					<c:choose>
						<c:when test="${idProdutoAtual != null}">
							<br>
							<input type="submit" class="btn btn-danger"
								value="Finalizar Pedido">
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>

				</div>
				<br>
			</form>
		</div>
	</div>

</body>
</html>
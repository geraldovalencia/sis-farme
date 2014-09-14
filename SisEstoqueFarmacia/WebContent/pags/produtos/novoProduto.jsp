
<%@ include file="/../../principal.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../styles.css' />
<title>NOVO PRODUTO - SIS ESTOQUE FARM√ÅCIA</title>
<style>
#wrapper {
	width: 70%;
}
</style>
<body>
	<br>
	<br>
	<br>
	<div id="wrapper">
		<div id="login" align="center">
			<h1>NOVO PRODUTO</h1>

			<form method='post' action='TelaCadastroProdutoServlet.du'>

				<table class='table tabelaCentro'>
					<tr>
						<td align='center'><h4>CATEGORIA</h4></td>
						<td align='center'><h4>UNIDADE</h4></td>
						<td align='center'><h4>NOME</h4></td>
						<td align='center'><h4>QTDADE</h4></td>
						<td align='center'><h4>PRE«O</h4></td>
					<tr align='center'>
						<td><select name='categoria' class="form-control" required
							aria-required="true">
								<option value=''>-- Selecione --</option>
								<c:forEach items="${categorias}" var="categoria">
									<option value='${categoria.id}'>${categoria.nome}</option>
								</c:forEach>
						</select></td>

						<td><select name='unidade' class="form-control" required
							aria-required="true">
								<option value=''>-- Selecione --</option>
								<c:forEach items="${unidades}" var="unidade">
									<option value='${unidade.id}'>${unidade.nome}</option>
								</c:forEach>
						</select></td>

						<td><div  class="form-group has-success has-feedback">
								<input type="text" class="form-control"
									id="inputSuccess2" name='novoProduto' required="true" /> <span
									class="glyphicon form-control-feedback">*</span>
							</div></td>
						<td><input style="width: 40%"  type='number' placeholder="QTD"
							class="form-control" name='qtde_estoque' required="true" /></td>
						<td><input type='text' name='preco' id="preco" class="form-control" required="true"/></td>
					</tr>
				</table>
				<table class='table tabelaCentro'>
				<tr>
					<td align='center'><h4>N∫ LOTE</h4></td>
					<td align='center'><h4>REGISTRO MSM</h4></td>
					<td align='center'><h4>MARCA</h4></td>
				</tr>
				<tr>
					<td><div  class="form-group">
								<input type="text" class="form-control" id="numeroLoteMedicamento"
								name='numeroLoteMedicamento' required="true" /> 
					</div></td>
					<td><div  class="form-group">
								<input type="text" class="form-control"
									id="registroMSMedicamento" name='registroMSMedicamento' required="true" /> 
					</div></td>
					<td><div  class="form-group">
								<input type="text" class="form-control"
									id="marca" name='marca' required="true" />
					</div></td>
				</tr>
				</table>
				<br>
				<div style="width: 20%;">
					<input type='submit' class="btn btn-danger" value='Salvar' />
				</div>
				<br>
			</form>

		</div>
	</div>
<div id="wrapper">
		<div id="login">
		
		<h4>(*) Campo ObrigatÛrio - <small>… necess·rio preencher o campo.</small></h4>
		</div>
	</div>	
</body>
</html>

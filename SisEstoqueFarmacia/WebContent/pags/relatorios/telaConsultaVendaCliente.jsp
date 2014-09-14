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
		<div id="login" align="center">
			<h1>CONSULTA DE VENDAS POR CLIENTE</h1>
			<form action="RelatorioVendaClientePesquisaServlet.du">
						<table cellpadding="1" cellspacing="0" style="margin-left: 8%;">
						<tbody><tr class="active">
							<td align="center"><h4><strong>CLIENTE</strong></h4></td>
						</tr>
						<tr>
							<input type="hidden" placeholder="ID" id="codigoClienteVenda" name="pessoaId" class="form-control" />
							
							<td><input type="text" placeholder="DIGITE O NOME"id="clienteVenda" required="true" name="nomePessoa" class="form-control ui-autocomplete-input clienteVenda" />
							</td>
							<td><input type="submit" id="botaoAdd" value="Adicionar" disabled="true" class="btn btn-warning" /></td>
						</tr>
						</tbody>
						</table><br><br>
						<h4><strong>Atenção !!!</strong> <small>É necessário digitar a primeira letra e esperar o sistema carregar opções.</small></h4>
					</form>	<br><br>
			
</body>
</html>
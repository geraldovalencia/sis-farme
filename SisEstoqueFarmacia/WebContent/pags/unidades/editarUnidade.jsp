<%@ include file="/../../principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EDITAR DE UNIDADE - SIS ESTOQUE FARMÁCIA</title>
<style>
#wrapper {
	width: 50%;
}
</style>	
</head>
<body>
	<br><br>
	<div id="wrapper">
		<div id="login" align="center">
			<h1>EDITAR UNIDADE</h1>
			<form method='get'
				action='/SisEstoqueFarmacia/EditarUnidadeServlet.du'>
				<!-- QUando é usado parametros, se usa o param.   se não, caso use o atributte, pode chamar direto -->
				<div class="form-group">
					<label class="col-sm-2 control-label"> NOVA UNIDADE</label>
					<div class="col-sm-10">
						<input type="hidden" name='idUnidade'
							value="${unidade != null ? unidade.id : null}" /> 
							<input
							type='text' name='filtro' class="form-control" required = "true"
							value="${unidade != null ? unidade.nome : null}" />
					</div>
				</div>
				<div style="clear: both" /></div><br>
				<p align="center">
					<input type='submit' class="btn btn-danger"
						value='Cadastrar Unidade'>
				</p><br>
			</form>
			<br>
		</div>
	</div>
</body>
</html>
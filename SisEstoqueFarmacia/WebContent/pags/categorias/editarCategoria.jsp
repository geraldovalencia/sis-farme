<%@ include file="/../../principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>EDITAR CATEGORIAS - SIS ESTOQUE FARMÁCIA</title>
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
		<div id="login">
			<h1>EDITAR CATEGORIA TERAPÊUTICA</h1>
			<form method='get'
				action='/SisEstoqueFarmacia/EditarCategoriaServlet.du'>
				<!-- QUando é usado parametros, se usa o param.   se não, caso use o atributte, pode chamar direto -->
				<div class="form-group">
					<label class="col-sm-2 control-label"> NOVA CATEGORIA</label>
					<div class="col-sm-10">
						<input type="hidden" name='idCategoria' 
							value="${categoria != null ? categoria.id : ''}" /> <input
							type='text' name='filtro' class="form-control" required = "true"
							value="${categoria != null ? categoria.nome : ''}" />
					</div>
				</div>
				<div style="clear: both" /></div>
				<br>

				<div class="checkbox">
					<label for="checaControlado"> 
						Produto Controlado ?
					</label> <input type="checkbox" name="checaControlado" id="checaControlado" ${categoria.controlado == true ? "checked='checked'" : ''}>

				</div>
				<p align="center">
					<input type='submit' class="btn btn-danger"
						value='Cadastrar categoria'>
				</p>
				<br>
			</form>
			<br>
		</div>
	</div>
</body>
</html>
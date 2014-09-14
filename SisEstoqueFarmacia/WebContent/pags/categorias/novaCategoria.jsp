<%@ include file="/../../principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NOVA CATEGORIA - SIS ESTOQUE FARMÁCIA</title>
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
			<h1>NOVA CATEGORIA TERAPÊUTICA</h1>
			<form method='get'
				action='/SisEstoqueFarmacia/telaCadastroCategoria.du'>
				<div class="form-group">
					<label class="col-sm-2 control-label"> NOVA CATEGORIA</label>
					<div class="col-sm-10">
						<input type='text' name='filtro' class="form-control" required = "true"
							value='${filtro != null && !filtro.equals("")? filtro : ""}'>
					</div>
				</div>
				<div style="clear: both" /></div>

				<div class="form-group">
					<div class="checkbox">
						<label> <input type="checkbox" name='checaControlado'>
							Produto Controlado ?
						</label>
					</div>

				</div>
				<p align="center">
					<input type='submit' class="btn btn-danger"
						value='Cadastrar categoria'>
				</p><br>
			</form>
		</div>
		<div style="clear: both" /></div>
	</div>
</body>
</html>
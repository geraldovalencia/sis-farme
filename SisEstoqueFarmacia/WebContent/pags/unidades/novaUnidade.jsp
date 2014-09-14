<%@ include file="/../../principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../styles.css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NOVA UNIDADE - SIS ESTOQUE FARMÁCIA</title>
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
			<h1>NOVA UNIDADE</h1>
			<form method='get'
				action='/SisEstoqueFarmacia/TelaCadastroUnidadeServlet.du'>
				<div class="form-group">
					<label class="col-sm-2 control-label"> NOVA UNIDADE</label>
					<div class="col-sm-10">
						<input type='text' name='filtro' class="form-control" required = "true"
							value='${filtro != null && !filtro.equals("")? filtro : ""}'>
					</div>
				</div>
				<div style="clear: both" /></div>
				<br>
				<p align="center">
					<input type='submit' class="btn btn-danger"
						value='Cadastrar Unidade'>
				</p>
				<br>
			</form>
		</div>
		
	</div>
</body>
</html>
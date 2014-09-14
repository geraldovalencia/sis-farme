<%@ include file="/../../principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../styles.css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NOVO FARMACEUTICO - SIS ESTOQUE FARMÁCIA</title>
<script language='JavaScript'>
function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if (tecla==8 || tecla==0) return true;
	else  return false;
    }
}
</script>
<style>
.CSSTableGenerator {
	width: 50%;
}

#login {
	width: auto;
	position: 0px;;
}

#wrapper p.button input {
	width: auto;
}
</style>
</head>
<body>
	<br>
	<br>
	<div id="wrapper">
		<div id="login" align="center">
			<h1>Editar FARMACÊUTICO</h1>
			<form method='get'
				action='/SisEstoqueFarmacia/EditarUsuarioServlet.du'>


				<div style="width: 60%">

					<div class="form-group">
						<label class="col-sm-2 control-label">NOVO NOME </label>
						<div class="col-sm-10">
							<input type='text' class="form-control" name='nome'
								required="true"
								value='${userEdit != null ? userEdit.nome : ""}'><br>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">NOVA SENHA</label>
						<div class="col-sm-10">
							<input type='password' placeholder="Digite sua nova senha" class="form-control" name='senha'
								required="true"> <br>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">MATRÍCULA</label>
						<div class="col-sm-10">
							<input type='text' size='10' required="true"
							 maxlength="6" name='matricula' onkeypress='return SomenteNumero(event)' 
							 class="form-control matricula" value='${userEdit != null ? userEdit.matricula : ""}'>
						<br>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">CRF</label>
						<div class="col-sm-10">
							<input type='text' required="true" maxlength="6" name='crf' 
							onkeypress='return SomenteNumero(event)' class="form-control"
							value='${userEdit != null ? userEdit.crf : ""}'>
						<br>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">TITULAÇÃO</label>
						<div class="col-sm-10">
							<select class="form-control" name='titulacao' id='titulacao' required
								aria-required="true">
									<option value="Graduado" selected="selected">Graduado</option>
									<option value="Pós Graduado">Pós Graduado</option>
									<option value="Mestre">Mestre</option>
									<option value="Doutor">Doutor</option>
							</select><br>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10"></div>
						<input type='submit' class="btn btn-danger"
							value='Editar'> <br>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
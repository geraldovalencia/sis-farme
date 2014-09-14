<%@ include file="/../../principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../styles.css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NOVO Administrador - SIS ESTOQUE FARMÁCIA</title>
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
	<div align='center'>
		<strong>${messageErro}</strong>
		<c:remove var="messageErro" scope="session" />
		</div>
	<br>
	<div id="wrapper">
		<div id="login" align="center" >
			<h1>Novo ADMINISTRADOR</h1>
			<form method='post'
				action='/SisEstoqueFarmacia/TelaCadastroUsuario.du'>
				
				
			<div style="width: 60%">
				
				<div class="form-group">
					<label class="col-sm-2 control-label">NOVO NOME </label>
					<div class="col-sm-10">
						<input type='text' class="form-control" name='nome' required = "true"
							value='${nome != null && !nome.equals("")? nome : ""}'><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">NOVO LOGIN</label>
					<div class="col-sm-10">
						<input type='text' class="form-control" name='login' required = "true"
							value='${login != null && !login.equals("")? login : ""}'><br>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">NOVA SENHA</label>
					<div class="col-sm-10">
						<input type='password' class="form-control" name='senha' required = "true">
						<br>
					</div>
				</div>	
				<div class="form-group">
					<label class="col-sm-2 control-label">EMPRESA</label>
					<div class="col-sm-10">
						<input type='text' class="form-control" name='empresaTerceirizada' required = "true">
						<br>
					</div>
				</div>	
				
				<div class="form-group has-success has-feedback">
						<label class="col-sm-2 control-label">MATRÍCULA</label>
						<div class="col-sm-10">
							<input type='text' size='10' required="true" maxlength="6" name='matricula' onkeypress='return SomenteNumero(event)' 
							class="form-control matricula" id="inputSuccess2">
							<span class="glyphicon form-control-feedback">*</span>
						<br>
						</div>
					</div>
				<div class="form-group has-success has-feedback">
						<label class="col-sm-2 control-label">CPF</label>
						<div class="col-sm-10">
							<input type='text' required="true" name='cpf' 
							onkeypress='return SomenteNumero(event)' class="form-control cpf">
							<span class="glyphicon form-control-feedback">*</span>
							<p class="help-block">* Campo Obrigatório</p>
						<br>
						</div>
					</div>
				<div class="form-group">
					<div class="col-sm-10">
					</div>	
					<input type='submit' class="btn btn-danger" value='Cadastrar Novo Usuario'>
					<br>
				</div>	
			</div>	
					
			</form>
		</div>
	</div>
	<div id="wrapper">
		<div id="login">
		
		<h4>(*) Campo Obrigatório - <small>É necessário preencher o campo.</small></h4>
		</div>
	</div>
</body>
</html>
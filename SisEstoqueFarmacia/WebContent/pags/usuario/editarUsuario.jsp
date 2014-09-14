<%@ include file="/../../principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../styles.css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Usuario - SIS ESTOQUE FARMÁCIA</title>
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
			<h1>Editar USUARIO</h1>
			<form method='post'
				action='/SisEstoqueFarmacia/EditarUsuarioServlet.du'>
				
				
			<div style="width: 60%">
				
				<div class="form-group">
				
				<input type='hidden' name='idUserAposEdicao' value='${userEdit != null ? userEdit.id : null}'/>
				
					<label class="col-sm-2 control-label">NOVO NOME </label>
					<div class="col-sm-10">
						<input type='text' class="form-control" name='nome' required = "true"
							value='${userEdit != null ? userEdit.nome : ""}'/><br>
					</div>
				</div>
				<div class="form-group has-success has-feedback">
					<label class="col-sm-2 control-label">NOVA SENHA</label>
					<div class="col-sm-10">
						<input type='password' placeholder="Digite sua nova senha" 
						class="form-control" name='senha' required = "true"/>
						<span class="glyphicon form-control-feedback">*</span>
						<br>
					</div>
				</div>	
				<div class="form-group has-success has-feedback">
						<label class="col-sm-2 control-label">MATRÍCULA</label>
						<div class="col-sm-10">
							<input type='text' size='10' required="true"
							 maxlength="6" name='matricula' onkeypress='return SomenteNumero(event)' 
							 class="form-control matricula" 
							 value='${userEdit != null ? userEdit.matricula : ""}'/>
							 <span class="glyphicon form-control-feedback">*</span>
						<br>
						</div>
					</div>
					
					
				<c:if test="${userEdit.tipo == 'ADMINISTRADOR'}">
				<div class="form-group">
					<label class="col-sm-2 control-label">EMPRESA</label>
					<div class="col-sm-10">
						<input type='text' value='${adm != null ? adm.empresaTerceirizada : ""}' 
						class="form-control" name='empresaTerceirizada' required = "true"/>
						<br>
					</div>
				</div>	
				</c:if>
				<c:if test="${userEdit.tipo == 'FARMACEUTICO'}">
				<div class="form-group has-success has-feedback">
						<label class="col-sm-2 control-label">CRF</label>
						<div class="col-sm-10">
							<input value="${farmaceutico != null ? farmaceutico.crf : ''}" 
							type='number'	required="true" name="crf" id="crf" 
						 class="form-control crf"/>
						 <span class="glyphicon form-control-feedback">*</span>
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
				</c:if>
				<c:if test="${userEdit.tipo == 'GERENTE'}">
				<div class="form-group">
						<label class="col-sm-2 control-label">SETOR</label>
						<div class="col-sm-10">
						<input type='text' class="form-control" name='setor'
						value='${ger != null ? ger.setor : ""}'
								required="true"/><br>
						</div>
					</div>
				</c:if>
				<c:if test="${userEdit.tipo == 'VENDEDOR'}">
				<div class="form-group">
						<label class="col-sm-2 control-label">SETOR</label>
						<div class="col-sm-10">
						<input type='text' class="form-control" name='setorVendedor'
						value='${ven != null ? ven.setorVendedor : ""}'
								required="true"/><br>
						</div>
					</div>
				</c:if>
				
				<div class="form-group has-success has-feedback">
						<label class="col-sm-2 control-label">CPF</label>
						<div class="col-sm-10">
							<input type='text' required="true" name='cpf' 
							onkeypress='return SomenteNumero(event)' class="form-control cpf"
							value='${userEdit != null ? userEdit.cpf : ""}'/>
							<span class="glyphicon form-control-feedback">*</span>
							<p class="help-block">* Campo Obrigatório</p>
						<br>
						</div>
					</div>
				
				<div class="form-group">
					<input type='submit' class="btn btn-danger" value='Editar'>
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
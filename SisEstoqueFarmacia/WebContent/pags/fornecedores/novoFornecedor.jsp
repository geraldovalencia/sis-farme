<%@ include file="/../../principal.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>NOVO FORNECEDOR - SIS ESTOQUE FARMÁCIA</title>
<style>
#wrapper {
	width: 40%;
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
		<div id="login">
			<form class="form-horizontal"
				action="/SisEstoqueFarmacia/TelaCadastroFornecedor.du"
				autocomplete="on">
				<h1>NOVO FORNECEDOR</h1>
				<br><br>
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">Nome </label>
					<div class="col-sm-10">
						<input type='text' name='filtro' id="username" required = "true"
							class="form-control"
							value='${filtro != null && !filtro.equals("")? filtro : ""}' />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">
						Celular</label>
					<div class="col-sm-10">
						<input type='text' name='celular' id="password"
							class="form-control fonemask"
							value='${celular != null && !celular.equals("")? celular : ""}' />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label"> Email</label>
					<div class="col-sm-10">
						<input type='text' name='emal' class="form-control"
							value='${emal != null && !emal.equals("")? emal : ""}' />
					</div>
				</div>
				<div class="form-group has-success has-feedback">
					<label for="password" class="col-sm-2 control-label"> CNPJ</label>
					<div class="col-sm-10">
						<input type='text' class="form-control cnpj" name='cnpj' id='cnpj' required = "true"
							value='${cnpj != null && !cnpj.equals("")? cnpj : ""}' />
					<span class="glyphicon form-control-feedback">*</span>
					</div>
				</div>
				
				
				<div class="form-group has-success has-feedback">
					<label for="password" class="col-sm-2 control-label"> RG</label>
					<div class="col-sm-10">
						<input type='text' class="form-control rg" name='rg' required = "true"
							value='${pessoa != null ? pessoa.rg : ""}' />
						<span class="glyphicon form-control-feedback">*</span>	
					</div>
				</div>			
				<div class="form-group has-success has-feedback">			
					<label for="password" class="col-sm-2 control-label">Órgão Expedidor</label>
					<div class="col-sm-10"  style="width: 40%; float: left;">
						<input type='text' class="form-control" name='orgaoExpedidor' required = "true"
							value='${pessoa != null ? pessoa.orgaoExpedidor : ""}' />
					<span class="glyphicon form-control-feedback">*</span>
					</div><label>UF</label>
					<div class="col-sm-10" style="width: 35%; float: right;">
						<select name='uf' class="form-control" required
							aria-required="true">
								<option value=''>-- UF --</option>
								<c:forEach items="${ufs}" var="ufs">
									<option>${ufs}</option>
								</c:forEach>
						</select>
					<span class="glyphicon form-control-feedback">*</span>
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">
						Telefone</label>
					<div class="col-sm-10">
						<input type='text' name='telefone' class="form-control fonemask" required = "true"
							value='${telefone != null && !telefone.equals("")? telefone : ""}' />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label"> CEP</label>
					<div class="col-sm-10">
						<input type='text' name='cep' id="cep" maxlength="8" required = "true" class="form-control cepmask"
							value='${cep != null && !cep.equals("")? cep : ""}' />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label"> Rua</label>
					<div class="col-sm-10">
						<input type='text' name='rua' class="form-control" id="rua"
							value='${rua != null && !rua.equals("")? rua : ""}' />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">
						Numero</label>
					<div class="col-sm-10">
						<input type='text' name='numero' class="form-control"
							value='${numero != null && !numero.equals("")? numero : ""}' />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">
						Bairro</label>
					<div class="col-sm-10">
						<input type='text' name='bairro' class="form-control" id="bairro"
							value='${bairro != null && !bairro.equals("")? bairro : ""}' />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">
						Cidade</label>
					<div class="col-sm-10">
						<input type='text' name='cidade' class="form-control" id="cidade"
							value='${cidade != null && !cidade.equals("")? cidade : ""}'>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">
						Estado</label>
					<div class="col-sm-10">
						<input type='text' name='estado' class="form-control" id="estado"
							value='${estado != null && !estado.equals("")? estado : ""}'>
					</div>
				</div>
				<div class="form-group">
				<p align="center">
					<input type="submit" class="btn btn-danger" value="Salvar" />
				</p><br>
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
$(document).ready(function() {
		$("#cep").change(function() {
			getEndereco($("#cep").val());
		});
	});

	$(document).ready(function() {

		// Configuração padrão.
		$("#currency").maskMoney();

		// Configuração para campos de Real.
		$("#preco").maskMoney({
			showSymbol : true,
			symbol : "R$",
			decimal : ".",
			thousands : "."
		});

		// Configuração para mudar a precisão da máscara. Neste caso a máscara irá aceitar 3 dígitos após a virgula.
		$("#precision").maskMoney({
			precision : 3
		});
	});

	$(function() {
		$("#cliente")
				.autocomplete(
						{
							source : function(request, response) {
								$
										.ajax({
											url : "/SisEstoqueFarmacia/AutoCompleteClienteServlet.du?filtro="
													+ request.term,
											type : "GET",
											dataType : "json",
											success : function(data) {		
												response(data);												
											}											
										});
							}
						});

		$(function() {
			$("#clienteVenda")
					.autocomplete(
							{
								source : function(request, response) {
									$
											.ajax({
												url : "/SisEstoqueFarmacia/AutoCompleteClienteServlet.du?filtro="
														+ request.term,
												type : "GET",
												dataType : "json",
												success : function(data) {		
													response(data);												
												}											
											});
								},
								select : function(event, ui){
									alert(ui.item.label);
									alert(ui.item.value);								
								}
							});
		
		$("#produto").autocomplete(
						{
							source : function(request, response) {
								$
										.ajax({
											url : "/SisEstoqueFarmacia/AutoCompleteProdutoServlet.du?filtro="
													+ request.term,
											type : "GET",
											dataType : "json",
											success : function(data) {
												response(data);
											}
										});
							}
						});
		$("#categoriaId").autocomplete(
				{
					source : function(request, response) {
						$
								.ajax({
									url : "/SisEstoqueFarmacia/AutoCompleteCategoriaServlet.du?categoria="
											+ request.term,
									type : "GET",
									dataType : "json",
									success : function(data) {
										response(data);
									}
								});
					}
				});
		$("#unidadeId").autocomplete(
				{
					source : function(request, response) {
						$
								.ajax({
									url : "/SisEstoqueFarmacia/AutoCompleteUnidadeServlet.du?filtro="
											+ request.term,
									type : "GET",
									dataType : "json",
									success : function(data) {
										response(data);
									}
								});
					}
				});
		$("#fornecedorId").autocomplete(
				{
					source : function(request, response) {
						$
								.ajax({
									url : "/SisEstoqueFarmacia/AutoCompleteFornecedorServlet.du?filtro="
											+ request.term,
									type : "GET",
									dataType : "json",
									success : function(data) {
										response(data);
									}
								});
					}
				});
		$("#usuarioId").autocomplete(
				{
					source : function(request, response) {
						$
								.ajax({
									url : "/SisEstoqueFarmacia/AutoCompleteUsuarioServlet.du?filtro="
											+ request.term,
									type : "GET",
									dataType : "json",
									success : function(data) {
										response(data);
									}
								});
					}
				});
	});
	$(document).on(
			'click',
			'.open-RemoverModal',
			function() {
				var propValue = $(this).data('id');
				var propMsg = $(this).data('msg');
				$('#removerModalPropValue').val(propValue);
				$('#removerModalMessage').text(
						'Deseja realmente remover \"' + propMsg
								+ '\"?');
			});
	
	$(document).on('click', '#removerModalConfirma', function() {
		$("#removerForm").submit();
	});

	jQuery(function($) {
		$(".cpf").mask("999.999.999-99");
		$("#cnpj").mask("99.999.999/9999-99");
		$(".fonemask").mask("(99) 9999-9999");
		$(".cepmask").mask("99.999-999");
		$(".matricula").mask("9999-9");
		});
	});
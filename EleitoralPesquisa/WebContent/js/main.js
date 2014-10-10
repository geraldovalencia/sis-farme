$(document).ready(function() {

    escolhe_candidato();

    envia_voto();

    corrige();

//    modal_captcha();

    btn_foms_captcha();

});

//#dialog_captcha #captcha_container #form_validaCaptcha

function escolhe_candidato() {

    var idx = "";

    var idc, identificacao = "";

    $(".container-main .content-main .linhas .candidatos").click(function() {

        idx = $(".container-main .content-main .linhas .candidatos").index(this);

        idc = $(".container-main .content-main .linhas .candidatos").eq(idx).attr('data-candidato');

        identificacao = $(".container-main .content-main .linhas .candidatos").eq(idx).attr('data-identificacao');

        $(".container-main .content-main .linhas .candidatos").find(".btn_confirma").show();

        $(".container-main .content-main .linhas .candidatos").eq(idx).find(".btn_confirma").hide();

        candidato_change(idc, identificacao);

    });

    $(".container-main .controls .control-btn2 #voto_branco").click(function() {

        $(".container-main .content-main .linhas .candidatos").find(".btn_confirma").show();

        candidato_change('', 'voto_branco');

    });

}

function candidato_change(valor, identificacao) {
     $.ajax({

                type: "POST",

                url: "home/getSession",

                data: {
                    'cand' : valor,
                    'identificacao' : identificacao
                },

                dataType: 'json',

                success: function(data)

                {

                  console.log(data);

                }

            });


    $("#dialog_captcha").dialog('open');

}

function envia_voto() {

    $(".container-main .controls .control-btns #dispara_form").click(function() {

        $(".container-main .controls #form_voto #envia_voto").trigger('click');

    });

}

function corrige() {

    $(".container-main .controls .control-btns #voto_corrige").click(function() {

        candidato_change(' ', ' ');

        $(".container-main .content-main .linhas .candidatos").removeClass('off');

        $(".container-main .controls .control-btns:eq(2)").addClass('disable');



    });

}


function modal_captcha() {

    $("#dialog_captcha").dialog({

        closeOnEscape: false,

        autoOpen: false,

        modal: true,

        resizable: false,

        draggable: false,

        title: ' ',

        width: 990

    });

    $('.ui-dialog-titlebar').hide();

}

function btn_foms_captcha() {

    $('#captcha_container #btns_controls a').click(function(e) {

        e.stopPropagation();

        var id = this.id;

        if (id == 'btn_captcha_corrige') {

            $("#dialog_captcha").dialog("close");

            $('#dialog_captcha #captcha_container #form_validaCaptcha .texto_erro').html('');

            $('#dialog_captchat #captcha_container #form_validaCaptcha input').html('');

        } else if (id == 'btn_captcha_confirma') {

            $('#captcha_container #form_validaCaptcha').submit();

        }

    });

}
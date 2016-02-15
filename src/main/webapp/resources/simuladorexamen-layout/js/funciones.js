PrimeFaces.locales['es'] = {
	closeText : 'Cerrar',
	prevText : 'Anterior',
	nextText : 'Siguiente',
	monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
			'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre',
			'Diciembre' ],
	monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago',
			'Sep', 'Oct', 'Nov', 'Dic' ],
	dayNames : [ 'Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves',
			'Viernes', 'Sábado' ],
	dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab' ],
	dayNamesMin : [ 'D', 'L', 'M', 'X', 'J', 'V', 'S' ],
	weekHeader : 'Semana',
	firstDay : 1,
	isRTL : false,
	showMonthAfterYear : false,
	yearSuffix : '',
	timeOnlyTitle : 'Sólo hora',
	timeText : 'Tiempo',
	hourText : 'Hora',
	minuteText : 'Minuto',
	secondText : 'Segundo',
	currentText : 'Fecha actual',
	ampm : false,
	month : 'Mes',
	week : 'Semana',
	day : 'Día',
	allDayText : 'Todo el día'
};

var $col, $lbl, a;
function focusBtn() {
	$('#formRespuesta\\:btns tr').each(function() {
		$col = $(this).find('td').children();
		for (var i = 0; i < $col.length; i++) {
			$btn = $col.children([ 0 ]);
			a = $col.parent()[1];
			a = a.getElementsByTagName('label')
			$lbl = $col.parents().find(a);
			if ($btn.hasClass('ui-state-active')) {
				$lbl.addClass('labelFocus');
			} else {
				$lbl.removeClass('labelFocus');
			}
		}
	});

	return false;
}

var $col1, $lbl1, a1;
function focusBtn1(form) {
	$('#' + form + '\\:btns tr').each(function() {
		$col1 = $(this).find('td').children();
		for (var i = 0; i < $col1.length; i++) {
			$btn1 = $col1.children([ 0 ]);
			a1 = $col1.parent()[1];
			a1 = a1.getElementsByTagName('label')
			$lbl1 = $col1.parents().find(a1);
			if ($btn1.hasClass('ui-state-active')) {
				$lbl1.addClass('labelFocus');
			} else {
				$lbl1.removeClass('labelFocus');
			}
		}
	});

	return false;
}

function mostarPanel(panel) {
	$panelPrincipal = $('#panelPrincipal');
	$panelInsertar = $('#' + panel);
	$panelPrincipal.slideToggle();
	$panelInsertar.slideToggle();
	return false;
}

function mostarPanel1(panel1, panel2) {
	$panelPrincipal = $('#' + panel1);
	$panelInsertar = $('#' + panel2);
	$panelPrincipal.slideToggle();
	$panelInsertar.slideToggle();
	return false;
}

function mostarPanelBusqueda(id) {
	$panelBusqueda = $('#' + id);
	$panelBusqueda.slideToggle();
	return false;
}

function comprobarAbrir(xhr, status, args, id) {
	if (!args.validationFailed && args.abrir) {
		PF(id).show();
	}
}

function comprobarCerrar(xhr, status, args, id) {
	if (!args.validationFailed && args.cerrar) {
		PF(id).hide();
	}
}

function comprobarInsertar(xhr, status, args, id) {
	if (!args.validationFailed && args.cerrar) {
		mostarPanel(id);
	}
}

function comprobar1(xhr, status, args, panel1, panel2) {
	if (!args.validationFailed && args.cerrar) {
		mostarPanel1(panel1, panel2);
	}
}

function comprobar(xhr, status, args, id) {
	if (!args.validationFailed && args.cerrar) {
		mostarPanel(id);
	}
}

function mostrarIcono(id) {
	$('#' + id).removeClass("OcultarIcono");
}

function ocultarIcono(id) {
	$('#' + id).addClass("OcultarIcono");
}

function click(id) {
	$('#' + id).click();
}

var minterval;
window.onload = function() {
	var $btnTimer = $('#formTimer\\:btnTimer')
	$btnTimer.click();
}
function obtenerTiempo() {
	var $cronometro = $('#formTimer\\:cronometro');
	$timer = $('#formTimer\\:timer');
	var tiempo = $timer.text();
	console.log(tiempo)
	$cronometro.text(tiempo);
	minterval = setInterval(function() {
		tiempo--;
		if (tiempo < 0) {
			tiempo = 0;
		}
		$cronometro.text(tiempo);
		if ($cronometro.text() == '0') {
			console.log('entre')
			$btn1 = $('#formTimer\\:updPreRep');
			$btn1.click();
			clearInterval(minterval);
		}
	}, 1000);
}
function successPregunta(xhr, status, args) {
	if (args.vistaCalificacion != false) {
		var $btnTimer = $('#formTimer\\:btnTimer')
		$btnTimer.click();
		console.log('success');
	}
}

PrimeFaces.widget.Schedule.prototype._oldInit = PrimeFaces.widget.Schedule.prototype.init;
PrimeFaces.widget.Schedule.prototype.init = function(cfg) {
	cfg.columnFormat = {
		month : 'ddd',
		week : 'ddd',
		day : 'dddd d/M'
	};

	this._oldInit.apply(this, arguments);
};
PrimeFaces.locales['pt_br'] = {
	closeText : 'Fechar',
	prevText : 'Anterior',
	nextText : 'Próximo',
	currentText : 'Hoje',
	monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
			'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
	monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago',
			'Set', 'Out', 'Nov', 'Dez' ],
	dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta',
			'Sábado' ],
	dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
	dayNamesMin : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
	weekHeader : 'dd/MM/yyy',
	firstDay : 0,
	isRTL : false,
	showMonthAfterYear : false,
	yearSuffix : 'dd/MM/yyyy',
	month : 'Mês',
	week : 'Semana',
	day : 'Dia',
	ampm: false,  
	allDayText : 'Dia Todo'
};
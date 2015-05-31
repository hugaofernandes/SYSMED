package br.com.sysmed.controladores;


import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import br.com.sysmed.DTO.AnoMesConsulta;
import br.com.sysmed.DTO.AnoMesInfoQtd;
import br.com.sysmed.DTO.MesDiaConsulta;
import br.com.sysmed.dao.EstatisticasDAO;

@ManagedBean
@ViewScoped
public class EstatisticasView {
	private LineChartModel consultasPorAno;
	private LineChartModel consultasPorMes;
	private BarChartModel especialidadePorMes;

	private EstatisticasDAO daoEstatistica;

	@PostConstruct
	public void init() {
		this.daoEstatistica = new EstatisticasDAO();
		this.montarConsultaPorAno();
		this.montarConsultaPorMes();
		this.montarEspecialidadePorMes();
	}

	private void montarConsultaPorAno() {

		List<AnoMesConsulta> results = daoEstatistica.getConsultaPorAno();
		consultasPorAno = new LineChartModel();

		ChartSeries consultas = new ChartSeries();
		consultas.setLabel("Consultas");
		for (AnoMesConsulta a : results) {
			consultas.set(a.getAnoMes(), a.getQtdConsultas());
		}
		consultasPorAno.addSeries(consultas);

		consultasPorAno.setTitle("Consultas por ano");
		consultasPorAno.setLegendPosition("e");
		consultasPorAno.setShowPointLabels(true);
		consultasPorAno.getAxes().put(AxisType.X, new CategoryAxis("Meses"));
		Axis yAxis = consultasPorAno.getAxis(AxisType.Y);
		yAxis.setLabel("Consultas");
		yAxis.setMin(0);
	}

	private void montarConsultaPorMes() {
		List<MesDiaConsulta> results = daoEstatistica.getConsultaPorMes();
		consultasPorMes = new LineChartModel();

		ChartSeries consultas = new ChartSeries();
		consultas.setLabel("Consultas");
		for (MesDiaConsulta a : results) {
			consultas.set(a.getDia(), a.getQtdConsultas());
		}
		consultasPorMes.addSeries(consultas);

		consultasPorMes.setTitle("Consultas este mes");
		consultasPorMes.setLegendPosition("e");
		consultasPorMes.setShowPointLabels(true);
		consultasPorMes.getAxes().put(AxisType.X, new CategoryAxis("Dias"));
		Axis yAxis = consultasPorAno.getAxis(AxisType.Y);
		yAxis.setLabel("Consultas");
		yAxis.setMin(0);

	}

	private void montarEspecialidadePorMes() {
		especialidadePorMes = new BarChartModel();
		AnoMesInfoQtd result = daoEstatistica.getEspecPorAno();
		
	
		
		for (Map.Entry<String, List<AnoMesConsulta>> entry : result.getData().entrySet()) {
			ChartSeries serie = new ChartSeries();
			serie.setLabel(entry.getKey());
			for(AnoMesConsulta a:entry.getValue()){
				serie.set(a.getAnoMes(), a.getQtdConsultas());
			}
			especialidadePorMes.addSeries(serie);
		}	
		
		
		especialidadePorMes.setTitle("Especialidade por ano");
		especialidadePorMes.setLegendPosition("e");
		especialidadePorMes.setShowPointLabels(true);
		especialidadePorMes.getAxes().put(AxisType.X, new CategoryAxis("Meses"));
		especialidadePorMes.setStacked(true);
		Axis yAxis = especialidadePorMes.getAxis(AxisType.Y);
		yAxis.setLabel("Consultas");
		yAxis.setMin(0);

	}

	public LineChartModel getConsultasPorAno() {
		return consultasPorAno;
	}

	public void setConsultasPorAno(LineChartModel consultasPorAno) {
		this.consultasPorAno = consultasPorAno;
	}

	public LineChartModel getConsultasPorMes() {
		return consultasPorMes;
	}

	public void setConsultasPorMes(LineChartModel consultasPorMes) {
		this.consultasPorMes = consultasPorMes;
	}

	public BarChartModel getEspecialidadePorMes() {
		return especialidadePorMes;
	}

	public void setEspecialidadePorMes(BarChartModel especialidadePorMes) {
		this.especialidadePorMes = especialidadePorMes;
	}
}

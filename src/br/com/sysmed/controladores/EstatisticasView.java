package br.com.sysmed.controladores;

import java.util.List;

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
import br.com.sysmed.dao.EstatisticasDAO;


@ManagedBean
@ViewScoped
public class EstatisticasView {
	private BarChartModel consultasPorAno;
	
	@PostConstruct
    public void init() {
		this.montarConsultaPorAno();	
	}

	private void montarConsultaPorAno() {
		EstatisticasDAO dao = new EstatisticasDAO();
		List<AnoMesConsulta> results = dao.getConsultaPorMes();
		consultasPorAno = new BarChartModel(); 
		
		ChartSeries consultas = new ChartSeries();
        consultas.setLabel("Consultas");
        for(AnoMesConsulta a:results){
        	  consultas.set(a.getAnoMes(),a.getQtdConsultas());	
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

	public BarChartModel getConsultasPorAno() {
		return consultasPorAno;
	}

	public void setConsultasPorAno(BarChartModel consultasPorAno) {
		this.consultasPorAno = consultasPorAno;
	}
}

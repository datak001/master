package com.example.reportingcrb.view;

import com.example.reportingcrb.control.*;
import javax.servlet.annotation.WebServlet;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.Cursor;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.HorizontalAlign;
import com.vaadin.addon.charts.model.Labels;
import com.vaadin.addon.charts.model.Legend;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsColumn;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.addon.charts.model.StackLabels;
import com.vaadin.addon.charts.model.Stacking;
import com.vaadin.addon.charts.model.Title;
import com.vaadin.addon.charts.model.Tooltip;
import com.vaadin.addon.charts.model.VerticalAlign;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.Align;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("reportingcrb")
public class ReportingcrbUI extends UI {

	FetchData data;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ReportingcrbUI.class, widgetset = "com.example.reportingcrb.widgetset.ReportingcrbWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		final HorizontalLayout hlayout = new HorizontalLayout();
		
		getPage().setTitle("CRBs_per_customer");
		
		hlayout.setMargin(true);
		hlayout.setSpacing(true);
		setContent(hlayout);

		Table table = new Table();
		table.addStyleName("priority_table");
		
		// Define two columns for the built-in container
		table.addContainerProperty("Priority", String.class, null);
		table.addContainerProperty("Count", Integer.class, null);

		// Add a few other rows using shorthand addItem()
		data = new FetchData();
		int countBlocker = 12;
		table.addItem(new Object[] { "Blocker", countBlocker }, 1);

		int countCritical = 1;
		table.addItem(new Object[] { "Critical", countCritical }, 2);

		int countMajor = 2;
		table.addItem(new Object[] { "Major", countMajor }, 3);

		int countMinor = 3;
		table.addItem(new Object[] { "Minor", countMinor }, 4);

		int countTrivial = 4;
		table.addItem(new Object[] { "Trivial", countTrivial }, 5);

		Chart chart = new Chart(ChartType.PIE);
		Configuration conf = chart.getConfiguration();
		conf.setTitle("Priority CRB's");

		PlotOptionsPie plotOptions = new PlotOptionsPie();
		plotOptions.setCursor(Cursor.POINTER);
		Labels dataLabels = new Labels();
		dataLabels.setEnabled(true);
		dataLabels.setFormatter("''+ this.point.name +': '+ Highcharts.numberFormat(this.percentage,2) +' %'");
		plotOptions.setDataLabels(dataLabels);
		conf.setPlotOptions(plotOptions);

		final DataSeries series = new DataSeries();
		series.add(new DataSeriesItem("Blocker", 10));
		series.add(new DataSeriesItem("Critical", 13));
		series.add(new DataSeriesItem("Major", 43));
		series.add(new DataSeriesItem("Minor", 44));
		series.add(new DataSeriesItem("Trivial", 55));
		conf.setSeries(series);

		Chart chart2 = new Chart(ChartType.COLUMN);
		Configuration conf2 = chart2.getConfiguration();
		conf2.setTitle(new Title("Customer issues overview"));

		XAxis xAxis = new XAxis();
		xAxis.setCategories(new String[] { "Customer Reported Bugs", "Customer Reported Problems", "Customer Questions", "Customer Requests" });
		conf2.addxAxis(xAxis);

		YAxis yAxis = new YAxis();
		yAxis.setMin(0);
		StackLabels sLabels = new StackLabels(true);
		yAxis.setStackLabels(sLabels);
		conf2.addyAxis(yAxis);

		Legend legend = new Legend();
		legend.setHorizontalAlign(HorizontalAlign.CENTER);
		legend.setFloating(true);
		legend.setVerticalAlign(VerticalAlign.BOTTOM);
		legend.setX(-100);
		legend.setY(20);
		conf2.setLegend(legend);

		Tooltip tooltip = new Tooltip();
		tooltip.setFormatter("function() { return ''+ this.x +'"
				+ "'+this.series.name +': '+ this.y +''+'Total: '+ this.point.stackTotal;}");
		conf2.setTooltip(tooltip);

		PlotOptionsColumn plotOptions2 = new PlotOptionsColumn();
		plotOptions2.setStacking(Stacking.NORMAL);
		Labels labels2 = new Labels(true);
		plotOptions2.setDataLabels(labels2);
		conf2.setPlotOptions(plotOptions2);

		conf2.addSeries(new ListSeries("Waiting for customer response for more than 6 weeks", new Number[] { 3, 4, 4, 2, 5 }));
		conf2.addSeries(new ListSeries(new Number[] { 2, 2, 3, 2, 1 }));
		

		chart.drawChart(conf);
		chart2.drawChart(conf2);
		table.setPageLength(table.size());
		hlayout.addComponent(table);
		hlayout.addComponent(chart);
		
	}

}
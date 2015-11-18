package com.example.reportingcrb.view;

import com.example.reportingcrb.control.*;
import com.example.reportingcrb.model.ReportingcrbModel;

import javax.servlet.annotation.WebServlet;
import com.vaadin.addon.charts.Chart;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("reportingcrb")
public class ReportingcrbUI extends UI {

	FetchData data;
	ReportingcrbModel model;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ReportingcrbUI.class, widgetset = "com.example.reportingcrb.widgetset.ReportingcrbWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		model = new ReportingcrbModel();
		Table table = model.createCRBtable();
		Chart pieChart = model.createCRBpieChart();
		Chart columnChart = model.createCRBcolumnChart();
		Table table2 = model.createCRBtable();
		
		final VerticalLayout vlayout = new VerticalLayout();
		setContent(vlayout);

		final HorizontalLayout hlayout = new HorizontalLayout();
		getPage().setTitle("CRBs_per_customer");
		hlayout.addComponent(table);
		hlayout.addComponent(pieChart);
		
		final HorizontalLayout hlayout_2 = new HorizontalLayout();
		hlayout_2.addComponent(table2);
		hlayout_2.addComponent(columnChart);
		
		vlayout.addComponent(hlayout);
		vlayout.setComponentAlignment(hlayout, Alignment.TOP_CENTER);
		vlayout.addComponent(hlayout_2);
		vlayout.setComponentAlignment(hlayout_2, Alignment.MIDDLE_CENTER);
	}

}
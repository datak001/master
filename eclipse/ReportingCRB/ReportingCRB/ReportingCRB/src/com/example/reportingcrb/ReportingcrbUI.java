package com.example.reportingcrb;

import javax.servlet.annotation.WebServlet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.Cursor;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.Labels;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("reportingcrb")
public class ReportingcrbUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ReportingcrbUI.class, widgetset = "com.example.reportingcrb.widgetset.ReportingcrbWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final HorizontalLayout layout = new HorizontalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table("Priority Cr's");

		// Define two columns for the built-in container
		table.addContainerProperty("Priority", String.class, null);
		table.addContainerProperty("Count", Integer.class, null);

		// Add a few other rows using shorthand addItem()
		int countBlocker = fetchData("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20csv%20where%20url%3D%27http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes.csv%3Fs%3DBMW.DE%2CDAI.DE%26f%3Dsnc4xl1d1t1c1p2ohgv%26e%3D.csv%27%20and%20columns%3D%27symbol%2Cname%2Ccurrency%2Cexchange%2Cprice%2Cdate%2Ctime%2Cchange%2Cpercent%2Copen%2Chigh%2Clow%2Cvolume%27&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
		table.addItem(new Object[] { "Blocker", countBlocker }, 1);

		int countCritical = fetchData("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20csv%20where%20url%3D%27http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes.csv%3Fs%3DBMW.DE%2CDAI.DE%26f%3Dsnc4xl1d1t1c1p2ohgv%26e%3D.csv%27%20and%20columns%3D%27symbol%2Cname%2Ccurrency%2Cexchange%2Cprice%2Cdate%2Ctime%2Cchange%2Cpercent%2Copen%2Chigh%2Clow%2Cvolume%27&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
		table.addItem(new Object[] { "Critical", countCritical }, 2);

		int countMajor = fetchData("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20csv%20where%20url%3D%27http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes.csv%3Fs%3DBMW.DE%2CDAI.DE%26f%3Dsnc4xl1d1t1c1p2ohgv%26e%3D.csv%27%20and%20columns%3D%27symbol%2Cname%2Ccurrency%2Cexchange%2Cprice%2Cdate%2Ctime%2Cchange%2Cpercent%2Copen%2Chigh%2Clow%2Cvolume%27&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
		table.addItem(new Object[] { "Major", countMajor }, 3);

		int countMinor = fetchData("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20csv%20where%20url%3D%27http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes.csv%3Fs%3DBMW.DE%2CDAI.DE%26f%3Dsnc4xl1d1t1c1p2ohgv%26e%3D.csv%27%20and%20columns%3D%27symbol%2Cname%2Ccurrency%2Cexchange%2Cprice%2Cdate%2Ctime%2Cchange%2Cpercent%2Copen%2Chigh%2Clow%2Cvolume%27&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
		table.addItem(new Object[] { "Minor", countMinor }, 4);

		int countTrivial = fetchData("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20csv%20where%20url%3D%27http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes.csv%3Fs%3DBMW.DE%2CDAI.DE%26f%3Dsnc4xl1d1t1c1p2ohgv%26e%3D.csv%27%20and%20columns%3D%27symbol%2Cname%2Ccurrency%2Cexchange%2Cprice%2Cdate%2Ctime%2Cchange%2Cpercent%2Copen%2Chigh%2Clow%2Cvolume%27&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
		table.addItem(new Object[] { "Trivial", countTrivial }, 5);

		// Show exactly the currently contained rows (items)
		table.setPageLength(table.size());
		layout.addComponent(table);

		Chart chart = new Chart(ChartType.PIE);
		Configuration conf = chart.getConfiguration();
		conf.setTitle("");

		PlotOptionsPie plotOptions = new PlotOptionsPie();
		plotOptions.setCursor(Cursor.POINTER);
		Labels dataLabels = new Labels();
		dataLabels.setEnabled(true);
		dataLabels.setFormatter("''+ this.point.name +': '+ this.total");
		plotOptions.setDataLabels(dataLabels);
		conf.setPlotOptions(plotOptions);

		final DataSeries series = new DataSeries();
		series.add(new DataSeriesItem("Blocker", 10));
		series.add(new DataSeriesItem("Critical", 13));
		series.add(new DataSeriesItem("Major", 43));
		series.add(new DataSeriesItem("Minor", 44));
		series.add(new DataSeriesItem("Trivial", 55));
		conf.setSeries(series);

		chart.drawChart(conf);

		layout.addComponent(chart);
	}

	public static int fetchData(String url) {
		int totalCars = 0;
		try {
			URL xmlUrl = new URL(url);
			InputStream in = xmlUrl.openStream();
			Document doc = parse(in);

			doc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is "
					+ doc.getDocumentElement().getNodeName());

			NodeList listOfCars = doc.getElementsByTagName("row");
			totalCars = listOfCars.getLength();
			System.out.println("Total no of cars : " + totalCars);
			System.out.println(doc.getFirstChild().getTextContent());

		} catch (MalformedURLException ex) {
			Logger.getLogger(ReportingcrbUI.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ReportingcrbUI.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return totalCars;
	}

	public static Document parse(InputStream is) {
		Document ret = null;
		DocumentBuilderFactory domFactory;
		DocumentBuilder builder;

		try {
			domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setValidating(false);
			domFactory.setNamespaceAware(false);
			builder = domFactory.newDocumentBuilder();

			ret = builder.parse(is);
		} catch (ParserConfigurationException ex) {
			System.err.println("unable to load XML: " + ex);
		} catch (SAXException ex) {
			System.err.println("unable to load XML: " + ex);
		} catch (IOException ex) {
			System.err.println("unable to load XML: " + ex);
		}
		return ret;
	}

}
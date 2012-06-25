package com.interviewsdb.client.companies;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Companies extends VerticalPanel {

	public Companies() {

		this.setSpacing(5);

		HTML html = new HTML("<b>SELECT A COMPANY FOR THE INTERVIEW:</b>");
		this.add(html);

		this.add(listCompanies());
	}

	private static VerticalPanel listCompanies() {

		VerticalPanel vpMainEvent = new VerticalPanel();

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(40);
		vpMainEvent.add(hp);

		VerticalPanel vpEvent1 = new VerticalPanel();
		hp.add(vpEvent1);
		GetCompanies.getFromID("EXtremeLeanBusiness_1332812176007", vpEvent1);

		VerticalPanel vpEventIOBio = new VerticalPanel();
		hp.add(vpEventIOBio);
		GetCompanies.getFromID("PredictablyWell_1333326032461", vpEventIOBio);

		VerticalPanel vpEvent5 = new VerticalPanel();
		hp.add(vpEvent5);
		GetCompanies.getFromID("FashionMetric_1340074986772", vpEvent5);

		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.setSpacing(40);

		VerticalPanel vpEvent4 = new VerticalPanel();
		hp2.add(vpEvent4);
		GetCompanies.getFromID("CustDevProgram_1339702027533", vpEvent4);

		VerticalPanel vpEvent3 = new VerticalPanel();
		hp2.add(vpEvent3);
		GetCompanies.getFromID("WeddingHappyIPhoneApp_1340317913053", vpEvent3);

		VerticalPanel vpEvent2 = new VerticalPanel();
		hp2.add(vpEvent2);
		GetCompanies.getFromID("WeddingHappyForWeddingPlanners_1340318580026",
				vpEvent2);

		vpMainEvent.add(hp2);

		return vpMainEvent;
	}

}

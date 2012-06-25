package com.interviewsdb.client.companies;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.interviewsdb.client.utilities.UseTracking;

public class CompanyImage extends VerticalPanel {

	public CompanyImage(final JSONObject companyJson) {

		this.setSpacing(5);
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		final String companyUniqueID = ConvertJson.getStringValue(companyJson,
				"ID");

		ClickHandler clickHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				new UseTracking(this.getClass().getName() + "#"
						+ companyUniqueID);

				GetStartupData.get(companyUniqueID, false);
			}
		};

		String imageURL = ConvertJson.getStringValue(companyJson, "image");
		if (imageURL != null) {

			HTML image = new HTML("<a href='#'><img src='" + imageURL
					+ "' border=0 width='50px'></a>");
			image.addClickHandler(clickHandler);
			this.add(image);
		}

		String eventName = ConvertJson
				.getStringValue(companyJson, "entityName");

		HTML name = new HTML("<font size=2 color=blue><a href='#'>" + eventName
				+ "</a></font>");
		name.setWidth("150px");
		name.addClickHandler(clickHandler);
		this.add(name);
	}
}

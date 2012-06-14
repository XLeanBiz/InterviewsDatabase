package com.interviewsdb.client.utilities;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class FormField {

	public static HorizontalPanel getFormField(String label, Widget field) {

		return getFormField(label, "150px", field);
	}

	public static HorizontalPanel getFormField(String label, String labelSize,
			Widget field) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(5);
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HTML title = new HTML(label + ": ");
		title.setWidth(labelSize);
		title.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp.add(title);

		field.setWidth("250px");
		hp.add(field);

		return hp;
	}

	public static VerticalPanel getVerticalFormField(String label, Widget field) {

		VerticalPanel vp = new VerticalPanel();

		vp.setSpacing(5);
		vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		Label title = new Label(label + ": ");
		vp.add(title);

		vp.add(field);

		return vp;
	}

	public static HorizontalPanel getStringField(final String label,
			final String fieldValue) {

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(5);
		hp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		HTML title = new HTML(label + ": ");
		title.setWidth("150px");
		title.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		hp.add(title);

		HTML fieldHTML = new HTML("<b>" + fieldValue + "</b>");
		hp.add(fieldHTML);

		return hp;
	}

}

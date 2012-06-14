package com.interviewsdb.client.home.header;

import co.uniqueid.authentication.client.companies.CompanyIcon;
import co.uniqueid.authentication.client.login.facebook.FacebookLoginPanel;

import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Header extends HorizontalPanel {

	public static VerticalPanel vpCompanies = new VerticalPanel();

	public Header() {

		this.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		this.add(new Logo());

		Label space = new Label(" ");
		space.setWidth("500px");
		this.add(space);

		this.add(CompanyIcon.hpCompanyIcon);

		Label space1 = new Label(" ");
		space1.setWidth("40px");
		this.add(space1);

		this.add(FacebookLoginPanel.hpFacebookLogin);

		Label space2 = new Label(" ");
		space2.setWidth("150px");
		this.add(space2);

		this.add(new BlogIcon());

		Label space3 = new Label(" ");
		space3.setWidth("30px");
		this.add(space3);

		this.add(new FacebookFeedbackButton());
	}
}

package com.interviewsdb.client;

import co.uniqueid.authentication.client.login.facebook.FacebookLoginVerifyer;
import co.uniqueid.authentication.client.login.facebook.InitializeFacebookLogin;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RootPanel;
import com.interviewsdb.client.home.Home;
import com.interviewsdb.client.home.header.Header;

public class InitializeInterviewDatabase {

	private static final String REDIRECT_URL = "http://interviews.startupsdata.appspot.com/";
	private static final String facebookAppID = "290438244385660";

	public static JSONObject companyData = new JSONObject();

	public static void init() {

		Home.vpHeader.clear();
		Home.vpMain.clear();
		Home.vpMain.setWidth("100%");

		RootPanel.get().add(Home.vpHeader, 8, 3);
		RootPanel.get().add(Home.vpMain, 8, 100);

		Home.vpHeader.add(new Header());
	}

	public static void initHome(final String uniqueID) {

		new InitializeFacebookLogin(uniqueID, facebookAppID, REDIRECT_URL,
				null, false);

		Home.vpMain.clear();
		Home.vpMain.add(new Home());
	}

	public static void reinit() {

		Home.vpMain.clear();
		Home.vpMain.add(new Home());

	}

	public static void VerifyFacebookLogin(final String authenticationCode) {

		FacebookLoginVerifyer.authenticate(facebookAppID, authenticationCode,
				REDIRECT_URL, REDIRECT_URL, false);
	}
}

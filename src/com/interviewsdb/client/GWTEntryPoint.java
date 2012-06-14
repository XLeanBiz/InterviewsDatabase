package com.interviewsdb.client;

import co.uniqueid.authentication.client.utilities.EncryptText;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window.Location;
import com.interviewsdb.client.utilities.UseTracking;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTEntryPoint implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		new UseTracking(this.getClass().getName());

		String uniqueID = EncryptText.decrypt(Cookies.getCookie("UniqueID"));
		//uniqueID = "AllineWatkins_1332886062783";

		if (uniqueID == null || uniqueID.equals("null")) {

			String authenticationCode = Location.getParameter("code");

			final String error = Location.getParameter("error_reason");

			if (!((null != error && error.equals("user_denied")) || (authenticationCode == null || ""
					.equals(authenticationCode)))) {

				InitializeInterviewDatabase
						.VerifyFacebookLogin(authenticationCode);
			} else {

				InitializeInterviewDatabase.init();
				InitializeInterviewDatabase.initHome(null);
			}

		} else {

			InitializeInterviewDatabase.init();
			InitializeInterviewDatabase.initHome(uniqueID);
		}

	}
}

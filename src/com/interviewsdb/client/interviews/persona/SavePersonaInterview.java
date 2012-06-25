package com.interviewsdb.client.interviews.persona;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.interviewsdb.client.home.Home;
import com.interviewsdb.client.interviews.CustDevFrameworkService;
import com.interviewsdb.client.interviews.CustDevFrameworkServiceAsync;

public class SavePersonaInterview {

	public static void save() {

		final CustDevFrameworkServiceAsync custDevService = GWT
				.create(CustDevFrameworkService.class);

		custDevService.savePersonaInterview(
				PersonaInterview.interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						Home.vpMain.clear();
						Home.vpMain.add(new Home());
					}
				});

	}
}

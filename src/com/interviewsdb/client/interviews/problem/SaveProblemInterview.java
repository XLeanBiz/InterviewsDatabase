package com.interviewsdb.client.interviews.problem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.interviewsdb.client.home.Home;
import com.interviewsdb.client.interviews.CustDevFrameworkService;
import com.interviewsdb.client.interviews.CustDevFrameworkServiceAsync;

public class SaveProblemInterview {

	public static void save(final JSONObject interview) {

		final CustDevFrameworkServiceAsync custDevService = GWT
				.create(CustDevFrameworkService.class);

		custDevService.saveProblemInterview(interview.toString(),
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

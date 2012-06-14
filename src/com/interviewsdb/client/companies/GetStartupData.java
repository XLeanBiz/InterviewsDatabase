package com.interviewsdb.client.companies;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.interviewsdb.client.InitializeInterviewDatabase;
import com.interviewsdb.client.home.Home;
import com.interviewsdb.client.interviews.InterviewPage;

public class GetStartupData {

	public static void get(final String companyUniqueID) {

		final StartupDataServiceAsync startupdataService = GWT
				.create(StartupDataService.class);

		startupdataService.getStartupData(companyUniqueID,
				new AsyncCallback<String>() {

					public void onFailure(Throwable caught) {

					}

					public void onSuccess(String jsonResult) {

						if (jsonResult != null && !jsonResult.equals("")) {

							JSONObject obj = (JSONObject) JSONParser
									.parseStrict(jsonResult);

							InitializeInterviewDatabase.companyData = obj;

							Home.vpMain.clear();
							Home.vpMain.add(new InterviewPage(companyUniqueID));
						}

					}
				});
	}
}

package com.interviewsdb.client.interviews.problem;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.interviewsdb.client.interviews.CustDevFrameworkService;
import com.interviewsdb.client.interviews.CustDevFrameworkServiceAsync;

public class SaveProblemInterviewField {

	public static void save() {

		final CustDevFrameworkServiceAsync custDevService = GWT
				.create(CustDevFrameworkService.class);

		custDevService.saveProblemInterview(
				ProblemInterview.interview.toString(),
				new AsyncCallback<String>() {

					public void onFailure(final Throwable caught) {
						System.out.println(caught);
					}

					public void onSuccess(String unoUserJson) {

						String interviewID = ConvertJson
								.convertToString(ProblemInterview.interview
										.get("ID"));

						if (interviewID == null) {

							interviewID = unoUserJson;

							ConvertJson.setStringValue(
									ProblemInterview.interview, interviewID,
									"ID");
						}

					}
				});

	}
}

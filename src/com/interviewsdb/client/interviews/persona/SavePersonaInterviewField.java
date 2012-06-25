package com.interviewsdb.client.interviews.persona;

import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.interviewsdb.client.interviews.CustDevFrameworkService;
import com.interviewsdb.client.interviews.CustDevFrameworkServiceAsync;

public class SavePersonaInterviewField {

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

						String interviewID = ConvertJson
								.convertToString(PersonaInterview.interview
										.get("ID"));

						if (interviewID == null) {

							interviewID = unoUserJson;

							ConvertJson.setStringValue(
									PersonaInterview.interview, interviewID,
									"ID");
						}

					}
				});

	}
}

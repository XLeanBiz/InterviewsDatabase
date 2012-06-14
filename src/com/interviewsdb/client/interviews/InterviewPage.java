package com.interviewsdb.client.interviews;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.interviewsdb.client.InitializeInterviewDatabase;
import com.interviewsdb.client.interviews.persona.NewPersonaInterview;
import com.interviewsdb.client.interviews.problem.NewProblemInterview;

public class InterviewPage extends VerticalPanel {

	public static VerticalPanel vpInterview = new VerticalPanel();

	public InterviewPage(final String companyUniqueID) {

		this.setSpacing(20);

		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		final JSONObject newInterview = new JSONObject();

		ConvertJson.setStringValue(newInterview, companyUniqueID, "company");

		String intervieweeID = ConvertJson
				.convertToString(UniqueIDGlobalVariables.uniqueID.get("ID"));
		ConvertJson.setStringValue(newInterview, intervieweeID, "customerName");

		String interviewee = ConvertJson
				.convertToString(UniqueIDGlobalVariables.uniqueID
						.get("entityName"));
		ConvertJson.setStringValue(newInterview, interviewee,
				"customerUniqueID");

		String personaName = ConvertJson
				.convertToString(InitializeInterviewDatabase.companyData
						.get("Persona"));
		ConvertJson.setStringValue(newInterview, personaName, "persona");

		HorizontalPanel hp = new HorizontalPanel();

		hp.setSpacing(10);

		HTML personaLink = new HTML("<a href=#><b>PERSONA</b></a>");
		personaLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				vpInterview.clear();
				vpInterview.add(new NewPersonaInterview(newInterview));
			}
		});

		hp.add(personaLink);

		HTML problemLink = new HTML("<a href=#><b>PROBLEM</b></a>");
		problemLink.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String problem = ConvertJson
						.convertToString(InitializeInterviewDatabase.companyData
								.get("Problem"));
				ConvertJson.setStringValue(newInterview, problem, "problem");

				vpInterview.clear();
				vpInterview.add(new NewProblemInterview(newInterview));
			}
		});
		hp.add(problemLink);

		this.add(hp);

		vpInterview.clear();
		vpInterview.add(new NewPersonaInterview(newInterview));

		this.add(vpInterview);
	}
}

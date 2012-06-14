package com.interviewsdb.client.interviews.persona;

import java.util.Date;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public class ButtonSavePersonaInterview extends Button {

	public ButtonSavePersonaInterview(final JSONObject interview) {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				ConvertJson.setStringValue(interview,
						Long.toString((new Date()).getTime()), "datetime");

				String customerName = ConvertJson.getStringValue(
						UniqueIDGlobalVariables.uniqueID, "entityName");
				ConvertJson.setStringValue(interview, customerName,
						"customerName");

				String customerID = ConvertJson.getStringValue(
						UniqueIDGlobalVariables.uniqueID, "ID");
				ConvertJson.setStringValue(interview, customerID,
						"customerUniqueID");

				// ConvertJson.setStringValue(interview, "", "persona");

				getInterviewQuesitons(interview);

				SavePersonaInterview.save(interview);

			}
		});

	}

	private void getInterviewQuesitons(JSONObject interview) {

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.describeYourself.getHTML(),
				"describeYourself");

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.routine.getHTML(), "routine");

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.mainProblem.getHTML(), "mainProblem");

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.mainProblemRateField
						.getValue(NewPersonaInterview.mainProblemRateField
								.getSelectedIndex()), "mainProblemRate");

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.solutionMainProblem.getHTML(),
				"solutionMainProblem");

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.secondMainProblem.getHTML(),
				"secondMainProblem");

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.secondProblemRateField
						.getValue(NewPersonaInterview.secondProblemRateField
								.getSelectedIndex()), "secondProblemRate");

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.otherProblems.getHTML(), "otherProblems");

		ConvertJson.setStringValue(interview,
				NewPersonaInterview.openComments.getHTML(), "openComments");
	}
}

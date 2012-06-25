package com.interviewsdb.client.interviews.persona;

import java.util.Date;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSavePersonaInterview extends Button {

	public ButtonSavePersonaInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterview();
				SavePersonaInterview.save();
			}
		});

	}

	public static void prepareInterview() {

		ConvertJson.setStringValue(PersonaInterview.interview,
				Long.toString((new Date()).getTime()), "datetime");

		String customerName = ConvertJson.getStringValue(
				UniqueIDGlobalVariables.uniqueID, "entityName");
		ConvertJson.setStringValue(PersonaInterview.interview, customerName,
				"customerName");

		String customerID = ConvertJson.getStringValue(
				UniqueIDGlobalVariables.uniqueID, "ID");
		ConvertJson.setStringValue(PersonaInterview.interview, customerID,
				"customerUniqueID");

		// ConvertJson.setStringValue(interview, "", "persona");

		getInterviewQuesitons();

	}

	private static void getInterviewQuesitons() {

		ConvertJson
				.setStringValue(PersonaInterview.interview,
						PersonaInterview.describeYourself.getHTML(),
						"describeYourself");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.routine.getHTML(), "routine");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.mainProblem.getHTML(), "mainProblem");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.mainProblemRateField
						.getValue(PersonaInterview.mainProblemRateField
								.getSelectedIndex()), "mainProblemRate");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.solutionMainProblem.getHTML(),
				"solutionMainProblem");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.secondMainProblem.getHTML(),
				"secondMainProblem");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.secondProblemRateField
						.getValue(PersonaInterview.secondProblemRateField
								.getSelectedIndex()), "secondProblemRate");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.solutionMainProblem.getHTML(),
				"solutionSecondProblem");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.otherProblems.getHTML(), "otherProblems");

		ConvertJson.setStringValue(PersonaInterview.interview,
				PersonaInterview.openComments.getHTML(), "openComments");
	}
}

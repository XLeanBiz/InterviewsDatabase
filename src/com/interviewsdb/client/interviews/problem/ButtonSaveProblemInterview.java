package com.interviewsdb.client.interviews.problem;

import java.util.Date;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveProblemInterview extends Button {

	public ButtonSaveProblemInterview() {

		this.setText("Save Interview");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				prepareInterviewJson();
				SaveProblemInterview.save();
			}
		});

	}

	public static void prepareInterviewJson() {

		ConvertJson.setStringValue(ProblemInterview.interview,
				Long.toString((new Date()).getTime()), "datetime");

		String customerName = ConvertJson.getStringValue(
				UniqueIDGlobalVariables.uniqueID, "entityName");
		ConvertJson.setStringValue(ProblemInterview.interview, customerName,
				"customerName");

		String customerID = ConvertJson.getStringValue(
				UniqueIDGlobalVariables.uniqueID, "ID");
		ConvertJson.setStringValue(ProblemInterview.interview, customerID,
				"customerUniqueID");

		getInterviewQuesitons();

	}

	private static void getInterviewQuesitons() {

		ConvertJson.setStringValue(ProblemInterview.interview,
				ProblemInterview.problemUnderstand.getHTML(),
				"problemUnderstand");

		ConvertJson.setStringValue(ProblemInterview.interview,
				ProblemInterview.haveProblem.getHTML(), "haveProblem");

		ConvertJson.setStringValue(ProblemInterview.interview,
				ProblemInterview.whyHaveProblem.getHTML(), "whyHaveProblem");

		ConvertJson.setStringValue(ProblemInterview.interview,
				ProblemInterview.problemRateField
						.getValue(ProblemInterview.problemRateField
								.getSelectedIndex()), "problemRate");

		ConvertJson.setStringValue(ProblemInterview.interview,
				ProblemInterview.howSolvingProblem.getHTML(),
				"howSolvingProblem");

		ConvertJson.setStringValue(ProblemInterview.interview,
				ProblemInterview.make5Problem.getHTML(), "make5Problem");

		ConvertJson.setStringValue(ProblemInterview.interview,
				ProblemInterview.openComments.getHTML(), "openComments");
	}

}

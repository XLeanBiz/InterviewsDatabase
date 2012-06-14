package com.interviewsdb.client.interviews.problem;

import java.util.Date;

import co.uniqueid.authentication.client.UniqueIDGlobalVariables;
import co.uniqueid.authentication.client.utilities.ConvertJson;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;

public class ButtonSaveProblemInterview extends Button {

	public ButtonSaveProblemInterview(final JSONObject interview) {

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

				getInterviewQuesitons(interview);

				SaveProblemInterview.save(interview);

			}
		});

	}

	private void getInterviewQuesitons(JSONObject interview) {

		ConvertJson.setStringValue(interview,
				NewProblemInterview.problemUnderstand.getHTML(),
				"problemUnderstand");

		ConvertJson.setStringValue(interview,
				NewProblemInterview.haveProblem.getHTML(), "haveProblem");

		ConvertJson.setStringValue(interview,
				NewProblemInterview.whyHaveProblem.getHTML(), "whyHaveProblem");

		ConvertJson.setStringValue(interview,
				NewProblemInterview.problemRateField
						.getValue(NewProblemInterview.problemRateField
								.getSelectedIndex()), "problemRate");

		ConvertJson.setStringValue(interview,
				NewProblemInterview.whyHaveProblem.getHTML(), "make5Problem");
	}

}

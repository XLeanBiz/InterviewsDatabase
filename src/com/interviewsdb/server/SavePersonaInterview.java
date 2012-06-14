package com.interviewsdb.server;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.JSONUtilities;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.appengine.repackaged.org.json.JSONObject;

public class SavePersonaInterview {

	private static String saveUrl = "https://jsonpfy.startupsdata.appspot.com/SaveDataService";

	public static String save(JSONObject interview) {

		String parameters = "kind=PersonaInterviews";

		if (JSONUtilities.getString(interview, "ID") != null) {

			parameters += "&ID=" + JSONUtilities.getString(interview, "ID");
		}

		parameters += URLUtilities.addSaveParameterString(interview, "company");

		parameters += URLUtilities.addSaveParameterString(interview,
				"interviewer");

		parameters += URLUtilities
				.addSaveParameterString(interview, "datetime");

		parameters += URLUtilities.addSaveParameterString(interview, "persona");

		parameters += URLUtilities.addSaveParameterString(interview,
				"customerName");

		parameters += URLUtilities.addSaveParameterString(interview,
				"customerUniqueID");

		parameters += URLUtilities
				.addSaveParameterString(interview, "videoURL");

		parameters += URLUtilities.addSaveParameterText(interview, "notes");

		parameters += URLUtilities
				.addSaveParameterString(interview, "problem1");

		parameters += URLUtilities
				.addSaveParameterString(interview, "problem2");

		parameters += URLUtilities.addSaveParameterText(interview,
				"describeYourself");

		parameters += URLUtilities.addSaveParameterText(interview, "routine");

		parameters += URLUtilities.addSaveParameterText(interview,
				"mainProblem");

		parameters += URLUtilities.addSaveParameterText(interview,
				"mainProblemRate");

		parameters += URLUtilities.addSaveParameterText(interview,
				"solutionMainProblem");

		parameters += URLUtilities.addSaveParameterText(interview,
				"secondMainProblem");

		parameters += URLUtilities.addSaveParameterText(interview,
				"secondProblemRate");

		parameters += URLUtilities.addSaveParameterText(interview,
				"solutionSecondProblem");
		
		parameters += URLUtilities.addSaveParameterText(interview,
				"otherProblems");

		parameters += URLUtilities.addSaveParameterText(interview,
				"openComments");

		URLUtilities.fetchURLPost(saveUrl,
				parameters + EncryptText.getAuthParameter());

		return interview.toString();
	}
}

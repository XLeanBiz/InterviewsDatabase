package com.interviewsdb.server;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.interviewsdb.client.interviews.CustDevFrameworkService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CustDevFrameworkServiceImpl extends RemoteServiceServlet implements
		CustDevFrameworkService {

	public String getProblem(final String name) {
		return "";
		// return GetProblem.get(name);
	}

	public String savePersonaInterview(final String interview) {

		JSONObject json;
		try {
			json = new JSONObject(interview);

			return SavePersonaInterview.save(json);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}
	
	public String saveProblemInterview(final String interview) {

		JSONObject json;
		try {
			json = new JSONObject(interview);

			return SaveProblemInterview.save(json);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}

}

package com.interviewsdb.client.interviews;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface CustDevFrameworkServiceAsync {

	void getProblem(String name, AsyncCallback<String> callback);

	void savePersonaInterview(String interview, AsyncCallback<String> callback);
	
	void saveProblemInterview(String interview, AsyncCallback<String> callback);
}

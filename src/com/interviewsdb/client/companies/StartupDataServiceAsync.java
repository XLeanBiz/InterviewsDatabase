package com.interviewsdb.client.companies;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface StartupDataServiceAsync {

	void getStartupData(String company, AsyncCallback<String> callback);

}

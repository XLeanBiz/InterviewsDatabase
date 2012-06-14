package com.interviewsdb.server;

import co.uniqueid.authentication.client.utilities.EncryptText;
import co.uniqueid.authentication.server.utilities.URLUtilities;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.interviewsdb.client.companies.StartupDataService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class StartupDataServiceImpl extends RemoteServiceServlet implements
		StartupDataService {

	private static String getUrl = "https://jsonpfy.startupsdata.appspot.com/GetDataService";

	public String getStartupData(final String company) {

		String parameters = "kind=StartupDataTopics&ID="
				+ URLUtilities.encode(company);

		final String jsonTopicString = URLUtilities.fetchURLPost(getUrl,
				parameters + EncryptText.getAuthParameter());

		return jsonTopicString;
	}

}

package com.interviewsdb.client.companies;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("startupdata")
public interface StartupDataService extends RemoteService {

	String getStartupData(String company);


}

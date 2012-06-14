package com.interviewsdb.client.interviews;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("custdevframework")
public interface CustDevFrameworkService extends RemoteService {

	String getProblem(String name);

	String savePersonaInterview(String interview);
	
	String saveProblemInterview(String interview);
}

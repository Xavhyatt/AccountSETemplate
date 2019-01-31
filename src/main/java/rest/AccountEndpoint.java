package rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountService service;

	@Path("/createAccount")
	@POST
	@Produces({"application/json"})
	public String addAccount(String account) {
		return service.addAccount(account);
	}
	
	
	
	
	
}

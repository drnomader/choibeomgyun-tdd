package tdd.chap08.testable;

import tdd.chap08.auth.Customer;
import tdd.chap08.auth.CustomerRepository;
import tdd.chap08.auth.LoginResult;

public class LoginService {

	private AuthService authService = new AuthService();
	private CustomerRepository customerRepo;

	public LoginService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public LoginResult login(String id, String pw) {
		int resp = authService.authenticate(id, pw);

		if (resp == -1) {
			return LoginResult.badAuthKey();
		}
		if (resp == 1) {
			Customer c = customerRepo.findOne(id);
			return LoginResult.authenticated(c);
		} else {
			return LoginResult.fail(resp);
		}
	}
}

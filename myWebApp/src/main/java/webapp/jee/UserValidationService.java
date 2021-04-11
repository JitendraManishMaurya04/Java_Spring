package webapp.jee;

public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		if (user.equals("Jitendra Manish Maurya") && password.equals("12345")) {
			return true;
		}
		return false;
	}

}

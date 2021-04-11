package webapp.springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	UserValidationServiceSprMvc service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "springMvcLogin";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String name, @RequestParam String password, ModelMap model) {
		boolean isUserValid = service.isUserValid(name, password);

		if (isUserValid) {
			model.put("name", name);
			model.put("password", password);
			return "springMvcWelcome";
		} else {
			model.put("errorMessage", "Invalid Credentials!!!");
			return "springMvcLogin";
		}
	}
}

package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.PermissionController;
import controllers.PersonalController;
import entities.Personal;

@RestController
@RequestMapping(Uris.LOGIN)
public class LoginRest {

	public PersonalController personalController;

	public PermissionController permissionController;

	@Autowired
	public void setPersonalController(PersonalController personalController) {
		this.personalController = personalController;
	}

	@Autowired
	public void setPermissionController(PermissionController permissionController) {
		this.permissionController = permissionController;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = Uris.USERNAME)
	public Personal searchByUsername(@PathVariable(value = "username") String username) {
		  Personal personal = personalController.searchByUsername(username);
		  return personal;
	}
	

}

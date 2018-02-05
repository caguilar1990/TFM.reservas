package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.PermissionController;
import controllers.PersonalController;
import entities.Personal;

@RestController
@RequestMapping(Uris.PERSONAL)
public class PersonalRest {

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

	@RequestMapping(method = RequestMethod.GET)
	public List<Personal> getAll() {

		return personalController.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = Uris.ID)
	public Personal searchByID(@PathVariable(value = "id") int id) {
		  Personal personal = personalController.searchByID(id);
		  return personal;
	}
	

	  
	@RequestMapping(method = RequestMethod.POST)
	public void addPersonal(@RequestBody Personal personal) {
		this.personalController.addPersonal(personal);
	}


	@RequestMapping(method = RequestMethod.DELETE , value = Uris.ID)
	public void removePersonal(@PathVariable(value = "id") int id) {
		this.personalController.removePersonal(id);
	}

	
	@RequestMapping(method = RequestMethod.GET, value = Uris.PERSONAL_MAESTROS)
	public List<Personal> findMaestroLaboratorio() {
		List<Personal> maestros = personalController.findMaestroLaboratorio();
		return maestros;
	}

}

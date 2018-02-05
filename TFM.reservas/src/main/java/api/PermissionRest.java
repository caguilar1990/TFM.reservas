package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.PermissionController;
import entities.Permisos;

@RestController
@RequestMapping(Uris.PERMISOS)
public class PermissionRest {
	

	public PermissionController permissionController;

	@Autowired
	public void setPermissionController(PermissionController permissionController) {
		this.permissionController = permissionController;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Permisos> getAll() {

		return permissionController.getAll();
	}

}
